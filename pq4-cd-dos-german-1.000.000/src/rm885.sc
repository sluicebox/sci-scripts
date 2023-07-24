;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 885)
(include sci.sh)
(use Main)
(use TellerIcon)
(use n030)
(use Str)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm885 0
)

(local
	local0
	[local1 2] = [100 72]
	local3
	local4
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (Str newWith: 400 {}))
	(if (Message msgGET 0 0 param2 0 1 0 (temp0 data:))
		(gMessager say: 0 param2 0 0 0 0)
	)
	(temp0 dispose:)
)

(instance rm885 of Room
	(properties
		noun 1
		picture 885
	)

	(method (doRemap)
		(gGame doRemap: 2 253 85)
		(gGame doRemap: 2 254 75)
	)

	(method (init)
		(= local4 1)
		(if (== gPrevRoomNum 880)
			(= local3 1)
		)
		(proc0_4 1)
		(gGame handsOn:)
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 308 143 287 136 269 140 253 138 228 125 173 117 149 121 123 121 84 115 109 149 307 149
					yourself:
				)
		)
		(gEgo
			heading: 270
			normalize: 9120
			x: 275
			y: 143
			setScaler: Scaler 90 72 143 113
			init:
		)
		(metzler
			init:
			signal: (| (metzler signal:) $4000)
			setScript: nervousScr
		)
		(metzTeller init: metzler 885)
		(head
			signal: (| (head signal:) $4000)
			x: (- (metzler x:) 2)
			y: (- (metzler y:) 74)
			code: headCode
			init:
		)
		(naziScr init:)
		(flag init:)
		(fireplace init:)
		(leftLamp init:)
		(table init:)
		(chair init:)
		(outside init:)
		(speaker init:)
		(fish init:)
		(cabinet init:)
		(rightLamp init:)
		(tv init:)
		(radio init: approachVerbs: 4) ; Do
		(door init:)
		(skull init:)
		(swastika init:)
		(whitePower init:)
		(plant init:)
		(drapes init:)
		(ss init:)
		(hat init:)
	)

	(method (dispose)
		(gGlobalSound0 stop:)
		(gGlobalSound1 stop:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (not local4)
			(localproc_0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance metzTeller of Teller
	(properties
		sayNoun 23
		verb 5
	)

	(method (sayMessage)
		(if (== iconValue 4)
			(gGame handsOff:)
			(gCurRoom setScript: pointScr)
		)
		(super sayMessage:)
	)
)

(instance pointScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(metzler setCycle: 0 setScript: 0)
				(if (metzler cel:)
					(metzler setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(head hide:)
				(metzler view: 8853 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(metzler setCycle: Beg self)
			)
			(4
				(head show:)
				(metzler view: 8851 cel: 0 setScript: nervousScr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knife of View
	(properties
		view 887
		loop 3
	)
)

(instance girl of Actor
	(properties
		noun 24
		x -50
		y 132
		view 885
		xStep 6
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 22) ; handgun
				(gGame points: 3 100)
				(cond
					(local0
						(proc30_0 noun 0 6 1 885)
					)
					((and (== (gEgo view:) 9885) (== (gEgo loop:) 0))
						(gGame handsOff:)
						(gCurRoom setScript: kneelDrawScr)
					)
					(else
						(gGame handsOff:)
						(gCurRoom setScript: drawScr)
					)
				)
			)
			((== theVerb 47) ; handcuffs
				(if (== (gCurRoom script:) dropKnifeScr)
					(gGame handsOff:)
					(gGame points: 3 101)
					(gCurRoom setScript: cuffScr)
				else
					(gMessager say: 24 64 0 0 0 885) ; "No time for that!"
				)
			)
			((== theVerb 4) ; Do
				(if (== (gCurRoom script:) dropKnifeScr)
					(gMessager say: noun theVerb 12) ; "Physical restraint will work only so well. Think tactics!"
				else
					(gMessager say: noun theVerb 13) ; "Tactics teach to avoid physical contact."
				)
			)
			((== theVerb 2) ; Talk
				(cond
					((and (== (gEgo view:) 9885) (== (gEgo loop:) 0))
						(gMessager say: noun theVerb 12) ; "Stay where you are. Do not move!"
					)
					((== (gEgo view:) 9885)
						(gMessager say: noun theVerb 13) ; "Keep your hands where I can see them!"
					)
					((OneOf (girl script:) girlScr hesitateScr)
						(gGame handsOff:)
						(girl setScript: 0)
						(gCurRoom setScript: handsUpScr)
					)
					((== (gCurRoom script:) handsUpScr)
						(gGame handsOff:)
						(gCurRoom setScript: dropKnifeScr)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance metzler of Prop
	(properties
		noun 22
		x 132
		y 118
		view 8851
	)
)

(instance head of Actor
	(properties
		noun 22
		view 8852
	)

	(method (doVerb theVerb)
		(metzler doVerb: theVerb)
	)
)

(instance headCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(cond
			(
				(and
					(>
						(= temp0
							(GetAngle
								(param1 x:)
								(+ (param1 y:) 50)
								(gEgo x:)
								(gEgo y:)
							)
						)
						80
					)
					(< temp0 115)
				)
				(param1 cel: 6)
			)
			((and (> temp0 114) (< temp0 140))
				(param1 cel: 5)
			)
			((and (> temp0 139) (< temp0 165))
				(param1 cel: 4)
			)
			((and (> temp0 164) (< temp0 190))
				(param1 cel: 3)
			)
			((and (> temp0 189) (< temp0 215))
				(param1 cel: 2)
			)
			((and (> temp0 214) (< temp0 240))
				(param1 cel: 1)
			)
			((and (> temp0 239) (< temp0 280))
				(param1 cel: 0)
			)
		)
	)
)

(instance nervousScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 7))
			)
			(1
				(= state -1)
				(metzler cel: 0 setCycle: End self)
			)
		)
	)
)

(instance turnOffRadioScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo radio self)
			)
			(1
				(metzler setCycle: 0 setScript: 0)
				(gEgo
					view: 9885
					setLoop: 0 1
					cel: 0
					x: (+ (gEgo x:) 8)
					setCycle: End self
				)
			)
			(2
				(if (metzler cel:)
					(metzler setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(head dispose:)
				(= local4 0)
				(metzler view: 8854 setLoop: 0 cel: 0 setCycle: CT 12 1 self)
			)
			(5
				(metzler setPri: 100 setCycle: End self)
			)
			(6
				(metzler setLoop: 1 cel: 0 setCycle: CT 4 1 self)
			)
			(7
				(metzler setPri: 4 setCycle: End self)
			)
			(8
				(metzler setLoop: 2 cel: 0 setCycle: End self)
			)
			(9
				(naziScr state: 1 cue:)
				(metzler dispose:)
				(gFeatures eachElementDo: #sightAngle 180)
				(gEgo setScript: egoHandleScr)
				(gGame handsOn:)
				(girl
					init:
					setSpeed: (gEgo cycleSpeed:)
					signal: (| (girl signal:) $4004)
					xStep: 6
					setCycle: Fwd
					setScript: girlScr
				)
				(self dispose:)
			)
		)
	)
)

(instance egoHandleScr of Script
	(properties)

	(method (init)
		(gWalkHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((not (& (event type:) evMOVE))
				(if (not local4)
					(event claimed: 0)
					(return)
				else
					(super handleEvent: event)
					(return)
				)
			)
			((== (gEgo view:) 9885)
				(gGame handsOff:)
				(self setScript: standUpScr)
				(event claimed: 1)
				(return)
			)
			(else
				(event claimed: 1)
				(return)
			)
		)
	)
)

(instance standUpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance girlScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl setMotion: MoveTo 96 (gEgo y:) self)
			)
			(1
				(girl setCycle: 0)
				(= seconds 6)
			)
			(2
				(cond
					((== (gEgo view:) 9886)
						(= cycles 1)
					)
					((and (== (gEgo view:) 9885) (== (gEgo loop:) 0))
						(girl
							setCycle: Walk
							setMotion: MoveTo 105 (girl y:) self
						)
					)
					(else
						(girl
							setCycle: Walk
							setMotion: MoveTo 112 (girl y:) self
						)
					)
				)
			)
			(3
				(if local0
					(girl setCycle: 0)
					(girl setScript: hesitateScr)
				else
					(gGame handsOff:)
					(gCurRoom setScript: stabScr 0 0)
				)
			)
		)
	)
)

