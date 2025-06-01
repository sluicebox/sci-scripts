;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use Interface)
(use rmnScript)
(use eRS)
(use IconBar)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	[local0 37] = [0 0 155 138 0 1 155 138 0 1 155 138 0 1 155 138 0 2 155 138 0 3 155 138 0 4 155 138 0 5 155 138 0 6 155 138 -32768]
	[local37 33] = [0 0 0 0 1 0 145 108 1 1 145 108 1 2 145 108 1 3 145 108 1 4 145 107 1 5 149 101 0 0 0 0 -32768]
	local70
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2)
	(aSound number: 105 loop: 1 vol: 127 play:)
	(if (< param1 param3)
		(= temp0 (- param1 1))
		(= temp1 (+ param3 1))
	else
		(= temp0 (- param3 1))
		(= temp1 (+ param1 1))
	)
	(= temp2 (Graph grSAVE_BOX temp0 (- param2 1) temp1 (+ param4 1) 1))
	(Graph grDRAW_LINE param1 param2 param3 param4 global143 -1 -1)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
	(Wait 1)
	(Wait 4)
	(Graph grRESTORE_BOX temp2)
	(Graph grREDRAW_BOX temp0 (- param2 1) temp1 (+ param4 1))
)

(instance aSound of Sound
	(properties)
)

(instance rm540 of SQRoom
	(properties
		picture 540
		north 541
		west 535
		vanishingX 0
		vanishingY -60
	)

	(method (init)
		(LoadMany rsVIEW 515 300 7 13 511)
		(LoadMany rsSOUND 105 131 124 154 155 820 825)
		(tunnel init:)
		(switch gPrevRoomNum
			(541
				(self setScript: enterScript)
			)
			(556
				(LoadMany rsVIEW 558 556)
				(gEgo moveHead: 0 setLoop: 0 x: 115 y: 142 init:)
				(NormalEgo 0 0 4)
				(AnimateEgoHead 4)
				(rogerJr init:)
				(gLongSong2 number: 871 vol: 127 loop: -1 flags: 1)
				(self setScript: endScript)
			)
			(west
				(self style: 12 setScript: enterFromWest 0 (IsFlag 32))
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(if (!= gPrevRoomNum 541)
			(doorBottom init: stopUpd:)
			(doorTop init: stopUpd:)
		)
		(gEgo
			view: 0
			headView: 4
			normal: 1
			moveHead: 1
			setCycle: StopWalk 4
			init:
		)
		(super init:)
		(self setRegions: 709) ; rgLanding
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 151 53 151 59 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 241 135 254 135 231 121 271 108 210 56 193 56 215 86 163 86 159 78 136 78 147 88 87 88 62 53 0 53
					yourself:
				)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((< (gEgo x:) 28)
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance police of Actor
	(properties
		x 259
		y 147
		description {sequel police}
		lookStr {You look briefly, careful not to attract any attention.}
		view 7
		loop 2
		cel 2
	)

	(method (init)
		(super init:)
		(= local70 75)
	)

	(method (doit)
		(super doit:)
		(if (and (not (-- local70)) (!= (gCurRoom script:) (ScriptID 709 1))) ; fallScript
			(gCurRoom setScript: 0)
			(self setScript: policeScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(= local70 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorTop of Actor
	(properties
		x 141
		y 77
		z 22
		description {door}
		sightAngle 90
		view 515
		priority 3
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 7)
					(Print 540 0) ; "Thanks to your janitorial ingenuity, the doorlock is now destroyed and you may enter and leave at will."
				else
					(Print 540 1) ; "Your inate sense of curiosity makes you wish you knew the way to open this thing."
				)
			)
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: doorScript)
			)
			(4 ; Inventory
				(switch invItem
					(5 ; jar
						(cond
							((and (== ((Inv at: 5) cel:) 2) (not (IsFlag 7))) ; jar
								(HandsOff)
								(gCurRoom setScript: acidScript)
							)
							((== ((Inv at: 5) cel:) 2) ; jar
								(Print 540 2) ; "There is no reason to do that again."
							)
							(else
								(super doVerb: theVerb)
							)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance doorBottom of Actor
	(properties
		x 141
		y 76
		description {door}
		view 515
		cel 1
		priority 2
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 7)
					(Print 540 0) ; "Thanks to your janitorial ingenuity, the doorlock is now destroyed and you may enter and leave at will."
				else
					(Print 540 3) ; "Your inate sense of curiosity makes you wish you knew the way to open this thing."
				)
			)
		)
	)
)

(instance enterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 5 setMotion: MoveTo 50 (gEgo y:) self)
				(if (not register)
					(police init:)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 4])
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 535 loop: -1 playBed:)
				(gEgo
					x: 129
					y: 70
					setLoop: 4
					illegalBits: 0
					setMotion: PolyPath 165 96 self
				)
			)
			(1
				(blopSound init: number: 154 vol: 127 loop: -1 play:)
				(doorTop init: y: 35 setMotion: MoveTo (doorTop x:) 77 self)
				(doorBottom init: y: 95 setMotion: MoveTo (doorBottom x:) 76)
			)
			(2
				(blopSound number: 155 vol: 127 loop: 0 play:)
				(HandsOn)
				(gEgo setLoop: -1)
				(client setScript: 0)
			)
		)
	)
)

