;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use eRS)
(use MCyc)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	[local0 41] = [3 3 177 138 3 0 177 138 3 1 177 138 3 1 177 144 3 1 177 148 3 1 177 158 3 1 177 168 3 1 177 178 3 1 177 188 0 0 -100 -100 -32768]
	[local41 41] = [0 0 135 110 0 1 135 110 0 2 135 110 0 3 135 110 0 4 135 110 3 0 162 104 3 1 160 104 3 2 158 104 3 3 156 104 3 4 154 104 -32768]
	[local82 41] = [1 0 135 110 1 1 135 110 1 2 135 110 1 3 135 110 1 4 135 110 2 0 162 104 2 1 160 104 2 2 158 104 2 3 156 104 2 4 154 104 -32768]
)

(instance rm350 of SQRoom
	(properties
		picture 350
	)

	(method (init)
		(proc0_14 10)
		(LoadMany rsVIEW 350 351 338)
		(LoadMany rsSOUND 140 103 840)
		(bSound init:)
		(theMaw init:)
		(switch gPrevRoomNum
			(341
				(rogerTongue init:)
				(self setScript: dieScript)
				(theMouth init:)
				(finDrip init: setScript: finDripScript)
			)
			(335
				(if (IsFlag 4)
					(rogerTongue init:)
					(self setScript: dieScript)
					(theMouth init:)
					(finDrip init: setScript: finDripScript)
					(headSwell init:)
					(steam init:)
				else
					(theMouth init:)
					(egoStruggle init: setCycle: Fwd)
					(finDrip init: setScript: finDripScript)
					(eye init: setPri: 13 setScript: grabEgoScript)
					(headSwell init:)
					(steam init:)
				)
			)
			(else
				(theMouth init:)
				(super init:)
				(egoStruggle init: setCycle: Fwd)
				(finDrip init: setScript: finDripScript)
				(eye init: setPri: 13 setScript: grabEgoScript)
			)
		)
		(super init:)
	)
)

(instance grabEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theMouth setCycle: End self)
			)
			(1
				(spit init: setPri: 12 setCycle: MCyc @local0)
				(eye cel: 1)
				(tentacles init: setCycle: Fwd self)
				(= seconds 5)
			)
			(2
				(tentacles dispose:)
				(theMouth setCycle: End self)
			)
			(3
				(spit setCycle: MCyc @local0)
				(eye cel: 0)
				(tongue init: setCycle: End self)
			)
			(4
				(gCurRoom newRoom: 341)
			)
		)
	)
)

(instance dieScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 2) (== (theMouth cel:) 0))
			(aSound playBed:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(theMouth setCel: 3)
				(if (== ((gInventory at: 7) owner:) gEgo) ; oxygen_tank
					(self setScript: feedSlugScript)
				else
					(HandsOff)
					(rogerTongue setCycle: MCyc @local41 self)
				)
			)
			(1
				(HandsOn)
				(rogerTongue dispose:)
				(= cycles 1)
			)
			(2
				(gLongSong stop:)
				(aSound init:)
				(theMouth setCycle: ForwardCounter 8 self)
			)
			(3
				(theMouth setCycle: Beg self)
			)
			(4
				(aSound dispose:)
				(= cycles 5)
			)
			(5
				(cSound init:)
				(theMouth setCycle: Beg)
				(cSound play:)
				(= seconds 3)
			)
			(6
				(EgoDead 4 0) ; "We're glad you could play SQIV.__As usual, you've been a real pantload."
			)
		)
	)
)

(instance feedSlugScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 3) (== (theMouth cel:) 0))
			(aSound playBed:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rogerTongue setCycle: MCyc @local82 self)
			)
			(1
				(HandsOn)
				(rogerTongue setLoop: 2 cel: 0 setCycle: Fwd)
				(= seconds 7)
			)
			(2
				(HandsOff)
				(tongue dispose:)
				(rogerTongue dispose:)
				(= cycles 1)
				(aSound init:)
			)
			(3
				(gLongSong stop:)
				(theMouth setCycle: ForwardCounter 4 self)
			)
			(4
				(theMouth setCycle: Beg self)
			)
			(5
				(aSound dispose:)
				(headSwell z: 0)
				(theMouth dispose:)
				(steam z: 0)
				(= cycles 5)
			)
			(6
				(steam setCycle: ForwardCounter 3 self)
				(bSound play:)
			)
			(7
				(EgoDead 4 27) ; "I'm sure the Babes appreciate your sacrifice, too bad you can't experience just how appreciative they are."
			)
		)
	)
)

