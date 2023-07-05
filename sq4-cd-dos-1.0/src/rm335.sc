;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use RandCycle)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm335 0
)

(instance rm335 of SQRoom
	(properties
		picture 335
	)

	(method (init)
		(LoadMany rsVIEW 0 4 402 14 336 331 335 339)
		(LoadMany rsSOUND 872 878)
		(tanks init:)
		(gFeatures add: tanks theArea eachElementDo: #init doit:)
		(switch gPrevRoomNum
			(330
				(zondra init:)
				(thoreen init:)
				(guard init:)
				(oxyTank init:)
				(gEgo init: posn: 110 158)
				(self setScript: strapScript)
			)
			(345
				(slug init: setScript: roarScript)
				(gEgo init: normal: 0 moveHead: 0)
				(slugHead init:)
				(tongue init:)
				(oxyTank init:)
				(self setScript: slugScript)
			)
			(341
				(slug init:)
				(gEgo
					init:
					view: 336
					posn: 139 154
					loop: 0
					cel: 6
					normal: 0
					moveHead: 0
				)
				(slugHead init: z: 1000)
				(tongue init: z: 1000)
				(oxyTank init:)
				(self setScript: escapeScript)
			)
			(350
				(huggers init: setScript: hugScript)
				(slugHead init: setLoop: 3 x: 144 y: 91)
				(sinkSFX init:)
				(heroSFX init:)
				(ripples init:)
				(gEgo dispose:)
			)
			(else
				(zondra init:)
				(thoreen init:)
				(guard init:)
				(oxyTank init:)
				(gEgo init: posn: 110 158)
				(self setScript: strapScript)
			)
		)
		(super init:)
	)
)

(instance slugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 336
					illegalBits: 0
					setLoop: 0
					setCel: 6
					setPri: 10
					posn: 139 154
				)
				(zondra init: view: 336 posn: 162 165 setLoop: 1 setCel: 0)
				(thoreen init:)
				(guard init: posn: 189 140 setLoop: 0 setCel: 0)
				(oxyTank init:)
				(= cycles 1)
			)
			(1
				(thoreenTalker ; "AAAIIIIHHHH!!! It's a sea slug! Run, girls!"
					init: 0 0 0
					say:
						7
						self
						2
						64
						2
						10
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(2
				(guard
					view: 335
					setLoop: 1
					xStep: 6
					yStep: 3
					setCycle: Walk
					illegalBits: 0
					setMotion: MoveTo 300 115 self
				)
				(zondra
					view: 335
					setLoop: 0
					setCycle: Walk
					illegalBits: 0
					xStep: 6
					yStep: 3
					setMotion: MoveTo 13 108
				)
				(thoreen
					view: 335
					setLoop: 2
					setCycle: Walk
					illegalBits: 0
					xStep: 6
					yStep: 3
					setMotion: MoveTo 18 185
				)
			)
			(3
				(= cycles 7)
			)
			(4
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance roarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(slugHead setPri: 6 setCycle: End self)
			)
			(2
				(tongue setPri: 7 setCycle: ForwardCounter 5 self)
			)
			(3
				(tongue dispose:)
				(slugHead setCycle: Beg self)
				(= cycles 1)
			)
			(4
				(roarScript dispose:)
			)
		)
	)
)

(instance strapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gLongSong hold: 2)
				(gEgo
					view: 0
					illegalBits: 0
					setPri: 9
					setCycle: Walk
					setMotion: MoveTo 139 154
				)
				(zondra
					setLoop: 2
					setCycle: Walk
					setPri: 7
					setMotion: MoveTo 162 165 self
				)
				(guard setLoop: 1 setCycle: Walk setMotion: MoveTo 189 140 self)
			)
			(2
				(zondra view: 336 setLoop: 1 setCel: 0)
			)
			(3
				(guard view: 331 loop: 0 cel: 0)
				(= cycles 1)
			)
			(4
				(thoreenTalker ; "Sit down!"
					init: 0 0 0
					say:
						1
						self
						2
						64
						2
						10
						25
						global130
						26
						(proc0_18 global155 global129)
						27
						1
						67
						315
				)
			)
			(5
				(= cycles 1)
			)
			(6
				(gEgo
					normal: 0
					moveHead: 0
					illegalBits: 0
					view: 336
					setPri: 10
					setCycle: End self
				)
			)
			(7
				(thoreen cycleSpeed: 12 setCycle: End)
				(zondra cycleSpeed: 12 setCycle: End self)
			)
			(8
				(gEgo normal: 1 moveHead: 1)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance escapeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo posn: 139 154 setCycle: Beg self)
			)
			(1
				(gEgo
					view: 402
					setPri: 6
					normal: 1
					setCycle: Walk
					setMotion: MoveTo 181 152 self
				)
			)
			(2
				(slugHead z: 0 setLoop: 2)
				(tongue z: 0 setLoop: 0 setCycle: RandCycle)
				(= cycles 1)
			)
			(3
				(AnimateEgoHead 14)
				(gEgo setCycle: StopWalk 14 self setLoop: 3)
				(= cycles 1)
			)
			(4
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(= seconds 8)
			)
			(5
				(HandsOff)
				(self setScript: slugBaitScript)
			)
		)
	)
)

