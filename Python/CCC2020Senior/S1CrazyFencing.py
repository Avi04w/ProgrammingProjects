n = int(input())
height = input()
width = input()

height = height.split()
width = width.split()

height = [float(i) for i in height]
width = [float(i) for i in width]

areas = []

for i in range(n):
    areas.append(0.5 * (height[i] + height[i+1]) * width[i])

total_area = 0

for i in areas:
    total_area += i

print(total_area)
