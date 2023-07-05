;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1050)
(include sci.sh)
(use Main)
(use Scaler)
(use Osc)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm1050 0
)

(local
	local0
	local1
	local2
)

(instance rm1050 of Rm
	(properties
		picture 129
		style -32758
	)

	(method (init)
		(LoadMany rsVIEW 700 702 703 13 701 558 704)
		(NormalEgo 0)
		(westDoor init: stopUpd:)
		(northDoor init: stopUpd:)
		(eastDoor init: stopUpd:)
		(cliffy init: stopUpd:)
		(cliffyHand init: stopUpd:)
		(energizeLight init: stopUpd:)
		(ambiLight1 init: setCycle: Fwd)
		(ambiLight2 init: setCycle: Fwd)
		(ambiLight3 init: setCycle: Fwd)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 247 133 282 133 282 127 202 127 203 153 304 153 290 144 257 144
					yourself:
				)
		)
		(super init:)
		(gCurRoom setScript: sRogEnters)
	)
)

(instance sRogEnters of Script
	(properties)

	(method (doit)
		(if (and (< (wd40 x:) 160) (== state 2))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: End self)
			)
			(2
				(wd40
					setScale: Scaler 110 77 149 130
					init:
					setCycle: Fwd
					setStep: 5 3
					setMotion: MoveTo -18 158
				)
			)
			(3
				(NormalEgo 0)
				(gEgo
					x: 272
					y: 127
					setScale: Scaler 110 77 149 130
					setLoop: -1
					setLoop: 5
					init:
					setMotion: PolyPath 215 153 self
				)
			)
			(4
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: Beg self)
			)
			(5
				(gMessager say: 1 0 0 0 self) ; "Captain, I've got the transporter all set up to separate the Primordial Soup from the Goliath's crew. Quick, Hide!"
			)
			(6
				(= seconds 2)
			)
			(7
				(gEgo
					view: 700
					setLoop: -1
					setLoop: 10
					cel: 0
					setCycle: End self
				)
			)
			(8
				(gMessager say: 4 0 0 0 self) ; "Not like that, Cap'n!"
			)
			(9
				(gEgo setLoop: 9 cel: 0 setCycle: End self)
				(cliffy setLoop: 0 setMotion: MoveTo 14 170)
			)
			(10
				(NormalEgo 4)
				(gEgo loop: 0 setMotion: MoveTo 279 146 self)
			)
			(11
				(gEgo view: 0 setLoop: 8 setCel: 2 setCycle: 0)
				(= seconds 3)
			)
			(12
				(gEgo stopUpd:)
				(cliffy stopUpd:)
				(gGame handsOn:)
				(gTheIconBar disable: 0)
				(pukoidN1 init:)
				(pukoidN2 init:)
				(pukoidN3 init:)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: End)
				(westDoor setCycle: End)
				(northDoor setCycle: End self)
			)
			(13
				(pukoidN1 setLoop: 1 setCycle: Fwd setMotion: MoveTo 180 136)
				(pukoidN2 setLoop: 12 setCycle: Fwd setMotion: MoveTo 188 129)
				(pukoidN3 setLoop: 9 setCycle: Fwd setMotion: MoveTo 154 130)
				(pukoidE1
					setLoop: 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 207 134
				)
				(pukoidE2
					setLoop: 6
					init:
					setCycle: Fwd
					setMotion: MoveTo 137 134
				)
				(pukoidW1
					setLoop: 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 158 138 self
				)
			)
			(14
				(= local0 1)
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: Beg)
				(westDoor setCycle: Beg)
				(northDoor setCycle: Beg self)
			)
			(15
				(eastDoor stopUpd:)
				(westDoor addToPic:)
				(northDoor addToPic:)
				(= seconds 10)
			)
			(16
				(gGame handsOff:)
				(= local0 2)
				(pukoidW1 setScript: sRogPuked)
				(self dispose:)
			)
		)
	)
)

(instance sRogPuked of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pukoidW1
					view: 678
					setCycle: Walk
					moveSpeed: 2
					init:
					setMotion: MoveTo 183 152 self
				)
			)
			(1
				(pukoidW1 setMotion: MoveTo 216 155 self)
			)
			(2
				(pukoidW1 setCycle: 0)
				(gSq5Music2 number: 519 setLoop: 1 play:)
				(thePuke init: setCycle: End self)
			)
			(3
				(thePuke dispose:)
				(gEgo view: 650 cel: 0 setCycle: End self)
			)
			(4
				(EgoDead 33) ; "It's a nice look for you. Too bad it can't last."
				(self dispose:)
			)
		)
	)
)

