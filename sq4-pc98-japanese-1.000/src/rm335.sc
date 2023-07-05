;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 335)
(include sci.sh)
(use Main)
(use rmnScript)
(use eRS)
(use RandCycle)
(use Feature)
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

(instance slugScript of rmnScript
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
				(self
					save1:
						(proc0_12
							{"AAAIIIIHHHH!!! It's a sea slug! Run, girls!"#j\a2\97\8c\87\b0\b0\b0\b0\b0\b0\ff\ff\ff\a0 \c5\d2\b8\bc\de\f6\ff\a0 \e6\99\de\f9\e9\f6\a4\f0\fd\e5\ff\a3}
							67
							2
							10
							28
							global130
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
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
			(2
				(self restore:)
				(= cycles 7)
			)
			(3
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

(instance strapScript of rmnScript
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
				(self
					save1:
						(proc0_12
							{"Sit down!"#j\a2\9d\fc\f8\e5\9b\92\ff\a3}
							67
							2
							10
							28
							global130
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 3)
			)
			(5
				(self restore:)
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
				(thoreen cycleSpeed: 1 setCycle: End)
				(zondra cycleSpeed: 1 setCycle: End self)
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
				(= seconds 10)
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
				(gEgo normal: 1 moveHead: 1 dispose:)
				(= cycles 1)
			)
			(3
				(SetFlag 4)
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance hugScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ripples setCycle: ForwardCounter 2)
				(slugHead setPri: 3 x: 144 y: 91 setMotion: MoveTo 144 130 self)
				(= cycles 3)
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
				(= cycles 1)
			)
			(3
				(self
					save1:
						(proc0_12
							{"OUR HERO!!"#j\a2\cb\b0\db\b0\e0\de\fc\ff\ff\a3}
							67
							2
							10
							28
							global130
							29
							(proc0_18 global155 global129)
							30
							1
							70
							315
						)
				)
				(= seconds 4)
			)
			(5
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
					setMotion: MoveTo 183 108
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
					setMotion: MoveTo 130 120
				)
			)
			(6
				(huggers setCel: 1 setCycle: End)
				(zondra dispose:)
				(guard dispose:)
				(= cycles 4)
			)
			(7
				(thoreen dispose:)
				(= cycles 20)
			)
			(8
				(huggers setCycle: CT 4 -1)
				(= cycles 4)
			)
			(9
				(thoreen init: view: 336 setLoop: 2 setCel: 0 x: 137 y: 116)
				(= cycles 1)
			)
			(10
				(self
					save1:
						(proc0_12
							{"Wasn't he great, girls?"#j\a2\e8\94\a4\96\fa\ea\a0\bd\c3\b7\e0\de\8f\e0\fc\e8\a4\a0 \f0\fd\e5\a1\a3}
							67
							2
							10
							28
							global136
							29
							global129
							30
							1
							70
							315
						)
				)
				(= seconds 7)
			)
			(12
				(self
					save1:
						(proc0_12
							{"Well Rog...I guess we can call it even. Thank you for ridding our fortress of that slimy, awful, sea slug."#j\a2\9f\fa\9c\de\8c\91\a4 \db\bc\de\a5\a5\a5\a5\a5\a5\a1\a0 \n\ef\91\a4\a0 \9a\fa\e3\de\95\91\92\9a\e6\9d\f9\fc\a1\a0 \n\91\e9\c5\d2\b8\bc\de\86\a0\e0\92\9c\de\9c\e3\98\fa\e3\91\f8\96\de\e4\93\a1\a3}
							67
							2
							20
							28
							(proc0_18 global137 global137)
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
			(14
				(self
					save1:
						(proc0_12
							{"I..uh..I know I can't blame you for backing out at the last minute. I guess I was a little overbearing. Sorry. Can we still be good friends?"#j\a2\91\e9\93\a5\a5\a5\a5\91\a4\91\e9\e8\a5\a5\a5\a5\a4\a0 \91\e5\e0\96\de\9c\f8\9a\de\f0\9c\e0\9a\e4\e6\e2\92\e3\ea\a0 \f3\93\9e\f2\e5\92\fc\a1\a0 \fc\e0\9c\96\de\a4\a0 \9d\9a\9c\a0\9a\de\93\92\fd\9d\97\de\e0\a0\f0\e0\92\e0\de\9c\a5\a5\a5\a5\a1 \n\e3\de\f3\a4\a0 \ef\e0\de\a0 \92\92\e4\f3\e0\de\e1\e3\de\92\f7\fa\f9\96\9c\f7\fe\a3}
							67
							2
							20
							28
							(proc0_18 global137 global137)
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
			(16
				(self
					save1:
						(proc0_12
							{"Well,... now wait a minute. Let's talk about this."#j\a2\9f\93\e0\de\e5\a5\a5\a5\a5\a4\e1\8e\8f\e4\ef\8f\e3\98\fa\a1\n\9f\fa\e6\e2\92\e3\ea\a4\a0 \f3\8f\e4\ea\e5\9c\91\95\93\a1\a3}
							67
							2
							10
							28
							global190
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
			(18
				(self
					save1:
						(proc0_12
							{"No Roger - you were right. You don't need to spare my feelings. It just wasn't meant to be. It's better this way."#j\a2\92\92\94\a4\db\bc\de\ac\b0\a1\a0 \91\e5\e0\ea\a4\e0\e0\de\9c\96\8f\e0\fc\a1\a0 \fc\e0\9c\e9\9a\e4\e5\fd\96\a0\97\e6\9c\e5\98\e3\92\92\fc\a1\a0 \n\97\8f\e4\a4\93\ef\98\92\98\a0\93\fd\f2\92\9c\de\8c\e5\96\8f\e0\e9\f6\a1\a3}
							67
							2
							20
							28
							(proc0_18 global137 global137)
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
			(20
				(self
					save1:
						(proc0_12
							{"Well girls, I feel like celebrating. LET'S GO SHOPPING!!!"#j\a2\9b\91\a4\f0\fd\e5\a1\a0 \fc\e0\9c\ea\a0 \95\92\fc\92\86\9c\e0\98\e5\8f\e0\fc\a1\a0 \96\92\f3\e9\e6\a0\92\97\ef\9c\8e\93\a1\a3}
							67
							2
							20
							28
							(proc0_18 global137 global137)
							29
							global129
							30
							1
							70
							315
						)
				)
				(heroSFX fade:)
				(= seconds 8)
			)
			(22
				(gEgo view: 0)
				(gCurRoom newRoom: 355)
			)
			(else
				(self restore:)
				(= cycles 1)
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

(instance zondra of Actor
	(properties
		x 100
		y 110
		description {Zondra}
		sightAngle 90
		lookStr {Boy! You don't know what you did to make her mad, but you sure hope you get a chance to smooth things over.}
		view 331
		loop 2
		priority 6
		signal 16400
	)
)

(instance thoreen of Actor
	(properties
		x 124
		y 169
		description {Thoreen}
		sightAngle 90
		lookStr {Compassion and warmth are not words which come to mind when surveying this person.}
		view 336
		loop 2
		priority 9
		signal 16400
	)
)

(instance guard of Actor
	(properties
		x 68
		y 134
		description {guard}
		sightAngle 90
		lookStr {The guard looks on coldly.}
		view 331
		loop 1
		priority 6
		signal 16400
	)
)

(instance tanks of Feature
	(properties
		x 207
		y 141
		nsTop 129
		nsLeft 195
		nsBottom 154
		nsRight 219
		description {oxygen tanks.}
		sightAngle 180
		lookStr {You see what look like highly pressurized oxygen tanks.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
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

(instance tongue of Prop
	(properties
		x 157
		y 88
		description {Slug tongue}
		lookStr {Yep, it's that nasty slug tongue again. Scary to think of what he can do with that thing, isn't it?}
		view 337
		priority 7
		signal 16400
	)
)

(instance slug of Prop
	(properties
		x 158
		y 96
		description {sea slug}
		sightAngle 180
		lookStr {This isn't your garden variety slug.}
		view 342
		priority 5
		signal 16
	)
)

(instance slugHead of Actor
	(properties
		x 158
		y 96
		description {slug head}
		sightAngle 180
		lookStr {Red eyes glare back at you.}
		view 342
		loop 2
		priority 6
		signal 16400
	)
)

(instance huggers of Prop
	(properties
		x 161
		y 109
		view 339
		priority 7
		signal 16400
	)
)

(instance ripples of Prop
	(properties
		x 143
		y 72
		view 342
		loop 4
	)
)

(instance oxyTank of Prop
	(properties
		x 204
		y 153
		description {oxygen tanks.}
		sightAngle 90
		lookStr {You see what look like highly pressurized oxygen tanks.}
		view 336
		loop 3
		priority 11
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
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

(instance theArea of Feature
	(properties
		x 156
		y 10
		nsBottom 200
		nsRight 320
		description {sea cave}
		sightAngle 180
		lookStr {This place is like a brick ship house.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

