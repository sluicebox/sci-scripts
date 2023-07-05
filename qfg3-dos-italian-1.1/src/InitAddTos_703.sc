;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 703)
(include sci.sh)
(use Actor)
(use System)

(public
	InitAddTos 0
)

(instance InitAddTos of Code
	(properties)

	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0)
		((= temp0 (View new:)) view: 700 signal: -12255)
		(switch param1
			(0
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 251
										y: 189
										scaleSignal: 1
										scaleX: 72
										scaleY: 72
										noun: 9
									)
								)
								(1
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 54
										y: 100
										scaleSignal: 1
										scaleX: 84
										scaleY: 84
										priority: 0
										noun: 10
										signal: (| (temp0 signal:) $0010)
									)
								)
								(2
									(temp0
										view: 700
										loop: 1
										cel: 0
										x: 310
										y: 110
										scaleSignal: 1
										scaleX: 104
										scaleY: 104
										priority: 0
										noun: 11
										signal: (| (temp0 signal:) $0010)
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 92
										y: 86
										scaleSignal: 1
										scaleX: 72
										scaleY: 72
										noun: 12
									)
								)
								(1
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 13
										y: 165
										scaleSignal: 1
										scaleX: 184
										scaleY: 184
										noun: 13
									)
								)
								(2
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 249
										y: 187
										scaleSignal: 1
										scaleX: 184
										scaleY: 184
										noun: 14
									)
								)
							)
						)
					)
					(0
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 700
										loop: 2
										cel: 0
										x: 110
										y: 115
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 15
									)
								)
								(1
									(temp0
										view: 700
										loop: 0
										cel: 0
										x: 270
										y: 81
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 16
									)
								)
								(2
									(temp0
										view: 700
										loop: 1
										cel: 0
										x: 104
										y: 87
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 17
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 700
										loop: 1
										cel: 0
										x: 199
										y: 91
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 18
									)
								)
								(1
									(temp0
										view: 700
										loop: 1
										cel: 0
										x: 303
										y: 200
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										priority: 15
										noun: 19
										signal: (| (temp0 signal:) $0010)
									)
								)
								(2
									(temp0
										view: 700
										loop: 0
										cel: 0
										x: 52
										y: 139
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 20
									)
								)
							)
						)
					)
				)
			)
			(1
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 67
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 21
									)
								)
								(1
									(temp0
										view: 703
										loop: 0
										cel: 1
										x: 280
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 22
									)
								)
								(2
									(temp0
										view: 703
										loop: 1
										cel: 1
										x: 256
										y: 189
										noun: 23
									)
								)
							)
						else
							(switch (mod param2 4)
								(0
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 279
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 24
									)
								)
								(1
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 0
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 25
									)
								)
								(2
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 60
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 26
									)
								)
								(3
									(temp0
										view: 701
										loop: 1
										cel: 0
										x: 247
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 27
									)
								)
							)
						)
					)
					(0
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 0
										cel: 1
										x: 102
										y: 189
										noun: 28
									)
								)
								(1
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 38
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 29
									)
								)
								(2
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 250
										y: 124
										scaleSignal: 1
										scaleX: 83
										scaleY: 83
										noun: 30
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 297
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 31
									)
								)
								(1
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 232
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 32
									)
								)
								(2
									(temp0
										view: 703
										loop: 0
										cel: 1
										x: 266
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 33
									)
								)
							)
						)
					)
				)
			)
			(2
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 0
										cel: 1
										x: 280
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 34
									)
								)
								(1
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 60
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 35
									)
								)
								(2
									(temp0
										view: 701
										loop: 0
										cel: 0
										x: 30
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 36
									)
								)
							)
						else
							(switch (mod param2 4)
								(0
									(temp0
										view: 703
										loop: 1
										cel: 1
										x: 56
										y: 189
										noun: 37
									)
								)
								(1
									(temp0
										view: 701
										loop: 1
										cel: 0
										x: 247
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 38
									)
								)
								(2
									(temp0
										view: 703
										loop: 1
										cel: 1
										x: 256
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 39
									)
								)
								(3
									(temp0
										view: 703
										loop: 0
										cel: 1
										x: 67
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 40
									)
								)
							)
						)
					)
					(0
						(if param3
							(temp0
								view: 700
								loop: 3
								cel: 1
								x: 319
								y: 138
								noun: 41
							)
						else
							(temp0
								view: 700
								loop: 2
								cel: 1
								x: 0
								y: 140
								noun: 42
							)
						)
					)
				)
			)
			(3
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 1
										cel: 0
										x: 242
										y: 119
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 43
									)
								)
								(1
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 66
										y: 98
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 44
									)
								)
								(2
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 25
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 45
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 279
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 46
									)
								)
								(1
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 247
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 47
									)
								)
								(2
									(temp0
										view: 702
										loop: 0
										cel: 1
										x: 48
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 48
									)
								)
							)
						)
					)
					(0
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 105
										y: 100
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 49
									)
								)
								(1
									(temp0
										view: 703
										loop: 1
										cel: 0
										x: 263
										y: 99
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 50
									)
								)
								(2
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 84
										y: 118
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 51
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 312
										y: 189
										noun: 52
									)
								)
								(1
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 201
										y: 189
										noun: 53
									)
								)
								(2
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 89
										y: 123
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 54
									)
								)
							)
						)
					)
				)
			)
			(4
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 66
										y: 198
										z: 100
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 55
									)
								)
								(1
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 25
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 56
									)
								)
								(2
									(temp0
										view: 703
										loop: 1
										cel: 0
										x: 242
										y: 219
										z: 100
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 57
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 702
										loop: 0
										cel: 1
										x: 48
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 58
									)
								)
								(1
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 279
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 59
									)
								)
								(2
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 247
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 60
									)
								)
							)
						)
					)
					(0
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 1
										cel: 0
										x: 263
										y: 99
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 61
									)
								)
								(1
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 84
										y: 118
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 62
									)
								)
								(2
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 105
										y: 100
										scaleSignal: 1
										scaleX: 130
										scaleY: 130
										noun: 63
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 89
										y: 123
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 64
									)
								)
								(1
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 312
										y: 189
										noun: 65
									)
								)
								(2
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 201
										y: 189
										noun: 78
									)
								)
							)
						)
					)
				)
			)
			(5
				(switch param6
					(1
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 0
										cel: 0
										x: 66
										y: 198
										z: 100
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 66
									)
								)
								(1
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 25
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 67
									)
								)
								(2
									(temp0
										view: 703
										loop: 1
										cel: 0
										x: 242
										y: 219
										z: 100
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 68
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 700
										loop: 0
										cel: 1
										x: 90
										y: 182
										noun: 69
									)
								)
								(1
									(temp0
										view: 702
										loop: 0
										cel: 0
										x: 279
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 70
									)
								)
								(2
									(temp0
										view: 702
										loop: 1
										cel: 1
										x: 247
										y: 189
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 71
									)
								)
							)
						)
					)
					(0
						(if param3
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 2
										cel: 0
										x: 70
										y: 190
										priority: 15
										signal: (| (temp0 signal:) $0010)
										noun: 72
									)
								)
								(1
									(temp0
										view: 703
										loop: 2
										cel: 0
										x: 78
										y: 92
										noun: 73
									)
								)
								(2
									(temp0
										view: 700
										loop: 1
										cel: 1
										x: 310
										y: 99
										priority: 8
										signal: (| (temp0 signal:) $0010)
										noun: 74
									)
								)
							)
						else
							(switch (mod param2 3)
								(0
									(temp0
										view: 703
										loop: 2
										cel: 0
										x: 16
										y: 72
										noun: 75
									)
								)
								(1
									(temp0
										view: 703
										loop: 2
										cel: 0
										x: 3
										y: 139
										noun: 76
									)
								)
								(2
									(temp0
										view: 703
										loop: 3
										cel: 0
										x: 252
										y: 129
										noun: 77
									)
								)
							)
						)
					)
				)
			)
		)
		(temp0 init:)
	)
)