(instance sPukoidsTransformed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 0 0 0 self) ; "Now, Cliffy!"
			)
			(1
				(cliffyHand setCel: 1)
				(energizeLight setLoop: 5)
				(= cycles 1)
			)
			(2
				(eView1 init: stopUpd:)
				(= cycles 1)
			)
			(3
				(eView2 init: stopUpd:)
				(= cycles 1)
			)
			(4
				(eView3 init: stopUpd:)
				(= cycles 1)
			)
			(5
				(eView4 init: stopUpd:)
				(= cycles 1)
			)
			(6
				(eView5 init: stopUpd:)
				(= cycles 1)
			)
			(7
				(eView6 init: stopUpd:)
				(= cycles 1)
			)
			(8
				(eView7 init: stopUpd:)
				(eView8 init: stopUpd:)
				(= cycles 1)
			)
			(9
				(eView9 init: stopUpd:)
				(= cycles 1)
			)
			(10
				(eProp1 init: setCycle: End self)
			)
			(11
				(pukoidN1 hide:)
				(pukoidN2 hide:)
				(pukoidN3 hide:)
				(pukoidE1 hide:)
				(pukoidE2 hide:)
				(head1 hide:)
				(head2 hide:)
				(head3 hide:)
				(head4 hide:)
				(head5 hide:)
				(if (== local0 1)
					(pukoidW1 hide:)
					(SetScore 249 20)
					(pukeBeamOut init:)
				else
					(pukoidW1 setScript: sRogPuked)
					(pukeBeamOut loop: 2 cel: 0 init:)
				)
				(= cycles 1)
			)
			(12
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(13
				(= local2 gCast)
				(= gCast (EventHandler new:))
				(gCast addToFront: pukeBeamOut)
				(gSq5Music2 number: 260 setLoop: 1 play:)
				(pukeBeamOut setCycle: Beg self)
			)
			(14
				(pukeBeamOut hide:)
				(= seconds 3)
			)
			(15
				(if (== local0 2)
					(self dispose:)
				else
					(gSq5Music2 number: 260 setLoop: 1 play:)
					(pukeBeamOut loop: 0 cel: 0 show: setCycle: End self)
				)
			)
			(16
				(gSq5Music1 number: 45 setLoop: -1 play:)
				(pukeBeamOut dispose:)
				(gCast dispose:)
				(= gCast local2)
				(pukoidN1
					view: 703
					loop: 0
					cel: 0
					x: 207
					y: 134
					show:
					addToPic:
				)
				(head1
					view: 703
					loop: 6
					cel: 0
					x: 210
					y: 98
					show:
					setCycle: Osc
				)
				(pukoidN2
					view: 703
					loop: 1
					cel: 0
					x: 180
					y: 136
					show:
					addToPic:
				)
				(head2
					view: 703
					loop: 7
					cel: 0
					x: 180
					y: 101
					show:
					setCycle: Osc
				)
				(pukoidN3
					view: 703
					loop: 2
					cel: 0
					x: 137
					y: 134
					show:
					addToPic:
				)
				(head3
					view: 703
					loop: 8
					cel: 0
					x: 136
					y: 100
					show:
					setCycle: Osc
				)
				(pukoidE1
					view: 703
					loop: 3
					cel: 0
					x: 154
					y: 130
					show:
					addToPic:
				)
				(head4
					view: 703
					loop: 9
					cel: 0
					x: 152
					y: 99
					show:
					setCycle: Osc
				)
				(pukoidE2
					view: 703
					loop: 4
					cel: 0
					x: 188
					y: 129
					show:
					addToPic:
				)
				(head5
					view: 703
					loop: 10
					cel: 0
					x: 188
					y: 99
					show:
					setCycle: Osc
				)
				(pukoidW1
					view: 703
					loop: 5
					cel: 0
					x: 161
					y: 136
					scaleX: 128
					scaleY: 128
					show:
					addToPic:
				)
				(head6 init: setCycle: Osc)
				(= seconds 4)
			)
			(17
				(gMessager say: 3 0 0 1 self) ; "That's got her, Cap'. I've beamed all the pukoid material form the crew out into space."
			)
			(18
				(gSq5Music1 fade: 0 20 20 1)
				(= seconds 2)
			)
			(19
				(gSq5Music1 number: 28 setLoop: -1 play:)
				(= seconds 2)
			)
			(20
				(gMessager say: 3 0 0 2 self) ; "But what about Quirk?! He's not here."
			)
			(21
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: End)
				(NormalEgo 4)
				(gEgo setMotion: PolyPath 270 123 self)
			)
			(22
				(gSq5Music2 number: 103 setLoop: 1 play:)
				(eastDoor setCycle: Beg self)
			)
			(23
				(gSq5Music1 fade: 0 20 20 1)
				(gCurRoom newRoom: 1040)
				(self dispose:)
			)
		)
	)
)

