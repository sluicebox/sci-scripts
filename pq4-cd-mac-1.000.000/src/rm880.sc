;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 880)
(include sci.sh)
(use Main)
(use n045)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm880 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm880 of Room
	(properties
		noun 1
		picture 880
	)

	(method (doRemap)
		(gGame doRemap: 2 243 95)
		(gGame doRemap: 2 244 75)
	)

	(method (init)
		(proc45_0)
		(proc0_4 0)
		(gThePlane setRect: 0 0 319 152)
		(super init: &rest)
		(gTheIconBar enable: show: 0)
		(gGlobalSound2 number: 1028 loop: -1 play:)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 42 152 225 152 212 133 86 133
					yourself:
				)
		)
		(gEgo
			heading: 360
			normalize: 9120
			x: 144
			y: 150
			setScaler: Scaler 95 78 150 126
			init:
		)
		(backGrd init: signal: (| (backGrd signal:) $4000))
		(door init: approachVerbs: 4 signal: (| (door signal:) $4000)) ; Do
		(metzler init: z: 1000 hide:)
		(stairs init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((> (gEgo y:) 150)
				(self newRoom: 17) ; MapRoom
			)
		)
	)
)

(instance stairs of Feature
	(properties
		noun 4
		x 70
		y 30
	)

	(method (init)
		(self createPoly: 36 0 114 0 35 140)
		(super init: &rest)
	)
)

(instance door of Prop
	(properties
		noun 2
		sightAngle 180
		approachX 181
		approachY 140
		approachDist 20
		x 169
		y 122
		priority 30
		fixPriority 1
		view 881
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(if (not cel)
					(gCurRoom setScript: knockScr)
				)
			)
			((== theVerb 52) ; notebook
				(if (not local1)
					(= local1 1)
					(gGame handsOff:)
					(gCurRoom setScript: noteScr)
				else
					(gMessager say: noun theVerb 4 0) ; "No need to rerecord the information. You have it all down."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance backGrd of Prop
	(properties
		noun 2
		sightAngle 180
		x 197
		y 121
		z -1
		priority 10
		fixPriority 1
		view 881
		loop 1
	)

	(method (doVerb theVerb)
		(door doVerb: theVerb)
	)
)

(instance metzler of Prop
	(properties
		noun 3
		sightAngle 180
		x 205
		y 128
		priority 20
		fixPriority 1
		view 880
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 27) ; badge
				(if (not local2)
					(gGame handsOff:)
					(gGame points: 2 98)
					(gCurRoom setScript: badgeScr)
				else
					(gMessager say: noun theVerb 1) ; "You already showed me that... Whadda ya think I am? Stupid?"
				)
			)
			((== theVerb 2) ; Talk
				(gGame handsOff:)
				(if local2
					(gCurRoom setScript: comeInScr)
				else
					(gCurRoom setScript: buggerOffScr)
				)
			)
			((== theVerb 22) ; handgun
				(cond
					((not local0)
						(gMessager say: 3 22 3) ; "Holster your weapon! There is no tactical rationale for this action!"
						(++ local0)
					)
					(((ScriptID 32 0) doit: 3 22 2 1 880) ; ShootHandgun, "Deadly use of force has resulted in a  first degree murder conviction.  Welcome to San Quentin."
						(self setScript: 0)
						(naziScr register: 2)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance noteScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 39 0) init: self) ; NotebookOut
			)
			(1
				(gMessager say: 2 52 0 0 self) ; "You notate the general description of the apartments."
			)
			(2
				((ScriptID 39 1) init: self 9120) ; NotebookIn
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance buggerOffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(metzler setScript: 0)
				(waitScr ticks: 0 cycles: 0 seconds: 0 dispose:)
				(gMessager say: 3 2 0 3 self) ; "I'd like to ask you a few questions."
			)
			(1
				(gMessager say: 3 2 0 2 self) ; "Bugger off, faggot!"
			)
			(2
				(metzler show: z: 0 setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(metzler z: 1000 hide:)
				(door cycleSpeed: 8 setCycle: CT 1 -1 self)
			)
			(4
				(naziScr register: 2)
				(door setCycle: Beg self)
			)
			(5
				(gGlobalSound0 setVol: 10)
				(sfx number: 33 loop: 1 play:)
				(= ticks 90)
			)
			(6
				(gGlobalSound0 setVol: 60)
				(gGame handsOn:)
				(gGlobalSound2 number: 1028 loop: -1 play:)
				(if 0
					(DoAudio audVOLUME 127 1028)
				)
				(self dispose:)
			)
		)
	)
)

