;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)

(public
	rm280 0
)

(local
	local0 = -1
	local1 = -1
)

(instance rm280 of Rm
	(properties
		noun 1
		picture 280
		north 290
		south 260
	)

	(method (init)
		(Load rsVIEW 280)
		(LoadMany
			rsSOUND
			13
			119
			125
			126
			128
			130
			168
			176
			177
			178
			183
			229
			241
			259
			261
			335
		)
		(doorway init:)
		(birdPerch init:)
		(spearTire init:)
		(drBPortrait init:)
		(bigEyesMask init: actions: bigEyes)
		(bigEyes init:)
		(bigLipsMask init: actions: bigLips)
		(bigLips init:)
		(blackMask init: actions: redEyes)
		(redEyes init:)
		(boneNoseMask init: actions: boneNose)
		(boneNose init:)
		(skullMask init: actions: skullTeeth)
		(skullTeeth init:)
		(birdsinbush init:)
		(topTotumPole init:)
		(middleTotumPole init:)
		(bottomTotumPole init:)
		(bongos init:)
		(caneChair init:)
		(computer init:)
		(keyboard init:)
		(shorts init:)
		(rug init:)
		(middleTot init: actions: middleTotumPole)
		(outsideWindow init:)
		(if (not (IsFlag 44))
			(keyProp init:)
		)
		(monitor init:)
		(if (not (IsFlag 43))
			(glassPanel init:)
		else
			(bookCase init:)
		)
		(if (IsFlag 45)
			(bookCase cel: 1 x: 110 y: 48)
		)
		(gCMusic number: 13 setLoop: -1 play:)
		(maskSound init:)
		(super init:)
	)

	(method (dispose)
		(maskSound dispose:)
		(if (IsObject (ScriptID 285 0)) ; bookCase
			((ScriptID 285 0) dispose:) ; bookCase
		)
		(DisposeScript 285)
		(if (IsObject (ScriptID 283 0)) ; hutMasks
			((ScriptID 283 0) dispose:) ; hutMasks
		)
		(DisposeScript 283)
		(super dispose: &rest)
	)
)

(instance moveBookcase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 178 setLoop: 1 play: 127)
				(bookCase setMotion: MoveTo 61 (bookCase y:) self)
			)
			(1
				(gMessager say: 5 27 0 0 self) ; "Aha! The old sliding bookshelf trick."
			)
			(2
				(SetFlag 45)
				(bookCase cel: 1 x: 109)
				(self dispose:)
			)
		)
	)
)

(instance giveKey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 261 setLoop: 1 play: 127)
				(topTotumPole setCycle: End self)
				(keyProp setCycle: End)
			)
			(1
				(gCSoundFX number: 183 setLoop: 1 play: 127)
				(= ticks 50)
			)
			(2
				(SetFlag 44)
				(gEgo get: 3)
				(proc5_12 3)
				(gGame setCursor: gTheCursor 1 273 64)
				(keyProp dispose:)
				(topTotumPole setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance openBookcase of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 3)
				(proc0_1)
				(gCSoundFX number: 177 setLoop: 1 play: 127)
				(turnKey init: setCycle: End self)
			)
			(1
				(turnKey dispose:)
				(bookCase init:)
				(gCSoundFX number: 125 setLoop: 1 play: 127)
				(glassPanel setCycle: End self)
			)
			(2
				(SetFlag 43)
				(glassPanel dispose:)
			)
		)
	)
)

(instance useMonitor of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 176 setLoop: 1 play: 127)
				(monitor setCycle: End self)
			)
			(1
				(proc0_1)
				(computer doVerb: register)
				(self dispose:)
			)
		)
	)
)

(instance lizardRun of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 5 1 self)
			)
			(1
				(client setCycle: CT 0 1)
				(gCSoundFX number: 229 setLoop: -1 play: 127)
				(lizard
					init:
					cel: 0
					x: 269
					y: 176
					setCycle: Fwd
					setMotion: MoveTo -10 176 self
				)
			)
			(2
				(gCSoundFX stop:)
				(lizard dispose:)
				(self dispose:)
			)
		)
	)
)

