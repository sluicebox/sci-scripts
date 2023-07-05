;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1300)
(include sci.sh)
(use Main)
(use RamaRoom)
(use SoundManager)
(use n1111)
(use DText)
(use Str)
(use WalkieTalkie)
(use System)

(public
	creditRoom 0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (if (== argc 2) param2))
	(switch param1
		(1
			(proc1111_7 1000 0 137 0 0 -1 0 temp0)
		)
		(2
			(proc1111_7 1001 213 28 0 0 -1 0 temp0)
		)
		(3
			(proc1111_7 1002 433 137 0 0 -1 0 temp0)
		)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0)
	(= temp0 (if (== argc 2) param2))
	(switch param1
		(1
			(proc1111_7 1008 0 137 0 0 195 0 temp0)
		)
		(2
			(proc1111_7 1009 213 28 0 0 195 0 temp0)
		)
		(3
			(proc1111_7 1010 433 137 0 0 195 0 temp0)
		)
	)
)

(procedure (localproc_2)
	(creditsList dispose:)
)

(procedure (localproc_3 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp4 1300)
	(= temp2 0)
	(= temp3 1)
	(if (> argc 4)
		(= temp2 param5)
		(if (> argc 5)
			(= temp3 param6)
		)
	)
	(= temp1 (Message msgSIZE temp4 param3 param4 temp2 temp3))
	(= temp0 (Str new: (+ temp1 1) {}))
	(Message msgGET temp4 param3 param4 temp2 temp3 (temp0 data:))
	(creditsList
		add:
			((DText new:)
				font: (if (== param4 153) 2207 else 1)
				text: (KArray 8 (temp0 data:)) ; ArrayDup
				fore: 255
				back: 0
				x: param1
				y: param2
				setSize:
				setPri: (+ (GetHighPlanePri) 2)
				init:
				yourself:
			)
	)
	(temp0 dispose:)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp4 1300)
	(= temp2 0)
	(= temp3 1)
	(if (> argc 4)
		(= temp2 param5)
		(if (> argc 5)
			(= temp3 param6)
		)
	)
	(= temp1 (Message msgSIZE temp4 param3 param4 temp2 temp3))
	(= temp0 (Str new: (+ temp1 1) {}))
	(Message msgGET temp4 param3 param4 temp2 temp3 (temp0 data:))
	(creditsList
		add:
			((DText new:)
				font: (if (== param4 153) 2207 else 1)
				text: (KArray 8 (temp0 data:)) ; ArrayDup
				fore: 255
				back: 0
				x: param1
				y: param2
				setSize: 320
				setPri: (+ (GetHighPlanePri) (if (== param3 43) 3 else 1))
				init:
				yourself:
			)
	)
	(temp0 dispose:)
)

(instance creditRoom of RamaRoom
	(properties)

	(method (init)
		(gTheCursor setNormalCursor:)
		((ScriptID 70 15) doit:) ; InvDispose
		(if global123
			(global123 dispose: 1)
		)
		(super init: &rest)
		(WalkieTalkie plane: plane)
		(gExtMouseHandler add: self)
		(if (== gPrevRoomNum 5209) ; humanPlazaRm9
			(SoundManager stopMusic: playMusic: 0 -1 8000)
		)
		(self setScript: creditScript)
	)

	(method (dispose)
		(proc1111_6)
		(gExtMouseHandler delete: self)
		(super dispose:)
	)

	(method (newRoom)
		(SoundManager fadeMusic: 0 20 10 1)
		(gGame panelObj: gGame panelSelector: 636)
	)

	(method (handleEvent event &tmp temp0)
		(if (== (event type:) evMOUSEBUTTON)
			(self newRoom:)
		)
	)
)

