;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
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
)

(instance rm540 of SQRoom
	(properties
		picture 540
		north 541
		west 535
		vanishingX 0
		vanishingY -30
	)

	(method (init)
		(LoadMany rsVIEW 515 300)
		(LoadMany rsSOUND 131)
		(switch gPrevRoomNum
			(541
				(gEgo illegalBits: 0)
				(self setScript: enterScript)
			)
			(556
				(gEgo
					view: 0
					headView: 4
					normal: 1
					moveHead: 1
					setCycle: StopWalk 4
					setLoop: 3
					x: 120
					y: 147
					init:
				)
				(rogerJr init:)
				(self setScript: endScript)
			)
			(west
				(HandsOff)
				(self setScript: enterFromWest style: 41)
			)
			(else
				(gEgo x: 160 y: 160)
			)
		)
		(if (!= gPrevRoomNum 541)
			(doorTop init: stopUpd:)
			(doorBottom init: stopUpd:)
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
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 151 53 151 59 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 241 135 254 135 231 121 271 108 210 56 186 56 213 86 163 86 159 78 136 78 147 88 89 87 65 53 0 53
					yourself:
				)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((StepOn gEgo 4)
				(HandsOff)
				(gCurRoom setScript: fallScript)
			)
			(script)
			((< (gEgo x:) 28)
				(HandsOff)
				(gCurRoom setScript: exitScript)
			)
		)
	)
)

(instance doorTop of Actor
	(properties
		x 142
		y 77
		z 18
		description {door}
		sightAngle 90
		view 515
		priority 3
		signal 26640
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 7)
					(Print 540 0) ; "***Thanks to your janitor ingenuity, the doorlock is now destroyed and you may enter and leave at will."
				else
					(Print 540 1) ; "Your inate sense of curiosity makes you wish you knew the way to open this thing."
				)
			)
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: doorScript)
			)
			(6 ; Inventory
				(switch invItem
					(5 ; jar
						(if (== ((Inv at: 5) cel:) 2) ; jar
							(HandsOff)
							(gCurRoom setScript: acidScript)
						else
							(super doVerb: theVerb)
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
		x 106
		y 63
		lookStr {It's a door.}
		view 515
		cel 1
		priority 1
		signal 26640
		illegalBits 0
	)
)

(instance enterFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: x: 5 setMotion: MoveTo 50 (gEgo y:) self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance exitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: 535)
			)
		)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong2 number: 131 vol: 127 loop: 1 play:)
				(gEgo
					view: 300
					setLoop:
					setCycle: 0
					setStep: 3 20
					setPri:
					illegalBits: 0
					setMotion: MoveTo (gEgo x:) 250 self
				)
			)
			(1
				(= seconds 2)
			)
			(2
				(gLongSong2 fade: 0 1 2 1)
				(= seconds 1)
			)
			(3
				(EgoDead 540 2) ; "*** Gee, I guess that way doesn't go anywhere."
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
				(gEgo
					x: 129
					y: 70
					setLoop: 4
					setMotion: PolyPath 165 96 self
				)
			)
			(1
				(doorTop y: 0 init: setMotion: MoveTo (doorTop x:) 77)
				(doorBottom
					y: 115
					init:
					setMotion: MoveTo (doorBottom x:) 63 self
				)
			)
			(2
				(HandsOn)
				(gEgo setLoop: -1)
				(client setScript: 0)
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
					(Print 540 3) ; "***Try as you might, none of the codes you punch in seem to have any effect on the door."
					(HandsOn)
					(client setScript: 0)
				)
			)
			(3
				(doorTop setMotion: MoveTo (doorTop x:) 34 self)
				(doorBottom setMotion: MoveTo (doorBottom x:) 100)
			)
			(4
				(gEgo setMotion: MoveTo 148 73 self)
			)
			(5
				(gEgo setMotion: MoveTo 90 35 self)
			)
			(6
				(doorBottom setMotion: MoveTo (doorBottom x:) 63)
				(doorTop setMotion: MoveTo (doorTop x:) 77 self)
			)
			(7
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
				(gLongSong2 number: 825 loop: 1 play:)
				(blopSound init: loop: 1 play: self)
				(gEgo normal: 0 view: 515 loop: 1 cel: 0 cycleSpeed: 1)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= cycles 5)
			)
			(4
				(gLongSong2 stop:)
				(blopSound dispose:)
				(NormalEgo 3 0)
				(= cycles 2)
			)
			(5
				(Print 540 4) ; "***Well, I don't think there's much left of the lock now."
				(SetFlag 7)
				((Inv at: 5) cel: 1 cursor: 15) ; jar
				((IconBar at: 6) cursor: 15)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerJr setCycle: MCyc @local0)
				(= cycles 1)
			)
			(1
				(blast init: setCycle: MCyc @local37)
				(= cycles 4)
			)
			(2
				(rip init: setCycle: End self)
			)
			(3
				(blast dispose:)
				(rip setLoop: 4 setCycle: Fwd)
				(= cycles 1)
			)
			(4
				(gEgo setMotion: MoveTo 101 124 self)
			)
			(5
				(gEgo setLoop: 0)
				(= cycles 7)
			)
			(6
				(gEgo view: 558 setCel: 0 setCycle: End self)
			)
			(7
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance rogerJr of Prop
	(properties
		x 170
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

(instance theTunnel of Feature ; UNUSED
	(properties
		nsBottom 189
		nsRight 319
		description {tunnel}
		onMeCheck 16
		lookStr {This tunnel extends out over pipes and beams and toward the center of the structure.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theCityView of Feature ; UNUSED
	(properties
		nsBottom 189
		nsRight 319
		description {city view}
		onMeCheck 32
		lookStr {You look out at the the ruins of some of the most beautiful buildings to be found on Xenon.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(5) ; Talk
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blopSound of Sound
	(properties
		number 820
		priority 5
	)
)