(instance oxyTankScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					normal: 0
					moveHead: 0
					view: 337
					setPri: 12
					setLoop: 3
					cel: 0
					setCycle: End
				)
				(= cycles 3)
			)
			(1
				(gEgo get: 7) ; tank
				(oxyTank dispose:)
				(SetScore 47 5)
				(= cycles 2)
			)
			(2
				(Inv curIcon: (gInventory at: 7) hide:) ; tank
				(gGame setCursor: ((gInventory curIcon:) cursor:) 1)
				(= cycles 1)
			)
			(3
				(self setScript: slugBaitScript)
			)
		)
	)
)

(instance slugBaitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tongue setCycle: 0)
				(slugHead setLoop: 2 cel: 0)
				(= cycles 1)
			)
			(1
				(tongue setLoop: 2 setCel: 0 setCycle: End)
				(= cycles 4)
			)
			(2
				(= cycles 1)
			)
			(3
				(SetFlag 4)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance hugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ripples setCycle: ForwardCounter 2)
				(slugHead setPri: 3 x: 144 y: 91 setMotion: MoveTo 144 130 self)
				(= ticks 3)
			)
			(1
				(sinkSFX play:)
				(ripples setLoop: 5 setCel: 0 setCycle: End)
			)
			(2
				(sinkSFX dispose:)
				(ripples dispose:)
				(slugHead dispose:)
				(heroSFX play:)
				(= ticks 3)
			)
			(3
				(vibraTalker ; "OUR HERO!!"
					modNum: 322
					say:
						3
						self
						2
						64
						130
						10
						25
						global150
						26
						global129
						27
						1
						67
						315
				)
			)
			(4
				(zondra
					init:
					view: 339
					setLoop: 1
					setCel: 0
					setCycle: Walk
					x: 2
					y: 107
					xStep: 6
					yStep: 3
					setMotion: MoveTo 137 106 self
				)
				(guard
					init:
					view: 339
					setLoop: 2
					setCel: 0
					setCycle: Walk
					x: 318
					y: 108
					xStep: 6
					yStep: 3
					setMotion: MoveTo 183 108 self
				)
				(thoreen
					init:
					view: 339
					setLoop: 3
					setCel: 1
					setCycle: Walk
					x: 0
					y: 215
					xStep: 6
					yStep: 4
					illegalBits: 0
					setMotion: MoveTo 130 120 self
				)
			)
			(5 0)
			(6
				(huggers setCel: 2 setCycle: End)
				(zondra dispose:)
				(guard dispose:)
			)
			(7
				(thoreen z: 1000)
				(= cycles 20)
			)
			(8
				(= seconds 2)
			)
			(9
				(huggers setCycle: CT 4 -1 self)
			)
			(10
				(thoreen view: 336 setLoop: 2 setCel: 0 x: 137 y: 116 z: 0)
				(= seconds 2)
			)
			(11
				(zondraTalker modNum: 322 say: 13 self) ; "Wasn't he great, girls?"
			)
			(12
				(= cycles 2)
			)
			(13
				(zondraTalker say: 14 self) ; "Well Rog...I guess we can call it even. Thank you for ridding our fortress of that slimy, awful, sea slug."
			)
			(14
				(= cycles 2)
			)
			(15
				(zondraTalker disposeWhenDone: 1 say: 15 self) ; "I..uh..I know I can't blame you for backing out at the last minute. I guess I was a little overbearing. Sorry. Can we still be good friends?"
			)
			(16
				(= cycles 2)
			)
			(17
				(rogerTalker say: 5 self) ; "Well,... now wait a minute. Let's talk about this."
			)
			(18
				(= cycles 2)
			)
			(19
				(zondraTalker disposeWhenDone: 0 modNum: 322 say: 16 self) ; "No Roger - you were right. You don't need to spare my feelings. It just wasn't meant to be. It's better this way."
			)
			(20
				(= cycles 2)
			)
			(21
				(zondraTalker disposeWhenDone: 1 say: 17 self) ; "Well girls, I feel like celebrating. LET'S GO SHOPPING!!!"
				(heroSFX fade:)
			)
			(22
				(= cycles 2)
			)
			(23
				(= ticks 2)
			)
			(24
				(gCurRoom newRoom: 355)
			)
		)
	)
)