(instance creditScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0 1 self)
				(localproc_3 350 230 2 153)
				(localproc_3 350 240 2 154)
			)
			(1
				(localproc_0 2 self)
				(localproc_3 276 250 3 153)
				(localproc_3 276 260 3 154)
			)
			(2
				(localproc_0 3 self)
				(localproc_3 211 230 4 153)
				(localproc_3 211 240 4 154)
			)
			(3
				(localproc_3 276 280 5 153)
				(localproc_3 276 290 5 154)
				(localproc_3 276 304 6 153)
				(localproc_3 276 314 6 154)
				(= seconds 2)
			)
			(4
				(localproc_1 1 self)
			)
			(5
				(localproc_1 2 self)
			)
			(6
				(localproc_1 3 self)
			)
			(7
				(localproc_2)
				(localproc_0 1 self)
				(localproc_3 236 230 7 153)
				(localproc_3 276 242 7 154)
			)
			(8
				(localproc_0 2 self)
				(localproc_3 236 258 9 153)
				(localproc_3 276 280 9 154)
			)
			(9
				(localproc_0 3 self)
				(localproc_3 236 294 8 153)
				(localproc_3 276 306 8 154)
			)
			(10
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 230 230 15 153)
				(localproc_3 281 242 15 154)
			)
			(11
				(localproc_1 1 self)
				(localproc_3 265 256 16 153)
				(localproc_3 281 268 16 154)
			)
			(12
				(localproc_1 3 self)
				(localproc_3 271 306 17 153)
				(localproc_3 281 318 17 154)
			)
			(13
				(= seconds 5)
			)
			(14
				(localproc_1 1 self)
				(localproc_2)
				(localproc_3 281 230 10 153)
				(localproc_3 281 242 10 154)
			)
			(15
				(localproc_1 2 self)
			)
			(16
				(localproc_1 3 self)
			)
			(17
				(localproc_2)
				(localproc_1 1 self)
				(localproc_3 281 230 11 153)
				(localproc_3 281 242 11 154)
			)
			(18
				(localproc_1 2 self)
			)
			(19
				(localproc_1 3 self)
			)
			(20
				(localproc_0 2 self)
			)
			(21
				(localproc_2)
				(localproc_3 266 230 12 153)
				(localproc_3 281 242 12 154)
				(= seconds 3)
			)
			(22
				(localproc_1 1 self)
			)
			(23
				(localproc_1 2 self)
			)
			(24
				(localproc_1 3 self)
			)
			(25
				(localproc_0 1 self)
			)
			(26
				(localproc_0 2 self)
				(localproc_2)
				(localproc_3 291 230 13 153)
				(localproc_3 276 242 13 154)
			)
			(27
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 275 230 19 153)
				(localproc_3 275 244 20 153)
				(localproc_3 275 256 20 154)
			)
			(28
				(localproc_1 1 self)
				(localproc_3 275 270 21 153)
				(localproc_3 275 282 21 154)
			)
			(29
				(localproc_1 3 self)
				(localproc_3 275 296 22 153)
				(localproc_3 275 308 22 154)
			)
			(30
				(= seconds 3)
			)
			(31
				(localproc_2)
				(localproc_1 3 self)
				(localproc_3 261 230 23 153)
				(localproc_3 261 242 23 154)
			)
			(32
				(localproc_0 1 self)
				(localproc_3 261 256 24 153)
				(localproc_3 261 268 24 154)
			)
			(33
				(localproc_1 3 self)
			)
			(34
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 261 210 72 153)
				(localproc_3 261 222 73 153)
				(localproc_3 261 234 73 154)
				(localproc_3 261 248 74 153)
				(localproc_3 261 260 74 154)
				(localproc_3 261 274 75 153)
				(localproc_3 261 286 75 154)
				(localproc_3 261 300 76 153)
				(localproc_3 261 312 76 154)
				(localproc_3 261 326 77 153)
				(localproc_3 261 338 77 154)
			)
			(35
				(= seconds 4)
			)
			(36
				(localproc_2)
				(localproc_0 1 self)
				(localproc_3 246 230 18 153)
				(localproc_3 261 256 18 154)
			)
			(37
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 261 230 14 153)
				(localproc_3 261 244 14 154 1 1)
				(localproc_3 261 256 14 154 1 2)
			)
			(38
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 261 230 14 153)
				(localproc_3 261 244 14 154 2 1)
				(localproc_3 261 256 14 154 2 2)
			)
			(39
				(localproc_2)
				(localproc_1 2 self)
				(localproc_3 261 230 14 153)
				(localproc_3 261 244 14 154 3)
			)
			(40
				(localproc_1 1 self)
			)
			(41
				(localproc_1 3 self)
			)
			(42
				(localproc_0 2 self)
				(localproc_2)
				(localproc_3 245 215 56 153)
				(localproc_3 145 242 57 153)
				(localproc_3 345 242 57 154)
				(localproc_3 145 256 58 153)
				(localproc_3 345 256 58 154)
				(localproc_3 145 270 59 153)
				(localproc_3 345 270 59 154)
				(localproc_3 145 284 60 153)
				(localproc_3 345 284 60 154)
				(localproc_3 145 298 61 153)
				(localproc_3 345 298 61 154)
				(localproc_3 145 312 62 153)
				(localproc_3 345 312 62 154)
				(localproc_3 145 326 63 153)
				(localproc_3 345 326 63 154)
				(localproc_3 145 340 64 153)
				(localproc_3 345 340 64 154)
				(localproc_3 145 354 65 153)
				(localproc_3 345 354 65 154)
				(localproc_3 145 368 66 153)
				(localproc_3 345 368 66 154)
				(localproc_3 145 382 67 153)
				(localproc_3 345 382 67 154)
				(localproc_3 145 396 68 153)
				(localproc_3 345 396 68 154)
				(localproc_3 145 410 69 153)
				(localproc_3 345 410 69 154)
			)
			(43
				(= seconds 4)
			)
			(44
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 145 242 70 153)
				(localproc_3 345 242 70 154)
				(localproc_3 145 256 71 153)
				(localproc_3 345 256 71 154)
			)
			(45
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 200 215 35 153)
				(localproc_3 140 242 36 153)
				(localproc_3 355 242 36 154)
				(localproc_3 140 256 9 153 0 2)
				(localproc_3 355 256 9 154 0 2)
				(localproc_3 140 270 37 153)
				(localproc_3 355 270 37 154)
				(localproc_3 140 284 38 153)
				(localproc_3 355 284 38 154)
				(localproc_3 140 298 39 153)
				(localproc_3 355 298 39 154)
				(localproc_3 140 312 40 153)
				(localproc_3 355 312 40 154)
			)
			(46
				(localproc_2)
				(localproc_3 200 215 35 153)
				(localproc_0 2 self)
				(localproc_3 140 242 41 153)
				(localproc_3 355 242 41 154)
				(localproc_4 140 256 42 153)
				(localproc_3 355 256 42 154)
				(localproc_4 140 270 43 153)
				(localproc_4 355 270 43 154)
				(localproc_3 140 284 44 153)
				(localproc_3 355 284 44 154)
				(localproc_3 140 298 45 153)
				(localproc_3 355 298 45 154)
				(localproc_3 140 312 46 153)
				(localproc_3 355 312 46 154)
				(localproc_3 140 326 47 153)
				(localproc_3 355 326 47 154)
				(localproc_3 140 340 48 153)
				(localproc_3 355 340 48 154)
			)
			(47
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 200 215 35 153)
				(localproc_3 140 242 49 153)
				(localproc_3 355 242 49 154)
				(localproc_3 140 270 50 153)
				(localproc_3 355 270 50 154)
				(localproc_3 140 284 51 153)
				(localproc_3 355 284 51 154)
				(localproc_3 140 298 52 153)
				(localproc_3 355 298 52 154)
				(localproc_3 140 312 53 153)
				(localproc_3 355 312 53 154)
				(localproc_3 140 362 54 153)
				(localproc_3 355 362 54 154)
				(localproc_3 140 388 55 153)
				(localproc_3 355 388 55 154)
			)
			(48
				(localproc_2)
				(localproc_1 1 self)
				(localproc_3 261 210 83 153)
				(localproc_3 261 224 83 154)
			)
			(49
				(localproc_1 3 self)
			)
			(50
				(localproc_2)
				(localproc_1 1 self)
				(localproc_3 261 210 84 153)
				(localproc_3 261 224 84 154)
			)
			(51
				(localproc_1 2 self)
			)
			(52
				(localproc_1 3 self)
			)
			(53
				(localproc_0 2 self)
			)
			(54
				(localproc_2)
				(localproc_1 2 self)
				(localproc_3 261 210 85 153)
				(localproc_3 261 224 85 154)
			)
			(55
				(localproc_1 1 self)
			)
			(56
				(localproc_1 3 self)
			)
			(57
				(localproc_2)
				(localproc_1 1 self)
				(localproc_3 261 210 86 153)
				(localproc_3 261 224 86 154)
			)
			(58
				(localproc_1 3 self)
			)
			(59
				(localproc_1 2 self)
			)
			(60
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 261 210 87 153)
				(localproc_3 261 224 87 154)
			)
			(61
				(localproc_2)
				(localproc_1 1 self)
				(localproc_3 261 210 88 153)
				(localproc_3 261 224 88 154)
			)
			(62
				(localproc_1 3 self)
			)
			(63
				(localproc_1 1 self)
			)
			(64
				(localproc_0 1 self)
				(localproc_2)
				(localproc_3 235 220 25 153)
				(localproc_3 235 232 26 153)
				(localproc_3 235 244 26 154)
				(localproc_3 235 270 27 153)
				(localproc_3 235 282 27 154)
				(localproc_3 235 296 28 153)
				(localproc_3 235 308 28 154)
				(localproc_3 235 322 29 153)
				(localproc_3 235 334 29 154)
				(localproc_3 235 346 30 153)
				(localproc_3 235 370 30 154)
				(localproc_3 235 384 31 153)
				(localproc_3 235 396 31 154)
				(localproc_3 235 408 32 153)
				(localproc_3 235 420 32 154)
				(localproc_3 235 434 33 153)
				(localproc_3 235 446 33 154)
			)
			(65
				(localproc_0 2 self)
			)
			(66
				(localproc_0 1 self)
			)
			(67
				(localproc_2)
				(localproc_1 2 self)
				(localproc_3 240 230 34 153)
				(localproc_3 240 242 34 154)
			)
			(68
				(localproc_1 1 self)
			)
			(69
				(localproc_1 3 self)
			)
			(70
				(localproc_2)
				(localproc_0 2 self)
				(localproc_3 240 220 78 153)
				(localproc_3 240 232 78 154)
				(localproc_3 240 246 79 153)
				(localproc_3 240 258 79 154)
				(localproc_3 240 272 80 153)
				(localproc_3 240 284 80 154)
			)
			(71
				(localproc_1 1 self)
			)
			(72
				(localproc_1 2 self)
			)
			(73
				(localproc_1 3 self)
			)
			(74
				(localproc_2)
				(localproc_3 190 220 81 154)
				(localproc_3 190 290 82 154)
				(= seconds 5)
			)
			(75
				(gCurRoom newRoom:)
			)
		)
	)
)

(instance creditsList of List
	(properties)
)