(instance sTooEarly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 0 0 0 self) ; "Now, Cliffy!"
			)
			(1
				(cliffyHand setCel: 1)
				(energizeLight setLoop: 5)
				(= cycles 2)
			)
			(2
				(energizeLight setLoop: 3 setCycle: Fwd)
				(holdLight init:)
				(= cycles 1)
			)
			(3
				(pukoidW1 setScript: sRogPuked)
				(self dispose:)
			)
		)
	)
)

(instance westDoor of Prop
	(properties
		x 58
		y 91
		view 700
		loop 6
		signal 16384
	)
)

(instance northDoor of Prop
	(properties
		x 166
		y 94
		view 700
		loop 7
		priority 9
		signal 16400
	)
)

(instance eastDoor of Prop
	(properties
		x 251
		y 91
		view 700
		loop 8
		signal 16384
	)
)

(instance wd40 of Actor
	(properties
		x 268
		y 127
		view 13
		signal 16384
	)

	(method (doit)
		(if (< (self x:) -10)
			(UnLoad 128 13)
			(self dispose:)
		)
		(super doit: &rest)
	)
)

(instance cliffy of Actor
	(properties
		x 13
		y 144
		view 701
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; Order
				(gGame handsOff:)
				(if (not local0)
					(gCurRoom setScript: sTooEarly)
				else
					(gCurRoom setScript: sPukoidsTransformed)
				)
			)
			(2 ; Talk
				(gGame handsOff:)
				(if (not local0)
					(gCurRoom setScript: sTooEarly)
				else
					(gCurRoom setScript: sPukoidsTransformed)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pukoidN1 of Actor
	(properties
		x 177
		y 121
		view 702
		loop 1
		signal 18432
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 102 71 135 121)
	)

	(method (doit)
		(if (and (== (self mover:) 0) (== (self loop:) 1) (!= (self x:) 177))
			(self setCycle: 0 setLoop: 2)
			(head1 init: setPri: (pukoidN1 priority:) setCycle: Osc)
		)
		(super doit: &rest)
	)
)

(instance pukoidN2 of Actor
	(properties
		x 180
		y 120
		view 702
		loop 12
		signal 18432
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 102 82 130 121)
	)

	(method (doit)
		(if (and (== (self mover:) 0) (== (self loop:) 12) (!= (self x:) 180))
			(self setCycle: 0 setLoop: 13)
			(head2 init: setPri: (pukoidN2 priority:) setCycle: Osc)
		)
		(super doit: &rest)
	)
)

(instance pukoidN3 of Actor
	(properties
		x 173
		y 121
		view 702
		loop 9
		signal 18432
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 100 73 129 121)
	)

	(method (doit)
		(if (and (== (self mover:) 0) (== (self loop:) 9) (!= (self x:) 173))
			(self setCycle: 0 setLoop: 10)
			(head3 init: setPri: (pukoidN3 priority:) setCycle: Osc)
		)
		(super doit: &rest)
	)
)

(instance pukoidE1 of Actor
	(properties
		x 253
		y 134
		view 702
		signal 18432
	)

	(method (doit)
		(if (and (== (self mover:) 0) (== (self loop:) 0) (!= (self x:) 253))
			(self setCycle: 0 setLoop: 4)
			(head4 init: setPri: (pukoidE1 priority:) setCycle: Osc)
		)
		(super doit: &rest)
	)
)