(instance hesitateScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (OneOf (gCurRoom script:) drawScr kneelDrawScr))
					(= cycles 2)
				)
			)
			(1
				(= seconds 6)
			)
			(2
				(gGame handsOff:)
				(gCurRoom setScript: stabScr 0 0)
			)
		)
	)
)

(instance stabScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(girl
					setSpeed: (gEgo cycleSpeed:)
					view: 886
					setLoop: 0
					cel: 0
					setPri: (- (gEgo priority:) 1)
					setCycle: CT (if register 5 else 6) 1 self
				)
			)
			(1
				(proc30_0 24 0 5 1 885)
			)
		)
	)
)

(instance handsUpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 4 102)
				(girl
					setCycle: Walk
					setMotion: MoveTo (- (gEgo x:) 56) (girl y:) self
				)
			)
			(1
				(gMessager say: 24 2 8 1 self) ; "Freeze. Hands in the air! Keep them where I can see them!"
			)
			(2
				(girl
					view: 887
					setLoop: 0
					cel: 0
					x: (- (girl x:) 5)
					y: (- (girl y:) 3)
					setCycle: End self
				)
			)
			(3
				(gGame handsOn:)
				(= seconds 6)
			)
			(4
				(gGame handsOff:)
				(gCurRoom setScript: stabScr 0 1)
			)
		)
	)
)

