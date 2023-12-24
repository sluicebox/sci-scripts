;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 340)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Print)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm340 0
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
	[local3 2]
	local5
	[local6 6] = [83 124 159 206 234 274]
	[local12 6] = [112 122 105 104 92 112]
	[local18 6] = [140 257 150 108 264 145]
)

(procedure (localproc_0 param1 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 0) ((-= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 0)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 param1))
		(Palette palSET_INTENSITY 0 255 temp0)
		(Wait 2)
	)
	(Palette palSET_INTENSITY 0 255 100)
)

(instance rm340 of Rm
	(properties
		noun 1
		picture 340
		north 360
		south 300
	)

	(method (init)
		(LoadMany rsVIEW 340 341 342 346 348 350)
		(column init:)
		(pedestals init:)
		(urn init:)
		(doorway init:)
		(wall init:)
		(floor init:)
		(dali init:)
		(kandinsky init:)
		(pollock init:)
		(okeefe init:)
		(picasso init:)
		(vangogh init:)
		(busts init:)
		(piana init:)
		(gCMusic number: 16 setLoop: -1 play:)
		(super init: &rest)
		(PicNotValid 1)
		(if (not (IsFlag 25))
			(door init:)
		)
		(onOffSwitch init:)
		(artPanel init:)
		((ScriptID 342 0) init: eachElementDo: #show) ; artFrames
		(= local2 gDifficulty)
		(PicNotValid 0)
		(Animate (gCast elements:) 0)
	)

	(method (doit)
		(if (GameIsRestarting)
			((ScriptID 342 0) eachElementDo: #show) ; artFrames
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (IsObject (ScriptID 349 0)) ; art
			((ScriptID 349 0) dispose:) ; art
		)
		((ScriptID 342 0) eachElementDo: #dispose release: dispose:) ; artFrames
		(LoadMany 0 342 349)
		(super dispose: &rest)
	)
)

(instance artPanel of Actor
	(properties
		x 4
		y 122
		noun 6
		sightAngle 0
		view 347
		loop 3
		priority 2
		signal 26640
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (== theVerb 4)
			(if (== local0 -1)
				((ScriptID 349 0) init:) ; art
				(= local0 gDifficulty)
			)
			(cond
				((!= local2 gDifficulty)
					(= local0 gDifficulty)
					(= local2 gDifficulty)
					(Message msgGET 340 23 4 0 1 @temp0) ; "Close your eyes..."
					(Prints @temp0)
					(localproc_0 10)
					(if (!= local0 -1)
						((ScriptID 349 0) dispose:) ; art
					)
					((ScriptID 342 0) eachElementDo: #dispose release: dispose:) ; artFrames
					(gCurRoom drawPic: (gCurRoom picture:))
					((ScriptID 342 0) init: eachElementDo: #show) ; artFrames
					((ScriptID 349 0) init:) ; art
					(Animate (gCast elements:) 0)
					(localproc_1 10)
				)
				((== local0 -1)
					((ScriptID 349 0) init:) ; art
					(local0 global114:)
				)
			)
			(door stopUpd:)
			(Animate (gCast elements:) 0)
			(rm340 setScript: artScript)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance column of Feature
	(properties
		noun 9
		onMeCheck 4
	)
)

(instance pedestals of Feature
	(properties
		noun 21
		onMeCheck 8
	)
)

(instance urn of Feature
	(properties
		noun 4
		onMeCheck 16
	)
)

(instance doorway of Feature
	(properties
		noun 24
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gCurRoom newRoom: (rm340 north:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe)
		(return
			(if (IsFlag 25)
				(super onMe: &rest)
			else
				0
			)
		)
	)
)

(instance wall of Feature
	(properties
		noun 7
		onMeCheck 64
	)
)

(instance floor of Feature
	(properties
		noun 22
		onMeCheck 128
	)
)

(instance dali of Feature
	(properties
		noun 13
		nsTop 149
		nsLeft 102
		nsBottom 152
		nsRight 115
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEBscript 0 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance kandinsky of Feature
	(properties
		noun 13
		nsTop 123
		nsLeft 134
		nsBottom 126
		nsRight 152
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEBscript 0 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pollock of Feature
	(properties
		noun 13
		nsTop 148
		nsLeft 176
		nsBottom 150
		nsRight 187
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEscript 0 2)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance okeefe of Feature
	(properties
		noun 13
		nsTop 108
		nsLeft 216
		nsBottom 118
		nsRight 230
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEBscript 0 3)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance picasso of Feature
	(properties
		noun 13
		nsTop 121
		nsLeft 250
		nsBottom 129
		nsRight 261
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEBscript 0 4)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance vangogh of Feature
	(properties
		noun 13
		nsTop 134
		nsLeft 308
		nsBottom 147
		nsRight 315
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(rm340 setScript: bustEscript 0 5)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance busts of Feature
	(properties
		noun 13
		onMeCheck 31776
	)

	(method (dispose)
		(if actions
			(actions dispose:)
			(= actions 0)
		)
		(gFeatures delete: self)
		(DisposeClone self)
	)
)

(instance onOffSwitch of Prop
	(properties
		x 14
		y 127
		view 346
		loop 14
		priority 1
		signal 18448
	)

	(method (onMe)
		(return 0)
	)
)

(instance door of Actor
	(properties
		y 37
		noun 15
		view 346
		loop 12
		signal 2048
	)

	(method (cue)
		(self dispose:)
	)
)

(instance artScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gCSoundFX number: 182 loop: -1 play:)
				(artPanel setMotion: MoveTo 4 133 self)
			)
			(1
				(onOffSwitch startUpd: setCycle: End)
				(artPanel setMotion: MoveTo 4 166 self)
			)
			(2
				(gCSoundFX stop:)
				(onOffSwitch stopUpd:)
				(HandsOn)
				(Animate (gCast elements:) 0)
				(if (== ((ScriptID 349 0) show:) 1) ; art
					(= local2 -1)
				)
				(HandsOff)
				(gCSoundFX number: 182 loop: -1 play:)
				(artPanel setMotion: MoveTo 4 122 self)
				(onOffSwitch startUpd: setCycle: Beg)
			)
			(3
				(gCSoundFX stop:)
				(onOffSwitch stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bustEBscript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if [local18 register]
					(gCSoundFX number: [local18 register] loop: 1 play:)
				)
				((= local5 (Prop new:))
					view: 348
					loop: register
					cel: 0
					x: [local6 register]
					y: [local12 register]
					setPri: (if (== register 1) 15 else 8)
					init:
					setCycle: End self
				)
			)
			(1
				(= ticks 40)
			)
			(2
				(local5 setCycle: Beg self)
			)
			(3
				(local5 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bustEscript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if [local18 register]
					(gCSoundFX number: [local18 register] loop: 1 play:)
				)
				((= local5 (Prop new:))
					view: 348
					loop: register
					cel: 0
					x: [local6 register]
					y: [local12 register]
					init:
					cel: 0
					setCycle: End self
				)
			)
			(1
				(local5 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance piana of Feature
	(properties
		noun 11
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (IsFlag 36))
			(if (!= local1 gDifficulty)
				(= local1 gDifficulty)
				(= local3 0)
			)
			((ScriptID 350 0) init: @local3) ; music
			(if (== ((ScriptID 350 0) show:) 1) ; music
				(= local3 0)
				(if (gCast contains: door)
					(gCSoundFX number: 189 loop: 1 play:)
					(door cel: 0 setMotion: MoveTo -40 37 door)
				)
			)
			((ScriptID 350 0) dispose:) ; music
			(DisposeScript 350)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

