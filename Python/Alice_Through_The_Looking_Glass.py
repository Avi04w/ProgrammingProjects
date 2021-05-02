t = int(input())


def max_y(m, x):
    if m >= 1:
        p = 5 ** (m-1)
        location = x // p
        if location == 0 or location == 4:
            return 0
        elif location == 1 or location == 3:
            return 1 * p + max_y(m - 1, x % p)
        elif location == 2:
            return 2 * p + max_y(m - 1, x % p)
    return 0


y_list = []

for i in range(t):
    m, x, y = input().split(" ")
    m = int(m)
    x = int(x)
    y = int(y)

    if y < max_y(m, x):
        y_list.append("crystal")
    else:
        y_list.append("empty")

for i in y_list:
    print(i)