(instance dropKnifeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 4 103)
				(gMessager say: 24 2 9 1 self) ; "Drop the knife!"
			)
			(1
				(girl setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(knife
					init:
					signal: (| (knife signal:) $4000)
					x: (+ (girl x:) 23)
					y: (+ (girl y:) 1)
				)
				(= cycles 2)
			)
			(3
				(gMessager say: 24 2 9 2 self) ; "Put your hands behind your head! Turn around. Drop to your knees. Now!"
			)
			(4
				(girl view: 888 setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(girl setLoop: 1 cel: 0 setCycle: End self)
			)
			(6
				(gEgo
					view: 9887
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 21)
					y: (+ (gEgo y:) 2)
					setCycle: CT 7 1 self
				)
				(girl view: 889 setLoop: 0 cel: 0 setCycle: End self)
			)
			(7 0)
			(8
				(gGame handsOn:)
				(= seconds 6)
			)
			(9
				(gGame handsOff:)
				(girl setCycle: Beg self)
			)
			(10
				(proc30_0 24 2 10 1 885)
			)
		)
	)
)

(instance cuffSnd of Sound
	(properties
		number 992
	)
)

(instance cuffScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: End self)
			)
			(1
				(gEgo view: 9888 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 9889
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 2)
					setCycle: End self
				)
				(cuffSnd play:)
			)
			(3
				(gEgo
					view: 9890
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 1)
					setCycle: End self
				)
				(girl
					setSpeed: (gEgo cycleSpeed:)
					view: 8850
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(4 0)
			(5
				(cuffSnd play:)
				(gEgo setLoop: 1 cel: 0)
				(girl setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(6
				(gEgo cel: 1)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(7
				(gEgo cel: 2)
				(girl cel: 4)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(8
				(gEgo cel: 3)
				(girl cel: 5)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(9
				(gEgo cel: 4)
				(girl cel: 6)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(10
				(gEgo cel: 5)
				(girl cel: 7)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(11
				(gEgo cel: 6)
				(girl cel: 8)
				(= cycles (Max 1 (gEgo cycleSpeed:)))
			)
			(12
				(gEgo cel: 7)
				(girl cel: 10 setCycle: End self)
			)
			(13
				(gMessager say: 24 2 11 0 self) ; "You have the right to remain silent..."
			)
			(14
				(gPqFlags set: 105)
				(gCurRoom newRoom: 540)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 7)
				(not cycles)
				(not (gEgo cycler:))
				(not (girl cycler:))
			)
			(self cue:)
		)
	)
)

(instance kneelDrawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(2
				(= local0 1)
				(gEgo
					view: 9886
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 34)
					setCycle: End self
				)
			)
			(3
				(gGame handsOn:)
				(if (== (girl script:) hesitateScr)
					(hesitateScr cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance drawScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gEgo
					view: 9886
					setLoop: 0
					cel: 0
					x: (- (gEgo x:) 34)
					setCycle: End self
				)
			)
			(1
				(gGame handsOn:)
				(if (== (girl script:) hesitateScr)
					(hesitateScr cue:)
				)
				(self dispose:)
			)
		)
	)
)

(instance flag of Feature
	(properties
		noun 3
		x 42
		y 24
	)

	(method (init)
		(self createPoly: 13 2 71 7 73 41 15 39)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fireplace of Feature
	(properties
		noun 4
		x 55
		y 107
	)

	(method (init)
		(self createPoly: 10 64 79 58 84 111 14 125)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftLamp of Feature
	(properties
		noun 5
		x 31
		y 119
	)

	(method (init)
		(self
			createPoly: 17 60 45 62 51 93 36 93 42 99 41 113 37 121 21 121 16 110 17 99 21 94 21 91 1 87
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		noun 6
		x 44
		y 118
	)

	(method (init)
		(self createPoly: 15 114 68 112 80 121 45 131 14 133 14 127 6 123)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		noun 7
		x 53
		y 149
	)

	(method (init)
		(self createPoly: 0 118 11 125 16 132 79 121 102 138 105 154 0 153)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance outside of Feature
	(properties
		noun 16
		x 128
		y 101
	)

	(method (init)
		(self createPoly: 107 12 147 13 145 105 107 107)
		(super init: &rest)
	)
)

(instance speaker of Feature
	(properties
		noun 8
		x 176
		y 105
	)

	(method (init)
		(self createPoly: 168 65 189 65 188 109 165 106)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fish of Feature
	(properties
		noun 9
		x 203
		y 83
	)

	(method (init)
		(self createPoly: 191 65 224 66 226 82 217 86 189 83)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabinet of Feature
	(properties
		noun 15
		x 202
		y 110
	)

	(method (init)
		(self
			createPoly: 190 83 218 87 226 82 227 111 218 114 180 109 181 102 189 97 197 91 179 90 177 85 190 80
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightLamp of Feature
	(properties
		noun 11
		x 231
		y 112
	)

	(method (init)
		(self
			createPoly: 223 55 240 55 240 74 233 73 234 79 236 83 234 117 227 112 225 89 229 74 218 73
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tv of Feature
	(properties
		noun 12
		x 254
		y 70
	)

	(method (init)
		(self createPoly: 241 54 271 54 272 74 240 72)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance radio of Feature
	(properties
		noun 2
		approachX 204
		approachY 133
		x 243
		y 122
	)

	(method (init)
		(self createPoly: 235 72 277 75 277 127 251 129 232 120)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((== theVerb 4) ; Do
				(gGame handsOff:)
				(gGame points: 3 99)
				(gCurRoom setScript: turnOffRadioScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		noun 17
		x 308
		y 55
	)

	(method (init)
		(self createPoly: 319 6 319 141 289 129 288 7)
		(super init: &rest)
	)
)

(instance skull of Feature
	(properties
		noun 18
		x 308
		y 56
	)

	(method (init)
		(self
			createPoly: 317 72 305 73 301 69 299 61 294 53 296 47 298 37 302 31 313 30 319 32
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swastika of Feature
	(properties
		noun 19
		x 269
		y 36
	)

	(method (init)
		(self createPoly: 265 23 276 24 285 31 273 53 254 40)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance whitePower of Feature
	(properties
		noun 20
		x 246
		y 21
	)

	(method (init)
		(self createPoly: 249 7 271 7 277 15 243 30 227 28 222 21)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance plant of Feature
	(properties
		noun 13
		x 210
		y 46
	)

	(method (init)
		(self createPoly: 214 5 220 18 212 50 206 49 202 45 206 28 199 10)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drapes of Feature
	(properties
		noun 14
		x 180
		y 45
	)

	(method (init)
		(self createPoly: 145 4 206 5 205 96 144 106)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ss of Feature
	(properties
		noun 21
		x 95
		y 33
	)

	(method (init)
		(self createPoly: 88 21 102 24 100 46 85 37)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hat of Feature
	(properties
		noun 25
		x 215
		y 125
	)

	(method (init)
		(self createPoly: 215 114 221 125 235 117 237 113 224 109)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((not local4)
				(localproc_0 noun theVerb)
			)
			((gCast contains: metzler)
				(super doVerb: theVerb &rest)
			)
			((== theVerb 4) ; Do
				(return)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not (gGlobalSound2 handle:))
					(gGlobalSound2 number: 947 loop: -1 flags: 5 play:)
				)
				(if 0
					(DoAudio audVOLUME 86 947)
				)
				(if (not local3)
					(= local3 1)
					(gGlobalSound0 number: 885 loop: -1 flags: 1 play:)
				)
				(gGlobalSound0 setVol: 100)
			)
			(1
				(self state: -1 cue:)
			)
			(2
				(= temp0 (* (= temp0 33) 2))
				(gGlobalSound0 setVol: temp0)
				(if 0
					(DoAudio audVOLUME 1 947)
				)
				(= local3 0)
				(self dispose:)
			)
		)
	)
)

