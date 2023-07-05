;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 180)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Print)
(use Osc)
(use Feature)
(use Ego)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm180 0
)

(local
	[local0 84]
	[local84 21]
	[local105 272]
	[local377 16]
	local393
	local394 = -1
	local395 = -1
	local396 = -1
	local397
	local398 = 3
)

(procedure (localproc_0)
	(fTrail init:)
	(fMinnow init:)
	(fUmb init:)
	(fShell init:)
	(fLagoon init:)
	(fBigTree init:)
	(fWaterFall init:)
	(fLifeSaver init:)
	(fFrontBird init:)
	(fSurfBoard init:)
	(fStarF init:)
	(fPoolToy init:)
	(fbackBird init:)
	(fDivingBoard init:)
	(fChest init:)
	(fShipBottle init:)
	(fWheel init:)
	(fGlass init:)
	(fOgle init:)
	(fBirdPuz init:)
	(nutTree init:)
)

(instance rm180 of Rm
	(properties
		noun 6
		picture 180
		north 200
		south 160
	)

	(method (init)
		(gCMusic number: 8 setLoop: -1 play:)
		(if (IsFlag 52)
			(localproc_0)
			(if [global135 17]
				(sine init: cue:)
			)
			(if [global135 4]
				(nutTree cel: 14)
			)
		else
			(= picture 195)
			(self setScript: showJigsaw)
		)
		(super init:)
	)

	(method (doit)
		(Palette palANIMATE 221 228 -9)
		(super doit:)
	)

	(method (dispose)
		(if (moreMusic owner:)
			(moreMusic dispose:)
		)
		(if (IsObject (ScriptID 195 0)) ; jigsaw
			((ScriptID 195 0) dispose:) ; jigsaw
		)
		(DisposeScript 195)
		(super dispose: &rest)
		(DisposeScript 939)
	)
)

(instance showJigsaw of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				((ScriptID 195 0) init:) ; jigsaw
				(if ((ScriptID 195 0) show:) ; jigsaw
					((ScriptID 195 0) dispose:) ; jigsaw
					(DrawPic (gCurRoom picture:) 9 1)
					(gCurRoom curPic: (gCurRoom picture:))
					(localproc_0)
					(self dispose:)
				else
					(gCurRoom newRoom: (gCurRoom south:))
				)
			)
		)
	)
)

(instance goAWhile of Script
	(properties
		register 2
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 init: setCycle: Fwd)
				(= seconds register)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance goOnce of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 init: setCycle: End self)
			)
			(1
				(client addToPic:)
			)
		)
	)
)

