;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Main)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	theNukem 2
	theStairs 3
	theQuirk 4
	thePatrons1 5
	thePatrons2 6
	thePlants 7
	theLamp 10
	sVictimExit 11
	sVictimGuardExit 12
	sGlob1 13
	sGlob2 14
	smallmonk 15
	tinymonk1 16
	tinymonk2 17
	tinymonk3 18
	tinymonk4 19
	monkswim 20
	monkswim2 21
	guy1 22
	sGuys 24
	guy1Mouth 25
	droid 27
	sDroidExit 28
	theBar 29
	theTable 30
	theTeleporter 31
	theAlien 32
	theDetention 33
	theSprint 34
)

(local
	local0
	local1
	local2
	local3
)

(instance sVictimExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				((ScriptID 500 1) setCycle: End self) ; victim
			)
			(2
				((ScriptID 500 1) ; victim
					view: 508
					setLoop: 0
					cel: 0
					setScale: Scaler 80 80 157 109
					x: 182
					y: 136
					setPri: 13
				)
				(= cycles 1)
			)
			(3
				((ScriptID 500 1) ; victim
					setCycle: Fwd
					cycleSpeed: 6
					setPri: 11
					setMotion: MoveTo 214 129 self
				)
			)
			(4
				((ScriptID 500 1) setStep: 6 6 setMotion: MoveTo 237 118 self) ; victim
			)
			(5
				((ScriptID 500 1) setLoop: 1 cel: 15 setCycle: 0) ; victim
				(= cycles 1)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sVictimGuardExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 500 2) ; guard2
					view: 507
					setLoop: 11
					cel: 0
					x: 139
					y: 131
					setScale: Scaler 103 85 146 131
				)
				(= seconds 1)
			)
			(1
				((ScriptID 500 2) ; guard2
					view: 511
					setLoop: 3
					cel: 0
					x: 139
					y: 131
					setPri: 13
					setCycle: Fwd
					setMotion: MoveTo 167 147 self
				)
			)
			(2
				((ScriptID 500 2) ; guard2
					view: 511
					setLoop: 0
					cel: 0
					setPri: 13
					setMotion: MoveTo 340 147 self
				)
			)
			(3
				((ScriptID 500 2) dispose:) ; guard2
				(self dispose:)
			)
		)
	)
)

(instance sGlob1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) ((ScriptID 500 3) detailLevel:)) ; lavaglob1
					((ScriptID 500 3) stopUpd:) ; lavaglob1
					(-- state)
				)
				(= seconds (Random 1 4))
			)
			(1
				((ScriptID 500 3) setMotion: MoveTo 188 2 self) ; lavaglob1
			)
			(2
				((ScriptID 500 3) setMotion: MoveTo 212 3 self) ; lavaglob1
			)
			(3
				((ScriptID 500 3) setMotion: MoveTo 188 83 self) ; lavaglob1
			)
			(4
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance sGlob2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) ((ScriptID 500 4) detailLevel:)) ; lavaglob2
					((ScriptID 500 4) stopUpd:) ; lavaglob2
					(-- state)
				)
				(= seconds 1)
			)
			(1
				((ScriptID 500 4) setMotion: MoveTo 200 86 self) ; lavaglob2
			)
			(2
				(= seconds (Random 1 4))
			)
			(3
				((ScriptID 500 4) setMotion: MoveTo 178 1 self) ; lavaglob2
			)
			(4
				((ScriptID 500 4) setMotion: MoveTo 210 1 self) ; lavaglob2
			)
			(5
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

(instance sGuys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gGame detailLevel:) (guy1Mouth detailLevel:))
					(guy1Mouth stopUpd:)
					(-- state)
				else
					(guy1Mouth setCycle: Fwd init:)
				)
				(= cycles 1)
			)
			(1
				(= seconds (Random 1 6))
			)
			(2
				(guy1Mouth setCycle: End self)
			)
			(3
				(= seconds (Random 1 6))
			)
			(4
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sDroidExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(droid setMotion: MoveTo 122 88 self)
			)
			(1
				(droid setPri: 3 setMotion: MoveTo 74 80 self)
			)
			(2
				(droid dispose:)
				(self dispose:)
			)
		)
	)
)

(instance droid of Actor
	(properties
		x 106
		y 96
		view 501
		loop 8
		priority 10
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 8
			setCycle: Fwd
			cycleSpeed: 10
			setStep: 6 6
			setScale: Scaler 100 80 96 80
		)
	)
)

(instance guy1 of View
	(properties
		x 208
		y 140
		noun 1
		view 515
		loop 11
		priority 14
		signal 16
	)
)