(instance sinkSFX of Sound
	(properties
		number 872
	)
)

(instance heroSFX of Sound
	(properties
		flags 1
		number 878
		loop -1
	)
)

(instance zondra of Sq4Actor
	(properties
		x 100
		y 110
		sightAngle 90
		view 331
		loop 2
		priority 6
		signal 16400
		lookStr 1 ; "Boy! You don't know what you did to make her mad, but you sure hope you get a chance to smooth things over."
	)
)

(instance thoreen of Sq4Actor
	(properties
		x 124
		y 169
		sightAngle 90
		view 336
		loop 2
		priority 9
		signal 16400
		lookStr 2 ; "Compassion and warmth are not words which come to mind when looking at this person."
	)
)

(instance guard of Sq4Actor
	(properties
		x 68
		y 134
		sightAngle 90
		view 331
		loop 1
		priority 6
		signal 16400
		lookStr 3 ; "The guard looks on coldly."
	)
)

(instance tanks of Sq4Feature
	(properties
		x 207
		y 141
		nsTop 129
		nsLeft 195
		nsBottom 154
		nsRight 219
		sightAngle 180
		lookStr 4 ; "You see what looks like highly pressurized oxygen tanks."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((gInventory at: 7) owner:) 335) ; tank
					(gCurRoom setScript: oxyTankScript)
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

(instance tongue of Sq4Prop
	(properties
		x 157
		y 88
		view 337
		priority 7
		signal 16400
		lookStr 5 ; "Yep, it's that nasty slug tongue again. Scary to think of what he can do with that thing, isn't it?"
	)
)

(instance slug of Sq4Prop
	(properties
		x 158
		y 96
		sightAngle 180
		view 342
		priority 5
		signal 16
		lookStr 6 ; "This isn't your garden variety slug."
	)
)

(instance slugHead of Sq4Actor
	(properties
		x 158
		y 96
		sightAngle 180
		view 342
		loop 2
		priority 6
		signal 16400
		lookStr 7 ; "Red eyes glare back at you."
	)
)

(instance huggers of Sq4Prop
	(properties
		x 161
		y 109
		view 339
		priority 7
		signal 16400
	)
)

(instance ripples of Sq4Prop
	(properties
		x 143
		y 72
		view 342
		loop 4
	)
)

(instance oxyTank of Sq4Prop
	(properties
		x 204
		y 153
		sightAngle 90
		view 336
		loop 3
		priority 11
		signal 16400
		lookStr 8 ; "You see what seems to be pressurized oxygen tanks."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== ((gInventory at: 7) owner:) 335) ; tank
					(gCurRoom setScript: oxyTankScript)
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

(instance theArea of Sq4Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		sightAngle 180
		lookStr 9 ; "This place is like a brick ship house."
	)
)

(instance zOrifice of Prop ; UNUSED
	(properties
		x 148
		y 71
		view 1999
		loop 6
		priority 15
		signal 16
	)
)

(instance eOrifice of Prop ; UNUSED
	(properties
		x 161
		y 68
		view 1999
		loop 4
		priority 15
		signal 16
	)
)

(instance thoreenTalker of FaceTalker
	(properties
		modNum 322
		talkerNum 21
		tpType 2
	)
)

(instance vibraTalker of Sq4Narrator
	(properties
		noun 20
		modNum 322
		talkerNum 20
		tpType 2
	)
)

(instance zondraTalker of Sq4Talker
	(properties
		noun 19
		modNum 322
		view 1332
		disposeWhenDone 0
		talkerNum 19
		mouthOffsetX 23
		mouthOffsetY 36
		eyeOffsetX 24
		eyeOffsetY 22
		tStyle 1
	)
)

(instance rogerTalker of Sq4Talker
	(properties
		noun 7
		modNum 322
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

