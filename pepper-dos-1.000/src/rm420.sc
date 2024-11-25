;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use ADRoom)
(use Scaler)
(use RandCycle)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm420 0
)

(local
	local0 = 1
)

(instance rm420 of ADRoom
	(properties
		noun 1
		picture 420
		north 370
		south 411
		vanishingY 100
	)

	(method (init)
		(gGame setEgo: (ScriptID 895 1)) ; lockjaw
		(gEgo init: normalize:)
		(switch gPrevRoomNum
			(north
				(gEgo
					x: 270
					y: 127
					setHeading: 180
					setScale: Scaler 100 23 153 118
				)
				(gCurRoom setScript: sWalkIn)
			)
			(south
				(gEgo
					x: 57
					y: 157
					setHeading: 0
					setScale: Scaler 116 100 169 110
				)
				(gCurRoom setScript: sWalkIn)
			)
			(else
				(gEgo
					x: 57
					y: 157
					setHeading: 0
					setScale: Scaler 103 70 166 110
				)
				(gCurRoom setScript: sWalkIn)
			)
		)
		(super init: &rest)
		(gLongSong number: 420 loop: -1 flags: 1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 71 185 62 119 102 120 197 154 281 155 269 125 260 125 246 148 201 148 106 114 54 114 28 182
					yourself:
				)
		)
		(closeup addToPic:)
		(closeupRtWall init: stopUpd:)
		(middle addToPic:)
		(faraway addToPic:)
		(weeds init:)
		(slime1 init:)
		(slime2 init:)
		(slime3 init:)
		(slime4 init:)
		(slime5 init:)
		(if (== gAct 2)
			(firePlace approachVerbs: 6 30 3 86 init: setCycle: Fwd) ; Look, Paw, Walk, Nose
		else
			(firePlace
				approachVerbs: 6 30 3 86 ; Look, Paw, Walk, Nose
				loop: 1
				cel: 0
				posn: 259 107
				init:
				stopUpd:
			)
		)
		(if (== gEgo (ScriptID 895 1)) ; lockjaw
			(gWalkHandler addToFront: firePlace)
		)
		(southEFeature init:)
		(northEFeature init:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script)
			((and local0 (< (gEgo x:) 219) (> (gEgo x:) 75))
				(gCurRoom setScript: sDontScaleLJ)
			)
			((and (not local0) (& temp0 $0008))
				(gCurRoom setScript: sScaleLJright)
			)
			((and (not local0) (& temp0 $0010))
				(gCurRoom setScript: sScaleLJleft)
			)
			((& temp0 $0004)
				(if (== gAct 2)
					(gCurRoom setScript: sFireplaceOnLook)
				else
					(gCurRoom setScript: sFireplaceOffLook)
				)
			)
			((& temp0 $0002)
				(gCurRoom newRoom: south)
			)
		)
	)

	(method (dispose)
		(if (== gEgo (ScriptID 895 1)) ; lockjaw
			(gWalkHandler delete: firePlace)
		)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sWalkIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gEgo setMotion: MoveFwd 20 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGeneralCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(general setCycle: CT 1 1 self)
			)
			(1
				(Imapic hide:)
				(general setCycle: End self)
			)
			(2
				(Imapic show: loop: 3 cel: 0 posn: 187 107 addToPic:)
				(sFX number: 3702 play:)
				(= ticks 10)
			)
			(3
				(general
					loop: 1
					cel: 0
					posn: (+ (general x:) 7) (+ (general y:) 2)
					setCycle: CT 8 1 self
				)
			)
			(4
				(general setCycle: CycleBet 8 10 -1)
				(sFX number: 3703 play: self)
			)
			(5
				(general cel: 0 setCycle: 0)
				(sFX number: 3705 play: self)
				(openSafe init: addToPic:)
			)
			(6
				(general loop: 2 cel: 0 setCycle: End self)
				(sFX number: 3715 play:)
			)
			(7
				(general view: 423 cel: 0)
				(UnLoad 128 428)
				(percy setCycle: Walk setMotion: MoveTo 130 121 self)
			)
			(8
				(percy view: 423 cel: 1)
				(UnLoad 128 819)
				((ScriptID 2006 0) talkWidth: 140) ; pughHeadTalk
				(= gDictionaryWord 95)
				(gMessager say: 6 0 1 1 7 self) ; "Percy! How is the 'tax' operation going? Are you keeping those stupid sentries in line? They don't know the Stamp Tax is a fake, do they?"
			)
			(9
				(gMessager say: 6 0 1 8 13 self) ; "I want you to keep an eye on Ben Franklin, in case he decides to get out of that oversized washtub. I don't want anything interfering with our plans."
			)
			(10
				((ScriptID 2006 0) talkWidth: 110) ; pughHeadTalk
				(self dispose:)
			)
		)
	)
)

(instance sFireOn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(closeupRtWall dispose:)
				(firePlace dispose:)
				(gEgo dispose:)
				(gCurRoom drawPic: 421)
				(fire init: setCycle: RandCycle setSpeed: 12)
				(Imapic init: stopUpd:)
				(general init:)
				(percy init:)
				(UnLoad 128 807)
				(= seconds 4)
			)
			(1
				(self setScript: sGeneralCartoon self)
			)
			(2
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance sFireplaceOnLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 412 3)
				(= cycles 1)
			)
			(1
				(gLongSong number: 371 loop: -1 flags: 1 play:)
				(= cycles 1)
			)
			(2
				(gMessager say: 4 6 2 0 self) ; "Lockjaw can see people just beyond the fire..."
			)
			(3
				(client setScript: sFireOn)
			)
		)
	)
)