(instance policeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(police setHeading: 315)
				(= cycles 4)
			)
			(1
				(Print 540 4) ; "Uh oh..."
				(police view: 13 setLoop: 1 setCel: 0)
				(= cycles 1)
			)
			(2
				(police setCycle: End self)
				(localproc_0
					(- (gEgo y:) 32)
					(gEgo x:)
					(- (police y:) 27)
					(police x:)
				)
			)
			(3
				(gEgo
					view: 511
					setLoop: 0
					setMotion: 0
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(EgoDead 8) ; "We're glad you could play SQIV. As usual, you've been a real pantload."
			)
		)
	)
)

(instance doorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 78 self)
			)
			(1
				(= cycles 5)
			)
			(2
				(if (IsFlag 7)
					(= cycles 1)
				else
					(Print 540 5) ; "Try as you might, none of the codes you punch in seem to have any effect on the door."
					(HandsOn)
					(self dispose:)
				)
			)
			(3
				(gLongSong number: 124 loop: 0 play: self)
			)
			(4
				(blopSound init: number: 154 vol: 127 loop: -1 play:)
				(doorTop setMotion: MoveTo (doorTop x:) 37 self)
				(doorBottom setMotion: MoveTo (doorBottom x:) 107 self)
			)
			(5 0)
			(6
				(blopSound stop: loop: 0)
				(gEgo setMotion: MoveTo 148 73 self)
			)
			(7
				(gEgo setMotion: MoveTo 90 35 self)
			)
			(8
				(blopSound number: 154 vol: 127 loop: -1 play:)
				(doorBottom setMotion: MoveTo (doorBottom x:) 76)
				(doorTop setMotion: MoveTo (doorTop x:) 77 self)
			)
			(9
				(blopSound number: 155 vol: 127 loop: 0 play: self)
			)
			(10
				(gLongSong2 fade:)
				(gCurRoom newRoom: 541)
			)
		)
	)
)

(instance acidScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 155 78 self)
			)
			(1
				(gLongSong number: 825 loop: 1 play:)
				(blopSound init: vol: 127 loop: 0 play: self)
				(gEgo normal: 0 view: 515 loop: 1 cel: 0 cycleSpeed: 1)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= local70 1)
				(= cycles 5)
			)
			(4
				(gLongSong stop:)
				(blopSound dispose:)
				(NormalEgo 3 0)
				(= cycles 2)
			)
			(5
				(Print 540 6) ; "Well, I don't think there's much left of the lock now."
				(SetScore 7 10)
				((Inv at: 5) cel: 1 cursor: 15) ; jar
				((IconBar at: 6) cursor: 15)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance endScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade:)
				(= cycles 10)
			)
			(1
				(HandsOff)
				(gLongSong2 playBed:)
				(rogerJr setCycle: MCyc @local0)
				(= cycles 1)
			)
			(2
				(blast init: setCycle: MCyc @local37)
				(= cycles 4)
			)
			(3
				(rip init: setCycle: End self)
			)
			(4
				(blast dispose:)
				(rip setLoop: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(5
				(gEgo setMotion: MoveTo 101 124 self)
			)
			(6
				(self
					save1:
						(proc0_12
							{"Dad?"}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(gEgo setLoop: 4)
				(= seconds 3)
			)
			(7
				(self restore:)
				(= cycles 1)
			)
			(8
				(self
					save1:
						(proc0_12
							{"I'm glad I got to see you, even if for only a few minutes. Xenon owes you a lot. Goodbye, Dad."}
							67
							2
							2
							28
							global150
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 10)
			)
			(9
				(self restore:)
				(gEgo setLoop: 3)
				(= cycles 1)
			)
			(10
				(gEgo view: 558 setCel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(11
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance rogerJr of Prop
	(properties
		x 155
		y 139
		view 556
	)
)

(instance blast of Prop
	(properties
		x 156
		y 110
		view 556
		loop 1
	)
)

(instance rip of Prop
	(properties
		x 99
		y 93
		view 556
		loop 3
	)
)

(instance tunnel of Feature
	(properties
		nsBottom 189
		nsRight 319
		description {tunnel}
		sightAngle 180
		onMeCheck 16
		lookStr {This tunnel extends out over pipes and beams and toward the center of the structure.}
	)
)

(instance blopSound of Sound
	(properties
		number 820
		priority 5
	)
)