(instance badgeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(metzler setScript: 0)
				(waitScr ticks: 0 cycles: 0 seconds: 0 dispose:)
				(gEgo view: 9126 setLoop: 3 cel: 0 setCycle: 0)
				(= ticks 90)
			)
			(1
				(gEgo cel: 1)
				(= ticks 30)
			)
			(2
				(gMessager say: 3 27 0 0 self) ; "I'm Detective Carey, LAPD. Are you Dennis Walker?"
			)
			(3
				(gEgo cel: 0)
				(= ticks 60)
			)
			(4
				(gEgo normalize: 9120)
				(= local2 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setCycle: 0 view: 9126 setLoop: 3 1 cel: 0)
				(= register 4)
				(= ticks 20)
			)
			(3
				(gEgo cel: 1)
				(= cycles 2)
			)
			(4
				(sfx number: 998 loop: 1 play:)
				(if (-- register)
					(-- state)
				)
				(= ticks 30)
			)
			(5
				(gEgo normalize: 9120)
				(= ticks 120)
			)
			(6
				(if (gPqFlags test: 105)
					(gMessager say: 2 4 0) ; "There's no response. It appears no one is home..."
					(gGame handsOn:)
					(self dispose:)
				else
					(gGlobalSound2 number: 0 stop:)
					(= ticks 30)
				)
			)
			(7
				(sfx number: 32 loop: 1 play:)
				(door cycleSpeed: 8 setCycle: CT 1 1 self)
				(metzler show: z: 0)
			)
			(8
				(= ticks 10)
			)
			(9
				(naziScr init:)
				(door setCycle: End self)
			)
			(10
				(metzler
					signal: (| (metzler signal:) $4000)
					setScaler: Scaler 120 107 147 124
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(11
				(gMessager say: 3 2 0 5 self) ; "Yeah."
			)
			(12
				(metzler setLoop: 1 cel: 0 setCycle: End setScript: waitScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance naziScr of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(super dispose:)
		(gTheDoits delete: self)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local3)
					(= local3 1)
					(gGlobalSound0 number: 885 loop: -1 flags: 5 play: setVol: 60)
				)
				(= register 0)
				(= cycles 2)
			)
			(1
				(switch register
					(0
						(-- state)
						(if (not (gGlobalSound2 handle:))
							(gGlobalSound2 number: 947 loop: -1 play: flags: 5)
							(if 0
								(DoAudio audVOLUME 43 947)
							)
						)
						(= ticks 10)
					)
					(2
						(gGlobalSound2 number: 0 stop:)
						(gGlobalSound0 number: 0 stop:)
						(= local3 0)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance waitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 8)
			)
			(1
				(if (not (OneOf (gCurRoom script:) badgeScr buggerOffScr))
					(gGame handsOff:)
					(metzler show: z: 0 setLoop: 2 cel: 0 setCycle: End self)
				)
			)
			(2
				(metzler hide: z: 1000)
				(door cycleSpeed: 8 setCycle: CT 1 -1 self)
			)
			(3
				(naziScr register: 2)
				(door setCycle: Beg self)
			)
			(4
				(gGlobalSound0 setVol: 10)
				(sfx number: 33 loop: 1 play:)
				(= ticks 90)
			)
			(5
				(gGlobalSound0 setVol: 60)
				(gGlobalSound2 number: 1028 loop: -1 play:)
				(if 0
					(DoAudio audVOLUME 127 1028)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance comeInScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 2 0 3 self) ; "I'd like to ask you a few questions."
			)
			(1
				(gMessager say: 3 2 0 4 self) ; "Yeah, c'mon in."
				(= register 120)
				(naziScr register: 3)
			)
			(2
				(if (> (-= register 24) 24)
					(gGlobalSound0 setVol: register)
					(-- state)
					(= ticks 30)
				else
					(if 0
						(DoAudio audVOLUME 1 974)
					)
					(= cycles 2)
				)
			)
			(3
				(gThePlane drawPic: -1)
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(4
				(sfx number: 33 loop: 1 play:)
				(= ticks 90)
			)
			(5
				(gCurRoom newRoom: 885)
			)
		)
	)
)