(instance sFireplaceOffLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 491 3)
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				(closeupRtWall dispose:)
				(firePlace dispose:)
				(gEgo hide:)
				(Imapic init: addToPic:)
				(gCurRoom drawPic: 421)
				(= seconds 4)
			)
			(2
				(gEgo x: 160 y: 160)
				(gMessager say: 4 6 3 0 self) ; "The fire is out. What an excellent chance to check out the study!"
			)
			(3
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sFireplaceOnPaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 412 3)
				(= cycles 1)
			)
			(1
				(gLongSong number: 371 loop: -1 flags: 1 play:)
				(= cycles 1)
			)
			(2
				(gMessager say: 4 30 0 0 self) ; "YIPE!"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFireplaceOffPaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 412 3)
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				(closeupRtWall dispose:)
				(firePlace dispose:)
				(gEgo hide:)
				(Imapic init: addToPic:)
				(gCurRoom drawPic: 421)
				(= seconds 4)
			)
			(2
				(gEgo x: 160 y: 160)
				(gMessager say: 4 6 3 0 self) ; "The fire is out. What an excellent chance to check out the study!"
			)
			(3
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance sDontScaleLJ of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(= cycles 1)
			)
			(1
				(gEgo setScale: 0)
				(self dispose:)
			)
		)
	)
)

(instance sScaleLJright of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= cycles 1)
			)
			(1
				(gEgo setScale: Scaler 100 23 153 118)
				(self dispose:)
			)
		)
	)
)

(instance sScaleLJleft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= cycles 1)
			)
			(1
				(gEgo setScale: Scaler 116 100 169 110)
				(self dispose:)
			)
		)
	)
)

(instance closeup of View
	(properties
		x 57
		y 180
		noun 1
		view 420
		priority 6
		signal 16400
	)
)

(instance closeupRtWall of View
	(properties
		x 78
		y 21
		noun 1
		view 420
		loop 1
		priority 15
		signal 16400
	)
)

(instance middle of View
	(properties
		x 150
		y 159
		noun 1
		view 420
		cel 2
		priority 6
		signal 16400
	)
)

(instance faraway of View
	(properties
		x 244
		y 59
		z -100
		noun 1
		view 420
		cel 1
		priority 6
		signal 16400
	)
)

(instance Imapic of View
	(properties
		x 139
		y 53
		view 428
		loop 3
		cel 1
	)
)

(instance openSafe of View
	(properties
		x 157
		y 56
		view 428
		loop 3
		cel 4
	)
)

(instance weeds of Feature
	(properties
		x 30
		y 180
		noun 3
		nsTop 10
		nsLeft 19
		nsBottom 53
		nsRight 42
		sightAngle 40
	)
)

(instance slime1 of Feature
	(properties
		x 18
		y 180
		noun 2
		nsTop 71
		nsLeft 10
		nsBottom 88
		nsRight 26
		sightAngle 40
	)
)

(instance slime2 of Feature
	(properties
		x 17
		y 180
		noun 2
		nsTop 106
		nsLeft 9
		nsBottom 146
		nsRight 26
		sightAngle 40
	)
)

(instance slime3 of Feature
	(properties
		x 95
		y 180
		noun 2
		nsTop 31
		nsLeft 88
		nsBottom 50
		nsRight 103
		sightAngle 40
	)
)

(instance slime4 of Feature
	(properties
		x 97
		y 180
		noun 2
		nsTop 61
		nsLeft 91
		nsBottom 101
		nsRight 103
		sightAngle 40
	)
)

(instance slime5 of Feature
	(properties
		x 96
		y 180
		noun 2
		nsTop 113
		nsLeft 90
		nsBottom 135
		nsRight 102
		sightAngle 40
	)
)

(instance firePlace of Prop
	(properties
		x 265
		y 120
		noun 4
		approachX 260
		approachY 125
		view 430
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (== gAct 2)
					(gCurRoom setScript: sFireplaceOnLook)
				else
					(gCurRoom setScript: sFireplaceOffLook)
				)
			)
			(30 ; Paw
				(if (== gAct 2)
					(gCurRoom setScript: sFireplaceOnPaw)
				else
					(gCurRoom setScript: sFireplaceOffPaw)
				)
			)
			(3 ; Walk
				(if (== gAct 2)
					(gCurRoom setScript: sFireplaceOnPaw)
				else
					(gCurRoom setScript: sFireplaceOffPaw)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance general of Prop
	(properties
		x 187
		y 107
		view 428
	)
)

(instance percy of Actor
	(properties
		x 96
		y 121
		view 819
		priority 7
		signal 16
	)
)

(instance fire of Actor
	(properties
		x 157
		y 150
		view 422
		priority 13
		signal 16
		cycleSpeed 15
	)
)

(instance sFX of Sound
	(properties
		flags 1
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 164
		nsLeft 14
		nsBottom 181
		nsRight 99
		cursor 910
		exitDir 3
		noun 1
	)
)

(instance northEFeature of ExitFeature
	(properties
		nsTop 116
		nsLeft 254
		nsBottom 125
		nsRight 274
		cursor 912
		exitDir 1
		noun 1
	)

	(method (doVerb theVerb)
		(firePlace doVerb: theVerb)
	)
)

