;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
(include sci.sh)
(use Main)
(use Interface)
(use CPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	WhirlWind 0
)

(local
	[local0 21] = [500 82 315 82 304 82 251 138 122 138 101 106 46 96 93 54 90 45 100 -500 -32768]
	[local21 19] = [140 500 140 165 130 150 143 126 112 96 84 80 174 74 183 55 110 -500 -32768]
	[local40 21] = [168 500 168 185 169 175 174 147 194 83 152 59 74 59 31 75 13 81 -500 103 -32768]
	[local61 25] = [500 84 315 84 305 84 235 120 183 136 114 150 120 140 81 128 127 82 92 68 22 72 -500 72 -32768]
	[local86 5] = [177 163 137 145 -32768]
	local91
	local92
	local93
)

(instance whirlWindPath of CPath
	(properties)

	(method (at param1)
		(switch gCurRoomNum
			(23
				(return [local0 param1])
			)
			(26
				(return [local21 param1])
			)
			(27
				(return [local40 param1])
			)
			(28
				(return [local61 param1])
			)
			(else
				(return [local86 param1])
			)
		)
	)

	(method (moveDone)
		(if (self atEnd:)
			((super superClass:) init: client x y)
		else
			(super moveDone:)
		)
	)
)

(instance whirlWind of Act
	(properties
		view 128
		loop 1
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(or
					(Said 'look[<at,around][/!*][/!*]')
					(Said 'look/room[/!*]')
					(Said '/rose,blossom,whirlwind,air')
					(Said '//rose,blossom,whirlwind,air')
					(MouseClaimed self event)
				)
			)
			(Print 124 0) ; "The whirlwind of rose petals will guide and protect you, but only if you stay within it."
		)
	)
)

(instance WhirlWind of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 128)
		(super init:)
		(whirlWind illegalBits: 0 ignoreActors: 1 posn: 0 1000 init:)
		(SetFlag 313)
		(self notify: 2)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 917)
		(DisposeScript 124)
	)

	(method (doit &tmp temp0 [temp1 40])
		(super doit:)
		(= temp0 (gEgo distanceTo: whirlWind))
		(cond
			((!= (DoTheWhirl state:) 2) 0)
			((< temp0 20)
				(= local91 0)
			)
			((< temp0 35) 0)
			((>= local91 3)
				((ScriptID 106) notify: 1) ; otMoor
				(DoTheWhirl start: 3)
				(self setScript: DoTheWhirl)
			)
			((and (< (-- local92) 1) (!= gCurRoomNum 29) (!= gCurRoomNum 25))
				(++ local91)
				(= local92 6)
				((ScriptID 106) notify: 0) ; otMoor
			)
		)
		(if
			(and
				(== gCurRoomNum 29)
				(== (whirlWind x:) 137)
				(== (whirlWind y:) 145)
			)
			(whirlWind posn: 136 144)
			(DoTheWhirl start: 3)
			(self setScript: DoTheWhirl)
		)
	)

	(method (notify param1 &tmp temp0)
		(switch param1
			(2
				(= temp0 0)
				(= local93 0)
				(while (!= (whirlWindPath at: temp0) -32768)
					(if
						(<=
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(whirlWindPath at: temp0)
								(whirlWindPath at: (+ temp0 1))
							)
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								(whirlWindPath at: local93)
								(whirlWindPath at: (+ local93 1))
							)
						)
						(= local93 temp0)
					)
					(+= temp0 2)
				)
				(if (IsFlag 312)
					(-- local93)
				)
				(if (IsFlag 313)
					(ClearFlag 313)
					(DoTheWhirl start: 1)
				else
					(DoTheWhirl start: 0)
				)
				(self setScript: DoTheWhirl)
			)
			(3
				(DoTheWhirl start: 3)
				(self setScript: DoTheWhirl)
			)
		)
	)
)

(instance DoTheWhirl of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(PutItem 4) ; rose | apple | green_apple
				(whirlWind
					setLoop: 0
					posn:
						(if (== gCurRoomNum 23)
							(- (gEgo x:) 20)
						else
							(+ (gEgo x:) 20)
						)
						(gEgo y:)
					setCycle: End self
				)
				(= global119 1)
			)
			(1
				(= cycles 1)
			)
			(2
				(if (not (IsFlag 312))
					(whirlWindPath dir: -1)
				else
					(whirlWindPath dir: 1)
				)
				(if (not local93)
					(= local93 -1)
				)
				(switch gCurRoomNum
					(23
						(if (== gPrevRoomNum 28)
							(whirlWind posn: 300 82)
						)
					)
					(26
						(if (== gPrevRoomNum 27)
							(whirlWind posn: 110 30)
						)
					)
					(27
						(switch gPrevRoomNum
							(28
								(whirlWind posn: 2 103)
							)
							(26
								(whirlWind posn: 169 190)
							)
						)
					)
					(28
						(switch gPrevRoomNum
							(23
								(whirlWind posn: 2 73)
							)
							(27
								(whirlWind posn: 318 84)
							)
						)
					)
					(29
						(if (== gPrevRoomNum 23)
							(whirlWind posn: 150 190)
						)
					)
				)
				(whirlWindPath index: local93)
				(whirlWind setLoop: 1 setCycle: Fwd setMotion: whirlWindPath)
				(= temp0
					(switch gCurRoomNum
						(26 3)
						(23 1)
						(else 2)
					)
				)
				(whirlWind moveSpeed: temp0)
			)
			(3
				(cond
					((IsFlag 68)
						(whirlWind
							setMotion:
								MoveTo
								(whirlWind x:)
								(if (< (whirlWind y:) 120)
									(+ (whirlWind y:) 20)
								else
									(- (whirlWind y:) 20)
								)
						)
					)
					((== gCurRoomNum 29)
						(whirlWind setMotion: MoveTo 120 120)
					)
					((== gCurRoomNum 25)
						(whirlWind posn: 140 35 setMotion: MoveTo 200 150)
					)
				)
				(whirlWind setLoop: 1 setCycle: Fwd)
				(if (== gCurRoomNum 25)
					(= cycles 10)
				else
					(= cycles 10)
				)
			)
			(4
				(whirlWind setLoop: 2 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(5
				(whirlWind dispose:)
				(= cycles 2)
			)
			(6
				(= global119 0)
				(Print 124 1) ; "The petals disperse in an icy wind. You are no longer protected by its spell of guidance."
			)
		)
	)
)