(instance pukoidE2 of Actor
	(properties
		x 263
		y 134
		view 702
		loop 6
		signal 18432
	)

	(method (doit)
		(if (and (== (self mover:) 0) (== (self loop:) 6) (!= (self x:) 263))
			(self setCycle: 0 setLoop: 7)
			(head5 init: setPri: (pukoidE2 priority:) setCycle: Osc)
		)
		(super doit: &rest)
	)
)

(instance pukoidW1 of Actor
	(properties
		x 57
		y 134
		view 678
		signal 18432
		scaleSignal 1
		scaleX 99
		scaleY 99
	)

	(method (init)
		(super init: &rest)
		(self setScale: Scaler 103 73 152 136)
	)

	(method (doit)
		(if (== (self mover:) 0)
			(self setCycle: 0)
		)
		(super doit: &rest)
	)
)

(instance eProp1 of Prop
	(properties
		x 143
		y 47
		view 700
		loop 4
		signal 16384
	)
)

(instance head1 of Prop
	(properties
		x 177
		y 101
		view 702
		loop 3
		priority 10
		signal 16400
		cycleSpeed 10
	)
)

(instance head2 of Prop
	(properties
		x 187
		y 97
		view 702
		loop 14
		priority 10
		signal 16400
		cycleSpeed 11
	)
)

(instance head3 of Prop
	(properties
		x 152
		y 101
		view 702
		loop 11
		priority 10
		signal 16400
		cycleSpeed 12
	)
)

(instance head4 of Prop
	(properties
		x 203
		y 98
		view 702
		loop 5
		priority 9
		signal 16400
		cycleSpeed 12
	)
)

(instance head5 of Prop
	(properties
		x 132
		y 106
		view 702
		loop 8
		priority 10
		signal 16400
		cycleSpeed 11
	)
)

(instance head6 of Prop
	(properties
		x 162
		y 98
		view 703
		loop 11
		priority 15
		signal 16400
		cycleSpeed 10
	)
)

(instance thePuke of Prop
	(properties
		x 251
		y 118
		view 558
		priority 15
		signal 16400
	)
)

(instance pukeBeamOut of Prop
	(properties
		x 163
		y 99
		view 704
		loop 1
		cel 7
		priority 15
		signal 16400
	)
)

(instance ambiLight1 of Prop
	(properties
		x 219
		y 100
		view 700
	)
)

(instance ambiLight2 of Prop
	(properties
		x 209
		y 104
		view 700
		loop 1
	)
)

(instance ambiLight3 of Prop
	(properties
		x 309
		y 106
		view 700
		loop 2
	)
)

(instance energizeLight of Prop
	(properties
		x 99
		y 169
		view 701
		loop 3
		priority 15
		signal 16400
	)
)

(instance holdLight of View
	(properties
		x 41
		y 159
		view 701
		loop 4
		priority 14
		signal 16400
	)
)

(instance cliffyHand of View
	(properties
		x 99
		y 189
		view 701
		loop 2
		priority 15
		signal 16
	)
)

(instance eView1 of View
	(properties
		x 95
		y 1
		view 700
		loop 3
		signal 16384
	)
)

(instance eView2 of View
	(properties
		x 108
		y 10
		view 700
		loop 3
		cel 1
		signal 16384
	)
)

(instance eView3 of View
	(properties
		x 129
		y 12
		view 700
		loop 3
		cel 4
		signal 16384
	)
)

(instance eView4 of View
	(properties
		x 126
		y 24
		view 700
		loop 3
		cel 2
		signal 16384
	)
)

(instance eView5 of View
	(properties
		x 145
		y 27
		view 700
		loop 3
		cel 5
		signal 16384
	)
)

(instance eView6 of View
	(properties
		x 135
		y 32
		view 700
		loop 3
		cel 3
		signal 16384
	)
)

(instance eView7 of View
	(properties
		x 177
		y 32
		view 700
		loop 3
		cel 7
		signal 16384
	)
)

(instance eView8 of View
	(properties
		x 121
		y 36
		view 700
		loop 3
		cel 6
		signal 16384
	)
)

(instance eView9 of View
	(properties
		x 200
		y 41
		view 700
		loop 3
		cel 8
		signal 16384
	)
)