(instance guy1Mouth of Prop
	(properties
		x 216
		y 161
		noun 1
		view 515
		loop 12
		cel 2
		priority 14
		signal 16400
		detailLevel 2
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 12)
	)
)

(instance smallmonk of Actor
	(properties
		x 107
		y 78
		view 504
		loop 12
		priority 15
		signal 16400
	)

	(method (init)
		(super init: &rest)
	)
)

(instance tinymonk1 of Actor
	(properties
		x -10
		view 504
		loop 12
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 1)
			(0
				(super init: &rest)
				(self
					setLoop: 12
					x: -10
					y: (Random 10 180)
					setMotion: MoveTo 330 (Random 10 180) self
				)
			)
			(1
				(super init: &rest)
				(self
					setLoop: 12
					x: 330
					y: (Random 10 180)
					setMotion: MoveTo -10 (Random 10 180) self
				)
			)
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance tinymonk2 of Actor
	(properties
		x 107
		y 78
		view 504
		loop 13
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 1)
			(0
				(super init: &rest)
				(self
					setLoop: 12
					x: -10
					y: (Random 0 180)
					setMotion: MoveTo 330 (Random 10 200) self
				)
			)
			(1
				(super init: &rest)
				(self
					setLoop: 12
					x: 330
					y: (Random 0 200)
					setMotion: MoveTo -10 (Random 0 200) self
				)
			)
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance tinymonk3 of Actor
	(properties
		x 107
		y 78
		view 504
		loop 13
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 1)
			(0
				(super init: &rest)
				(self
					setLoop: 12
					x: -10
					y: (Random 0 180)
					setMotion: MoveTo 330 (Random 10 200) self
				)
			)
			(1
				(super init: &rest)
				(self
					setLoop: 12
					x: 330
					y: (Random 0 200)
					setMotion: MoveTo -10 (Random 0 200) self
				)
			)
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance tinymonk4 of Actor
	(properties
		x 107
		y 78
		view 504
		loop 13
		priority 12
		signal 16400
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 1)
			(0
				(super init: &rest)
				(self
					setLoop: 12
					x: -10
					y: (Random 0 180)
					setMotion: MoveTo 330 (Random 10 200) self
				)
			)
			(1
				(super init: &rest)
				(self
					setLoop: 12
					x: 330
					y: (Random 0 200)
					setMotion: MoveTo -10 (Random 0 200) self
				)
			)
		)
	)

	(method (cue)
		(self init:)
	)
)