(instance agitateMasks of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Fwd)
				(if (== (maskSound loop:) -1)
					(maskSound play: 127)
					(= ticks 90)
				else
					(maskSound play: 127 self)
				)
			)
			(1
				(if (== (maskSound loop:) -1)
					(maskSound stop:)
				)
				(client setCycle: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(self dispose:)
			)
		)
	)
)

(instance birdsMove of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 130 setLoop: 1 play: 127 self)
				(client setCycle: Fwd)
			)
			(1
				(gCSoundFX number: 261 setLoop: 1 play: 127)
				(= ticks 90)
			)
			(2
				(client setCycle: 0 cel: 0)
				(Animate (gCast elements:) 0)
				(gMessager say: 18 4 0 1 self) ; "Now cut that out!"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance peace of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(= ticks 40)
			)
			(2
				(client setCycle: CT 0 1 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance bangMyDrum of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 259 setLoop: 1 play: 127 self)
			)
			(1
				(gCSoundFX number: 128 setLoop: 1 play: 127 self)
			)
			(2
				(gCSoundFX number: 128 setLoop: 1 play: 127 self)
			)
			(3
				(gMessager say: 9 4 0 1 self) ; "Please don't play Dr. Brain's bongos."
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance doorway of Feature
	(properties
		noun 17
		nsTop 51
		nsLeft 114
		nsBottom 127
		nsRight 174
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gCurRoom newRoom: (gCurRoom north:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance birdPerch of Feature
	(properties
		noun 7
		onMeCheck 32
	)
)

(instance spearTire of Feature
	(properties
		noun 11
		onMeCheck 64
	)
)

(instance drBPortrait of Feature
	(properties
		noun 6
		onMeCheck 256
	)
)

(instance bigEyesMask of Feature
	(properties
		noun 4
		nsTop 30
		nsLeft 202
		nsBottom 71
		nsRight 222
		onMeCheck 128
	)
)

(instance bigLipsMask of Feature
	(properties
		noun 4
		nsTop 35
		nsLeft 223
		nsBottom 75
		nsRight 259
		onMeCheck 128
	)
)

(instance blackMask of Feature
	(properties
		noun 4
		nsTop 79
		nsLeft 182
		nsBottom 117
		nsRight 199
		onMeCheck 512
	)
)

(instance boneNoseMask of Feature
	(properties
		noun 4
		nsTop 73
		nsLeft 201
		nsBottom 112
		nsRight 222
		onMeCheck 512
	)
)

(instance skullMask of Feature
	(properties
		noun 4
		nsTop 77
		nsLeft 224
		nsBottom 110
		nsRight 250
		onMeCheck 512
	)
)

(instance bongos of Feature
	(properties
		noun 9
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gCurRoom setScript: bangMyDrum)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance caneChair of Feature
	(properties
		noun 3
		onMeCheck 2
	)
)

(instance computer of Feature
	(properties
		noun 2
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 4) (not (monitor cel:)))
				(monitor setScript: useMonitor 0 theVerb)
			)
			((== theVerb 4)
				(cond
					((< local1 0)
						((ScriptID 283 0) init:) ; hutMasks
						(= local1 global114)
					)
					((!= local1 global114)
						((ScriptID 283 0) dispose: init:) ; hutMasks
						(= local1 global114)
					)
				)
				(switch ((ScriptID 283 0) show:) ; hutMasks
					(1
						((ScriptID 283 0) dispose:) ; hutMasks
						(if (not (IsFlag 44))
							(topTotumPole setScript: giveKey)
						)
						(= local1 -1)
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyboard of Feature
	(properties
		noun 2
		onMeCheck 8
	)
)

(instance shorts of Feature
	(properties
		noun 12
		onMeCheck 4
	)
)

(instance rug of Feature
	(properties
		noun 10
		onMeCheck 16384
	)
)

(instance middleTot of Feature
	(properties
		onMeCheck 4096
	)
)

(instance outsideWindow of Feature
	(properties
		noun 20
		nsTop 41
		nsBottom 92
		nsRight 54
		onMeCheck 128
	)
)

(instance glassPanel of Prop
	(properties
		x 160
		y 129
		noun 19
		view 280
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 30)
				(self setScript: openBookcase)
			)
			((and (== theVerb 4) (gEgo has: 3))
				(self setScript: openBookcase)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigEyes of Prop
	(properties
		x 209
		y 46
		noun 4
		view 280
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(maskSound number: 126 setLoop: -1)
				(self setScript: agitateMasks)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skullTeeth of Prop
	(properties
		x 230
		y 100
		noun 4
		view 280
		loop 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(maskSound number: 241 setLoop: -1)
				(self setScript: agitateMasks)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bigLips of Prop
	(properties
		x 232
		y 68
		noun 4
		view 280
		loop 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(maskSound number: 130 setLoop: -1)
				(self setScript: agitateMasks)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance redEyes of Prop
	(properties
		x 187
		y 91
		noun 4
		view 280
		loop 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(maskSound number: 119 setLoop: 1)
				(self setScript: agitateMasks)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boneNose of Prop
	(properties
		x 210
		y 97
		noun 4
		view 280
		loop 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(maskSound number: 335 setLoop: -1)
				(self setScript: agitateMasks)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance birdsinbush of Prop
	(properties
		x 5
		y 60
		noun 18
		view 280
		loop 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(self setScript: birdsMove)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance topTotumPole of Actor
	(properties
		x 269
		y 39
		noun 8
		onMeCheck 2048
		view 280
		loop 2
		priority 15
		signal 16
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gCSoundFX number: 261 setLoop: 1 play: 127)
				(self setCycle: CT 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance middleTotumPole of Prop
	(properties
		x 261
		y 92
		noun 8
		view 280
		loop 3
	)

	(method (doVerb theVerb)
		(if (not script)
			(switch theVerb
				(4
					(gCSoundFX number: 168 setLoop: 1 play: 127)
					(self setScript: peace)
					(return 1)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance bottomTotumPole of Prop
	(properties
		x 250
		y 144
		noun 8
		onMeCheck 8192
		view 280
		loop 4
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)

	(method (doVerb theVerb)
		(if (not script)
			(switch theVerb
				(4
					(self setScript: lizardRun)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance bookCase of Actor
	(properties
		x 108
		y 47
		noun 5
		view 280
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond
					((< local0 0)
						((ScriptID 285 0) init:) ; bookCase
						(= local0 global114)
					)
					((!= local0 global114)
						((ScriptID 285 0) dispose: init:) ; bookCase
						(= local0 global114)
					)
				)
				(switch ((ScriptID 285 0) show:) ; bookCase
					(1
						((ScriptID 285 0) dispose:) ; bookCase
						(if (not (IsFlag 45))
							(gCurRoom setScript: moveBookcase)
						)
						(= local0 -1)
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance turnKey of Actor
	(properties
		x 117
		y 90
		view 280
		loop 14
		cel 3
		priority 12
		signal 16
	)
)

(instance monitor of Actor
	(properties
		x 50
		y 91
		view 280
		loop 5
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance keyProp of Actor
	(properties
		x 269
		y 39
		view 280
		loop 13
		priority 15
		signal 16400
	)
)

(instance lizard of Actor
	(properties
		x 269
		y 176
		view 280
		loop 12
		priority 1
		signal 2064
		scaleSignal 4
		cycleSpeed 3
		xStep 6
		moveSpeed 1
	)
)

(instance maskSound of Sound
	(properties
		loop -1
	)
)