(instance fBirdPuz of Feature
	(properties
		noun 1
		onMeCheck 4096
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 4)
			(= temp0 [global135 17])
			(moreMusic owner: self play:)
			((ScriptID 185) init: show: dispose:) ; flamingos
			(DisposeScript 185)
			(if (and (not temp0) [global135 17])
				(note setScript: getIt)
			)
			(moreMusic fade:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sine of Actor
	(properties
		x 21
		y 80
		noun 16
		view 180
		loop 3
		priority 3
		signal 22544
	)

	(method (cue)
		(= y 64)
		(|= signal $0100)
		(self stopUpd:)
		(proc5_2)
	)

	(method (doVerb theVerb &tmp temp0 temp1)
		(if (== theVerb 4)
			(= temp1 [global135 4])
			(if
				(or
					(== local394 -1)
					(!= global114 local395)
					(Print
						addButton: 0 {Same old puzzle}
						addButton: 3 {Generate a new one} 85 0
						init:
					)
				)
				(= local393 0)
				(for ((= temp0 0)) (< temp0 16) ((++ temp0))
					(= [local377 temp0] 0)
				)
				(= local394 -1)
				((ScriptID 191) doit: @local105 @local0 @local84 @local394) ; word
				(DisposeScript 191)
				(if (== local394 -1)
					(return)
				)
				(= local395 global114)
			)
			((ScriptID 190) ; word
				init: @local105 @local0 @local84 @local377 @local393 @local394
				show:
				dispose:
			)
			(DisposeScript 190)
			(if (and (not temp1) [global135 4])
				(nutTree
					signal: (& $feff (nutTree signal:))
					startUpd:
					setCycle: End nutTree
				)
				(gCSoundFX number: 335 loop: 1 play: nutTree)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fTrail of Feature
	(properties
		noun 17
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) [global135 4])
			(gCurRoom newRoom: (gCurRoom north:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance nutTree of Prop
	(properties
		x 33
		y 58
		noun 13
		view 180
		loop 2
		signal 20737
		cycleSpeed 9
	)

	(method (cue)
		(if cycler
			(gCSoundFX number: 336 play:)
		else
			(nutTree signal: (| $0100 (nutTree signal:)) stopUpd:)
			(= noun 10)
			(gMessager say: 6 4 14) ; "Now that the coconut trees no longer block the path, click on the trail to move on."
		)
	)
)

(instance fMinnow of Feature
	(properties
		noun 9
		onMeCheck 512
	)
)

(instance fUmb of Feature
	(properties
		noun 4
		onMeCheck 16384
	)
)

(instance fShell of Feature
	(properties
		noun 22
		onMeCheck -32768
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gCSoundFX number: 258 loop: 1 play:)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance fLagoon of Feature
	(properties
		noun 15
		onMeCheck 8192
	)
)

(instance fBigTree of Feature
	(properties
		noun 8
		nsLeft 160
		nsBottom 189
		nsRight 319
		onMeCheck 128
	)
)

(instance fLifeSaver of Feature
	(properties
		noun 14
		onMeCheck 8
	)
)

(instance fbackBird of Feature
	(properties
		noun 1
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(wings cel: 0 init: setCycle: Osc 1 wings)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance wings of Prop
	(properties
		x 141
		y 64
		view 189
		loop 1
		cycleSpeed 10
	)

	(method (cue)
		(self dispose:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance fFrontBird of Feature
	(properties
		noun 1
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (not (note script:)) (not (Ego has: 4)))
			(note setScript: dontGetIt)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance note of Prop
	(properties
		x 146
		y 102
		view 189
	)

	(method (onMe)
		(return 0)
	)
)

(instance getIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(note init: setCycle: End self)
			)
			(1
				(= ticks 75)
			)
			(2
				(gMessager say: 1 4 17 0 self) ; "For solving the neon flamingo puzzle, one of the flamingoes graciously rewards you with a bottle. Opening the bottle, you discover it contains sheet music!"
			)
			(3
				(Ego get: 4)
				(sine init: setMotion: MoveTo 21 64 sine)
				(note dispose:)
			)
		)
	)
)

(instance dontGetIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(note init: setCycle: CT 2 1 self)
			)
			(1
				(= ticks 25)
			)
			(2
				(note init: setCycle: Beg self)
			)
			(3
				(proc5_2)
				(note dispose:)
			)
		)
	)
)

(instance fSurfBoard of Feature
	(properties
		noun 20
		nsTop 71
		nsLeft 280
		nsBottom 120
		nsRight 315
		onMeCheck 2
	)
)

(instance fStarF of Feature
	(properties
		noun 3
		nsTop 173
		nsLeft 146
		nsBottom 189
		nsRight 179
		onMeCheck 2
	)
)

(instance fDivingBoard of Feature
	(properties
		noun 12
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(jumper cel: 0 init: setCycle: Osc 3 jumper)
			(Load rsSOUND (+ 129 (if (<= (DoSound sndGET_POLYPHONY) 11) 1000 else 0)))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance jumper of Prop
	(properties
		x 200
		y 56
		view 189
		loop 5
		cycleSpeed 5
	)

	(method (cue)
		(self dispose:)
	)

	(method (doit)
		(if (and (!= local397 cel) (== cel 2))
			(gCSoundFX number: 129 loop: 1 play:)
		)
		(= local397 cel)
		(super doit:)
	)

	(method (onMe)
		(return 0)
	)
)

(instance fChest of Feature
	(properties
		noun 7
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond
					((< local396 0)
						((ScriptID 195 0) init:) ; jigsaw
						(= local396 global114)
					)
					((!= local396 global114)
						((ScriptID 195 0) dispose: init:) ; jigsaw
						(= local396 global114)
					)
				)
				(switch ((ScriptID 195 0) show:) ; jigsaw
					(1
						((ScriptID 195 0) dispose:) ; jigsaw
						(= local396 -1)
					)
					(0 0)
				)
				(DrawPic (gCurRoom picture:) 9 1)
				(gCurRoom curPic: (gCurRoom picture:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fPoolToy of Feature
	(properties
		noun 18
		nsTop 128
		nsLeft 61
		nsBottom 169
		nsRight 117
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(someEyes setScript: (goAWhile new:) 0 2)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance someEyes of Prop
	(properties
		x 101
		y 134
		view 189
		loop 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance fShipBottle of Prop
	(properties
		x 54
		y 159
		noun 5
		onMeCheck 64
		view 189
		loop 7
		signal 16385
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (not cel))
			(self startUpd: setScript: (goOnce new:))
			(gFeatures add: self)
		else
			(super doVerb: theVerb &rest)
		)
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
)

(instance fWaterFall of Feature
	(properties
		noun 11
		nsLeft 123
		nsBottom 58
		nsRight 160
		onMeCheck 8
	)
)

(instance fWheel of Feature
	(properties
		noun 19
		onMeCheck 128
	)
)

(instance fGlass of Feature
	(properties
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (not (drink cel:)))
			(drink setScript: (goOnce new:))
		else
			(gCurRoom doVerb: theVerb &rest)
		)
	)
)

(instance drink of Prop
	(properties
		x 54
		y 85
		view 189
		loop 6
		signal 16384
	)

	(method (onMe)
		(return 0)
	)
)

(instance fOgle of Feature
	(properties
		noun 1
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (not (inLove cel:)))
			(inLove init: setCycle: End inLove)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance inLove of Prop
	(properties
		x 65
		y 94
		view 189
		loop 2
	)

	(method (cue)
		(if cel
			(love setScript: (goAWhile new:) love 3)
			(Load rsSOUND (+ 130 (if (<= (DoSound sndGET_POLYPHONY) 11) 1000 else 0)))
		else
			(self dispose:)
		)
	)

	(method (onMe)
		(return 0)
	)
)

(instance love of Prop
	(properties
		x 101
		y 106
		view 189
		loop 3
	)

	(method (doit)
		(if (and (!= local398 cel) (== cel 0))
			(gCSoundFX number: 130 loop: 1 play:)
		)
		(= local398 cel)
		(super doit:)
	)

	(method (cue)
		(inLove setCycle: Beg inLove)
	)

	(method (onMe)
		(return 0)
	)
)

(instance moreMusic of Sound
	(properties
		flags 1
		number 7
		loop -1
	)

	(method (play)
		(if (<= (DoSound sndGET_POLYPHONY) 11)
			(= number (+ (mod number 1000) 1000))
		)
		(super play: &rest)
	)
)