(instance monkswim of Actor
	(properties
		noun 19
		view 505
		cel 4
		priority 13
		signal 18448
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 3)
			(0
				(= local1 200)
				(= local0 (Random 0 100))
				(= local3 0)
				(= local2 (Random 200 320))
				(self
					setLoop: 0
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(1
				(= local1 200)
				(= local0 (Random 220 320))
				(= local3 0)
				(= local2 (Random 0 100))
				(self
					setLoop: 1
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(2
				(= local1 0)
				(= local0 (Random 0 100))
				(= local3 200)
				(= local2 (Random 200 320))
				(self
					setLoop: 2
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(3
				(= local1 0)
				(= local0 (Random 220 320))
				(= local3 200)
				(= local2 (Random 0 100))
				(self
					setLoop: 3
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(self init:)
	)
)

(instance monkswim2 of Actor
	(properties
		noun 19
		view 505
		cel 4
		priority 13
		signal 18448
		illegalBits 0
	)

	(method (init)
		(switch (Random 0 3)
			(0
				(= local1 200)
				(= local0 (Random 0 100))
				(= local3 0)
				(= local2 (Random 200 320))
				(self
					setLoop: 0
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(1
				(= local1 200)
				(= local0 (Random 220 320))
				(= local3 0)
				(= local2 (Random 0 100))
				(self
					setLoop: 1
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(2
				(= local1 0)
				(= local0 (Random 0 100))
				(= local3 200)
				(= local2 (Random 200 320))
				(self
					setLoop: 2
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
			(3
				(= local1 0)
				(= local0 (Random 220 320))
				(= local3 200)
				(= local2 (Random 0 100))
				(self
					setLoop: 3
					x: local0
					y: local1
					setPri: 13
					setMotion: MoveTo local2 local3 self
				)
			)
		)
		(super init: &rest)
	)

	(method (cue)
		(self init:)
	)
)

(instance theNukem of Feature
	(properties
		x 70
		y 12
		noun 10
		modNum 500
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 theVerb 0 0) ; "Scumsoft's 'revolutionary' (cough, cough) new computer game, Battle Cruiser, occupies this platform."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theStairs of Feature
	(properties
		x 10
		y 128
		noun 22
		modNum 500
		onMeCheck 16
		approachX 40
		approachY 150
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(switch global167
					(0
						(gCurRoom setScript: (ScriptID 500 5)) ; sStairs
					)
					(1
						(gCurRoom setScript: (ScriptID 500 5)) ; sStairs
					)
					(2
						(gCurRoom setScript: (ScriptID 500 11)) ; sDownTheStairs
					)
				)
			)
			(4 ; Do
				(switch global167
					(0
						(gCurRoom setScript: (ScriptID 500 5)) ; sStairs
					)
					(1
						(gCurRoom setScript: (ScriptID 500 5)) ; sStairs
					)
					(2
						(gCurRoom setScript: (ScriptID 500 11)) ; sDownTheStairs
					)
				)
			)
			(1 ; Look
				(gMessager say: 22 theVerb 0 0 500) ; "This stairwell leads up to Scumsoft's latest and greatest new arcade game ''Battle Cruiser.''"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theQuirk of Feature
	(properties
		x 245
		y 10
		noun 15
		nsTop 2
		nsLeft 245
		nsBottom 15
		nsRight 261
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 53)
					(gMessager say: 15 theVerb 0 0 500) ; "Captain Quirk is sharing a drink with a familiar-looking alien..."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theAlien of Feature
	(properties
		x 245
		y 190
		noun 2
		modNum 500
		nsTop 2
		nsLeft 265
		nsBottom 15
		nsRight 291
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 53)
					(gMessager say: 2 theVerb 0 0 500) ; "This alien looks vaguely familiar..."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance thePatrons1 of Feature
	(properties
		x 10
		y 12
		noun 11
		modNum 500
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 54))
					(gMessager say: 11 theVerb 0 0 500) ; "Looking around the bar you see a mixture of humanoid and alien forms, most of them seriously occupied in the time honored military tradition of 'tying one on'."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance thePatrons2 of Feature
	(properties
		x 150
		y 50
		noun 12
		modNum 500
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 54))
					(gMessager say: 12 theVerb 0 0 500) ; "Off duty StarCon personnel frequently come to the SpaceBar to enjoy good food, fine music, and wholesome camaraderie. Finding none of this, they settle for cheap booze, karaoke, and bar brawls."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance thePlants of Feature
	(properties
		x 180
		y 12
		noun 13
		onMeCheck 256
	)
)

(instance theLamp of Feature
	(properties
		x 76
		y 108
		noun 8
		modNum 500
		nsTop 22
		nsLeft 168
		nsBottom 89
		nsRight 219
	)
)

(instance theBar of Feature
	(properties
		x 160
		y 90
		noun 4
		modNum 500
		nsTop 95
		nsLeft 157
		nsBottom 110
		nsRight 240
	)
)

(instance theTeleporter of Feature
	(properties
		x 260
		y 95
		noun 24
		modNum 500
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (IsFlag 62)
					(gCurRoom setScript: (ScriptID 500 8)) ; gotoTeleporterFTable
				else
					(gCurRoom setScript: (ScriptID 500 7)) ; gotoTeleporter
				)
			)
			(4 ; Do
				(if (IsFlag 62)
					(gCurRoom setScript: (ScriptID 500 8)) ; gotoTeleporterFTable
				else
					(gCurRoom setScript: (ScriptID 500 7)) ; gotoTeleporter
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theTable of Feature
	(properties
		x 76
		y 108
		noun 23
		modNum 500
		nsTop 85
		nsLeft 52
		nsBottom 124
		nsRight 102
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (and (not (IsFlag 62)) (not (IsFlag 54)))
					(gCurRoom setScript: (ScriptID 500 9)) ; gotoTable
				)
				(if (and (IsFlag 62) (not (IsFlag 54)))
					(gCurRoom newRoom: 520)
				)
			)
			(4 ; Do
				(if (and (not (IsFlag 62)) (not (IsFlag 54)))
					(gCurRoom setScript: (ScriptID 500 9)) ; gotoTable
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theDetention of Feature
	(properties
		x 310
		y 180
		nsTop 55
		nsLeft 305
		nsBottom 162
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(switch global167
					(1
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
					(2
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
					(0
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
				)
			)
			(4 ; Do
				(switch global167
					(1
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
					(2
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
					(0
						(gCurRoom setScript: (ScriptID 500 12)) ; sToDetention
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theSprint of Feature
	(properties
		x 310
		y 100
		noun 21
		modNum 500
		nsTop 70
		nsLeft 274
		nsBottom 120
		nsRight 319
	)
)