(instance throwTankScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== (self state:) 2) (== (theMouth cel:) 0))
			(aSound playBed:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(rogerTongue
					setCycle: 0
					setLoop: 4
					x: 167
					y: 132
					setCycle: End self
				)
				(gEgo put: 7) ; oxygen_tank
			)
			(1
				(SetScore 48 5)
				(tongue dispose:)
				(theMouth setCycle: Beg)
				(rogerTongue x: 225 y: 136 setLoop: 5 setCycle: End self)
				(aSound init:)
			)
			(2
				(gLongSong stop:)
				(theMouth setCycle: ForwardCounter 2 self)
			)
			(3
				(aSound dispose:)
				(headSwell z: 0)
				(theMouth dispose:)
				(steam z: 0)
				(= cycles 5)
			)
			(4
				(steam setCycle: ForwardCounter 3 self)
				(bSound play:)
			)
			(5
				(gCurRoom newRoom: 335)
			)
		)
	)
)

(instance finDripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(finDrip setCycle: Fwd)
				(= cycles 5)
			)
		)
	)
)

(instance theMaw of Feature
	(properties
		x 151
		y 97
		nsTop 63
		nsLeft 121
		nsBottom 131
		nsRight 182
		description {slug mandibles}
		sightAngle 90
		lookStr {It's the slug's intake orifice. Looks pretty disgusting, don't you think?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(7 ; oxygen_tank
						(if (== ((gInventory at: 7) owner:) gEgo) ; oxygen_tank
							(gCurRoom setScript: throwTankScript)
						else
							(super doVerb: theVerb)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance aSound of Sound
	(properties
		number 140
	)
)

(instance bSound of Sound
	(properties
		number 103
		vol 100
	)
)

(instance cSound of Sound
	(properties
		number 840
	)
)

(instance egoStruggle of Prop
	(properties
		x 292
		y 97
		view 350
	)
)

(instance theMouth of Prop
	(properties
		x 148
		y 101
		description {slug tongue}
		sightAngle 180
		lookStr {My, this slug has a very dexterous mouth.}
		view 350
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3) ; Do
			(4 ; Inventory
				(theMaw doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance finDrip of Prop
	(properties
		x 13
		y 187
		description {Drip}
		lookStr {Sea water and slug slime slowly ooze down the fin of this hideous creature.}
		view 350
		loop 2
		cycleSpeed 2
	)
)

(instance spit of Prop
	(properties
		x 177
		y 138
		description { slug slobber}
		lookStr {It's slug spit! Looks appetizing, huh.}
		view 350
		loop 3
		cycleSpeed 1
	)
)

(instance eye of Prop
	(properties
		x 144
		y 82
		description {Red eye}
		lookStr {Staring contests were never your thing.}
		view 350
		loop 4
		priority 13
	)
)

(instance tongue of Prop
	(properties
		x 157
		y 99
		description {tentacles}
		lookStr {These things look like they have a life of their own.}
		view 350
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3) ; Do
			(4 ; Inventory
				(theMaw doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tentacles of Prop
	(properties
		x 157
		y 96
		description {tentacles}
		lookStr {These things look like they have a life of their own.}
		view 350
		loop 7
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3) ; Do
			(4 ; Inventory
				(theMaw doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rogerTongue of Actor
	(properties
		x 135
		y 110
		description {tentacles}
		lookStr {Feels like being licked by a large dog with incredibly bad breath.}
		view 351
		priority 4
		signal 16
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3) ; Do
			(4 ; Inventory
				(theMaw doVerb: theVerb invItem)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance headSwell of Prop
	(properties
		x 150
		y 142
		z 1000
		description {Swollen slug head}
		sightAngle 180
		lookStr {It looks like the internal pressure of the slug is starting to exceed its external strength.}
		view 338
		priority 13
		signal 16400
	)
)

(instance steam of Prop
	(properties
		x 186
		y 92
		z 1000
		description {Steam}
		sightAngle 180
		lookStr {Better take cover. It looks like slimey slug guts are gonna fly.}
		view 338
		loop 1
		priority 13
		signal 16400
	)
)

