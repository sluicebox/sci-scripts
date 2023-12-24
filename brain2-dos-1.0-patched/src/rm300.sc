;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Window)
(use Motion)
(use Game)
(use Actor)

(public
	rm300 0
)

(local
	local0 = -1
	local1 = -1
	[local2 3]
	[local5 3]
	[local8 3] = [45 46 46]
	[local11 11] = [109 120 131 223 205 218 206 35 60 67 33]
	[local22 8] = [20 89 204 277 54 246 144 276]
	[local30 8] = [15 15 15 15 75 75 144 144]
	[local38 8] = [{Grandparent} {GrandParent} {Grandparent} {GrandParent} {parent} {parent} {child} {ideal}]
	[local46 8] = [{BBAAEEmmll} {bbAAEEMMll} {BBaaEEmmLL} {BBAAEEMMLL} {BbAAEEmMll} {BBaAEEmMLL} {BBA|c2|a|c|EEM|c2|M|c|lL} {BBAAEEMmlL}]
	[local54 8] = [7 14 21 31 15 31 31 31]
)

(procedure (localproc_0 param1)
	(if (< param1 0)
		(while param1
			(if (< (-- [global184 0]) 0)
				(= [global184 0] 0)
			)
			(if (< (-- [global184 1]) 0)
				(= [global184 1] 0)
			)
			(if (< (-- [global184 2]) 0)
				(= [global184 2] 0)
			)
			(++ param1)
		)
	else
		(while param1
			(++ [global184 0])
			(++ [global184 1])
			(++ [global184 2])
			(-- param1)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4)
	(DrawCel
		305
		0
		[global201 (+ 0 (& param1 $0001))]
		(+ param2 13)
		(+ param3 7)
		param4
	)
	(DrawCel
		305
		1
		[global201 (+ 2 (& (>>= param1 $0001) $0001))]
		(+ param2 1)
		(+ param3 10)
		param4
	)
	(DrawCel
		305
		2
		[global201 (+ 4 (& (>>= param1 $0001) $0001))]
		(+ param2 8)
		(+ param3 0)
		param4
	)
	(DrawCel
		305
		3
		[global201 (+ 6 (& (>>= param1 $0001) $0001))]
		(+ param2 15)
		(+ param3 11)
		param4
	)
	(DrawCel
		305
		4
		[global201 (+ 8 (& (>>= param1 $0001) $0001))]
		(+ param2 8)
		(+ param3 33)
		param4
	)
)

(procedure (localproc_2 &tmp temp0)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(= [global201 temp0] (Random 0 9))
		(++ temp0)
		(while (== [global201 (- temp0 1)] (= [global201 temp0] (Random 0 9)))
		)
	)
)

(instance rm300 of Rm
	(properties
		noun 1
		picture 300
		north 340
		south 290
	)

	(method (init &tmp temp0)
		(LoadMany rsVIEW 300 301 304 320 321)
		(Load rsPIC 320)
		(gCMusic number: 15 setLoop: -1 play:)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(gFeatures
				add:
					((tail new:)
						x: (Random 64 107)
						y: (Random 0 31)
						ignoreActors: 1
						init:
						yourself:
					)
			)
		)
		(teapot init:)
		(familyTree init:)
		(mainFrame init:)
		(donkey init:)
		(paper init:)
		(bookshelf init:)
		(lifesaver init:)
		(lifesaverHole init:)
		(miniComputer init:)
		(geneInfoHole init:)
		(backWall init:)
		(doorway init:)
		(glassCages init:)
		(floor init:)
		(clock init:)
		(parentChambers init:)
		(childPlatform init:)
		(donut init:)
		(geneticsConsole init:)
		(geneticsComputer init:)
		(spoon init:)
		(cartBox init:)
		(cup init:)
		(cartSlot init:)
		(robotHead init:)
		(robotBack init:)
		(goldFish init:)
		(fishTube init:)
		(book init:)
		(balls init:)
		(noiseSignals init:)
		(ziggs init:)
		(coffeeDrip init:)
		(theKey init:)
		(lilZap init:)
		(glowBalls init:)
		(light init:)
		(door init:)
		(screen init:)
		(cart0 init:)
		(cart1 init:)
		(cart2 init:)
		(elevator init:)
		(super init:)
		(PicNotValid 1)
		(= global187 0)
		(if (not (IsFlag 19))
			(localproc_2)
		else
			(geneticsConsole sightAngle: 1)
			(smallLights init: setCycle: Fwd)
			(arrow init: setCycle: Fwd)
			(dots init: setCycle: Fwd)
			(dotettes init: setCycle: Fwd)
			(screen lastCel:)
			(geneticMaterial init: cel: 0 posn: 271 176)
		)
		(PicNotValid 0)
		(Animate (gCast elements:) 1)
		(= [local2 0] cart0)
		(= [local5 0] 12)
		(= [local2 1] cart1)
		(= [local5 1] 13)
		(= [local2 2] cart2)
		(= [local5 2] 14)
		(if (not (and (IsFlag 9) (IsFlag 19)))
			(self setScript: roomIntro)
		)
	)

	(method (dispose)
		(if (IsObject (ScriptID 320 0)) ; programmer
			((ScriptID 320 0) dispose:) ; programmer
		)
		(if (IsObject (ScriptID 320 1)) ; maze
			((ScriptID 320 1) dispose:) ; maze
		)
		(DisposeScript 320)
		(DisposeScript 969)
		(if (IsObject (ScriptID 310 0)) ; genetics
			((ScriptID 310 0) dispose:) ; genetics
		)
		(DisposeScript 310)
		(DisposeScript 956)
		(gEgo put: 12)
		(gEgo put: 13)
		(gEgo put: 14)
		(super dispose: &rest)
	)
)

(instance noiseSignals of Prop
	(properties
		x 98
		y 70
		view 300
		loop 5
		cel 9
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance ziggs of Prop
	(properties
		x 143
		y 67
		view 300
		loop 6
		cel 9
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance coffeeDrip of Prop
	(properties
		x 151
		y 105
		view 300
		loop 1
		cel 9
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance theKey of Prop
	(properties
		x 64
		y 88
		view 300
		loop 2
		cel 1
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance lilZap of Prop
	(properties
		x 22
		y 21
		view 300
		loop 3
		cel 4
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance glowBalls of Prop
	(properties
		y 25
		view 300
		loop 4
		cel 5
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance light of Prop
	(properties
		x 165
		y 61
		view 300
		loop 7
	)

	(method (init)
		(self startUpd: setCycle: Fwd self)
		(super init: &rest)
	)

	(method (onMe)
		(return 0)
	)
)

(instance fish of Prop
	(properties
		x 7
		y 153
		view 300
	)

	(method (onMe)
		(return 0)
	)

	(method (cue)
		(self dispose:)
		(super cue: &rest)
	)
)

(instance door of Prop
	(properties
		x 198
		y 26
		noun 8
		sightAngle 0
		view 301
		priority 2
		signal 16
	)

	(method (init)
		(if (and (IsFlag 9) (IsFlag 19))
			(= sightAngle 1)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 45) (and (== theVerb 4) (gEgo has: 15)))
			(self setScript: doorOpenClose)
			(return)
		)
		(if (and (== theVerb 4) sightAngle)
			(self setScript: doorOpenClose)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance doorKey of Prop
	(properties
		x 174
		y 42
		view 300
		loop 15
		priority 15
		signal 16
	)
)

(instance elevator of Actor
	(properties
		x 183
		y -6
		noun 53
		sightAngle 0
		view 301
		loop 8
		priority 1
		signal 26640
	)

	(method (init)
		(if (and (IsFlag 9) (IsFlag 19))
			(= sightAngle 1)
			(= y 24)
			(super init: &rest)
		else
			(super init: &rest)
			(self hide:)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(gCurRoom newRoom: (rm300 north:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance screen of Prop
	(properties
		x 173
		y 136
		view 300
		loop 9
	)

	(method (onMe)
		(return 0)
	)
)

(instance smallLights of Prop
	(properties
		x 198
		y 133
		view 300
		loop 8
	)

	(method (onMe)
		(return 0)
	)
)

(instance arrow of Prop
	(properties
		x 202
		y 165
		view 300
		loop 10
		cel 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance dots of Prop
	(properties
		x 194
		y 161
		view 300
		loop 11
		cel 2
	)

	(method (onMe)
		(return 0)
	)
)

(instance dotettes of Prop
	(properties
		x 195
		y 159
		view 300
		loop 12
		cel 4
	)

	(method (onMe)
		(return 0)
	)
)

(instance cartSmoke of Prop
	(properties
		x 91
		y 73
		view 300
		loop 14
	)

	(method (onMe)
		(return 0)
	)

	(method (cue)
		(self dispose:)
		(super cue: &rest)
	)
)

(instance geneticMaterial of Actor
	(properties
		x 271
		y 152
		noun 52
		view 301
		loop 6
		priority 1
		signal 2064
	)
)

(instance geneZaps of Prop
	(properties
		x 231
		y 27
		view 300
		loop 13
	)
)

(instance cart0 of Prop
	(properties
		x 45
		y 109
		noun 49
		view 301
		loop 2
		maxScale 0
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4)
				(if maxScale
					(self setScript: cartOut 0 0)
				else
					(gCSoundFX number: 242 loop: 1 play:)
					(gEgo get: 12)
					(proc5_12 12)
					(gGame setCursor: gTheCursor 1 45 109)
					(self hide:)
				)
			)
			((and (== theVerb 43) maxScale)
				(gEgo get: 12)
				(self hide:)
				(cart1 setScript: cartIn 0 1)
			)
			((and (== theVerb 44) maxScale)
				(gEgo get: 12)
				(self hide:)
				(cart2 setScript: cartIn 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cart1 of Prop
	(properties
		x 46
		y 120
		noun 47
		view 301
		loop 2
		cel 1
		maxScale 0
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4)
				(if maxScale
					(self setScript: cartOut 0 1)
				else
					(gCSoundFX number: 242 loop: 1 play:)
					(gEgo get: 13)
					(proc5_12 13)
					(gGame setCursor: gTheCursor 1 46 120)
					(self hide:)
				)
			)
			((and (== theVerb 42) maxScale)
				(gEgo get: 13)
				(self hide:)
				(cart0 setScript: cartIn 0 0)
			)
			((and (== theVerb 44) maxScale)
				(gEgo get: 13)
				(self hide:)
				(cart2 setScript: cartIn 0 2)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cart2 of Prop
	(properties
		x 46
		y 131
		noun 48
		view 301
		loop 2
		cel 2
		maxScale 0
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4)
				(if maxScale
					(self setScript: cartOut 0 2)
				else
					(gCSoundFX number: 242 loop: 1 play:)
					(gEgo get: 14)
					(proc5_12 14)
					(gGame setCursor: gTheCursor 1 46 131)
					(self hide:)
				)
			)
			((and (== theVerb 42) maxScale)
				(gEgo get: 14)
				(self hide:)
				(cart0 setScript: cartIn 0 0)
			)
			((and (== theVerb 43) maxScale)
				(gEgo get: 14)
				(self hide:)
				(cart1 setScript: cartIn 0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance teapot of Feature
	(properties
		noun 29
		nsTop 89
		nsLeft 154
		nsBottom 108
		nsRight 186
		onMeCheck 2048
	)
)

(instance familyTree of Feature
	(properties
		noun 3
		nsBottom 190
		nsRight 167
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(tree init: show: dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mainFrame of Feature
	(properties
		noun 38
		nsBottom 190
		nsRight 167
		onMeCheck 16384
	)
)

(instance donkey of Feature
	(properties
		noun 54
		nsBottom 190
		nsRight 167
		onMeCheck 64
	)
)

(instance paper of Feature
	(properties
		noun 26
		nsTop 80
		nsLeft 141
		nsBottom 103
		nsRight 160
		onMeCheck 8192
	)
)

(instance bookshelf of Feature
	(properties
		noun 22
		nsBottom 190
		nsRight 167
		onMeCheck 8192
	)
)

(instance lifesaver of Feature
	(properties
		noun 18
		nsBottom 190
		nsRight 167
		onMeCheck 8
	)
)

(instance lifesaverHole of Feature
	(properties
		noun 45
		nsBottom 190
		nsRight 167
		onMeCheck 2
	)
)

(instance miniComputer of Feature
	(properties
		noun 23
		nsBottom 190
		nsRight 167
		onMeCheck -32768
	)
)

(instance geneInfoHole of Feature
	(properties
		noun 44
		nsTop 174
		nsLeft 269
		nsBottom 184
		nsRight 287
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if
			(and
				(or (== theVerb 4) (== theVerb 36))
				(IsFlag 9)
				(not (geneticsConsole sightAngle:))
			)
			(geneticMaterial setScript: geneIn)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance backWall of Feature
	(properties
		noun 24
		onMeCheck 4096
	)
)

(instance doorway of Feature
	(properties
		noun 40
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 4
	)
)

(instance glassCages of Feature
	(properties
		noun 9
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 128
	)
)

(instance floor of Feature
	(properties
		noun 27
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck -32768
	)
)

(instance clock of Feature
	(properties
		noun 25
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 64
	)
)

(instance parentChambers of Feature
	(properties
		noun 10
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 256
	)
)

(instance childPlatform of Feature
	(properties
		noun 11
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 32
	)
)

(instance donut of Feature
	(properties
		noun 7
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 8
	)
)

(instance geneticsComputer of Feature
	(properties
		noun 46
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 16
	)
)

(instance geneticsConsole of Feature
	(properties
		noun 4
		nsLeft 167
		nsBottom 190
		nsRight 320
		sightAngle 0
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (or (== theVerb 4) (== theVerb 36)) (IsFlag 9))
			(if (not sightAngle)
				(geneticMaterial setScript: geneIn)
				(while (or (geneticMaterial script:) (screen cycler:))
					(gGame doit:)
				)
			)
			(if (!= local0 -1)
				((ScriptID 320 0) dispose:) ; programmer
				((ScriptID 320 1) dispose:) ; maze
				(= local0 -1)
			)
			(cond
				((< local1 0)
					((ScriptID 310 0) init:) ; genetics
					(localproc_2)
					(= local1 gDifficulty)
				)
				((!= local1 gDifficulty)
					((ScriptID 310 0) dispose: init:) ; genetics
					(localproc_2)
					(= local1 gDifficulty)
				)
			)
			(switch ((ScriptID 310 0) show:) ; genetics
				(1
					((ScriptID 310 0) dispose:) ; genetics
					(= local1 -1)
					(rm300 setScript: geneWin)
				)
				(0 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance spoon of Feature
	(properties
		noun 31
		nsLeft 167
		nsBottom 190
		nsRight 320
		onMeCheck 1024
	)
)

(instance cartBox of Feature
	(properties
		noun 51
		nsTop 103
		nsLeft 19
		nsBottom 151
		nsRight 58
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42
				(gCSoundFX number: 145 loop: 1 play:)
				(cart0
					maxScale: 0
					x: [local8 0]
					y: [local11 0]
					loop: 2
					cel: 0
					show:
				)
				(gEgo put: 12)
				(proc0_1)
			)
			(43
				(gCSoundFX number: 145 loop: 1 play:)
				(cart1
					maxScale: 0
					x: [local8 1]
					y: [local11 1]
					loop: 2
					cel: 1
					show:
				)
				(gEgo put: 13)
				(proc0_1)
			)
			(44
				(gCSoundFX number: 145 loop: 1 play:)
				(cart2
					maxScale: 0
					x: [local8 2]
					y: [local11 2]
					loop: 2
					cel: 2
					show:
				)
				(gEgo put: 14)
				(proc0_1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cup of Feature
	(properties
		noun 6
		nsBottom 190
		nsRight 167
		onMeCheck 512
	)
)

(instance cartSlot of Feature
	(properties
		noun 56
		nsTop 96
		nsLeft 97
		nsBottom 102
		nsRight 127
		sightAngle 255
	)

	(method (doVerb theVerb)
		(if (== sightAngle 255)
			(switch theVerb
				(42
					(cart0 setScript: cartIn 0 0)
				)
				(43
					(cart1 setScript: cartIn 0 1)
				)
				(44
					(cart2 setScript: cartIn 0 2)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance robotHead of Feature
	(properties
		noun 50
		nsBottom 190
		nsRight 167
		onMeCheck 256
	)
)

(instance robotBack of Feature
	(properties
		y 103
		noun 2
		nsBottom 190
		nsRight 167
		onMeCheck 1024
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4
				(if (== (cartSlot sightAngle:) 255)
					(gCSoundFX number: 135 setLoop: 0 play:)
					(gMessager say: 55 47) ; "ERROR: Insert cartridge to operate."
					(return)
				)
				(if (!= local1 -1)
					((ScriptID 310 0) dispose:) ; genetics
					(= local1 -1)
				)
				(cond
					((< local0 0)
						((ScriptID 320 0) init:) ; programmer
						((ScriptID 320 1) init:) ; maze
						(= local0 gDifficulty)
						(= [global184 0] (- 3 gDifficulty))
						(= [global184 1] (- 3 gDifficulty))
						(= [global184 2] (- 3 gDifficulty))
					)
					((!= local0 gDifficulty)
						((ScriptID 320 0) dispose: init:) ; programmer
						((ScriptID 320 1) dispose: init:) ; maze
						(localproc_0 (- local0 gDifficulty))
						(= local0 gDifficulty)
						(if (not [global184 (cartSlot sightAngle:)])
							(gCSoundFX number: 257 loop: 1 play:)
							(cartSmoke
								init:
								cel: 0
								setCycle: ForwardCounter 3 cartSmoke
							)
							(return)
						)
					)
					((not [global184 (cartSlot sightAngle:)])
						(gCSoundFX number: 135 setLoop: 0 play:)
						(Say 0 55 48 0 1) ; "ERROR: Cartridge burned out."
						(return)
					)
				)
				(while
					(==
						(= temp0
							((ScriptID 320 0) show: (cartSlot sightAngle:)) ; programmer
						)
						1
					)
					(Animate (gCast elements:) 0)
					(if (== ((ScriptID 320 1) show:) 1) ; maze
						(= temp0 2)
						(break)
					)
					(Animate (gCast elements:) 0)
					(if (not [global184 (cartSlot sightAngle:)])
						(gCSoundFX number: 257 loop: 1 play:)
						(cartSmoke
							init:
							cel: 0
							setCycle: ForwardCounter 3 cartSmoke
						)
						(return)
					)
				)
				(if (== temp0 2)
					((ScriptID 320 1) dispose:) ; maze
					((ScriptID 320 0) dispose:) ; programmer
					(= local0 -1)
					(Animate (gCast elements:) 0)
					(cond
						((not (geneticsConsole sightAngle:))
							(proc5_12 9)
							(gGame setCursor: gTheCursor 1 97 110)
						)
						((not (door sightAngle:))
							(proc5_12 15)
							(gGame setCursor: gTheCursor 1 97 110)
						)
					)
					(if (and (not (elevator sightAngle:)) (IsFlag 19))
						(elevator setScript: elevatorArrive)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goldFish of Feature
	(properties
		noun 5
		nsBottom 190
		nsRight 167
		onMeCheck 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (fish cycler:))
					(gCSoundFX number: 164 loop: 1 play:)
					(fish init: cel: 0 setCycle: End fish)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fishTube of Feature
	(properties
		noun 39
		nsBottom 190
		nsRight 167
		onMeCheck 32
	)
)

(instance book of Feature
	(properties
		noun 32
		nsBottom 190
		nsRight 167
		onMeCheck 4
	)
)

(instance balls of Feature
	(properties
		noun 28
		nsBottom 190
		nsRight 167
		onMeCheck 16
	)
)

(instance cartIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cartSlot sightAngle: register)
				(gCSoundFX number: 115 loop: 1 play:)
				([local2 register]
					maxScale: 1
					loop: (+ 3 register)
					cel: 0
					x: 97
					y: 96
					show:
					setCycle: End self
				)
			)
			(1
				(gEgo put: [local5 register])
				(proc0_1)
				(robotBack doVerb: 4)
				(self dispose:)
			)
		)
	)
)

(instance cartOut of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cartSlot sightAngle: 255)
				(gCSoundFX number: 115 loop: 1 play:)
				([local2 register] setCycle: Beg self)
			)
			(1
				(gEgo get: [local5 register])
				(proc5_12 [local5 register])
				(gGame setCursor: gTheCursor 1 97 96)
				([local2 register] hide:)
				(self dispose:)
			)
		)
	)
)

(instance geneIn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 150 loop: 1 play:)
				(geneticMaterial init: cel: 0 setMotion: MoveTo 271 176 self)
			)
			(1
				(proc0_1)
				(gEgo put: 9)
				(gCSoundFX number: 176 loop: 1 play:)
				(smallLights init: setCycle: Fwd)
				(arrow init: setCycle: Fwd)
				(dots init: setCycle: Fwd)
				(dotettes init: setCycle: Fwd)
				(screen setCycle: End)
				(geneticsConsole sightAngle: 1)
				(self dispose:)
			)
		)
	)
)

(instance geneWin of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gCSoundFX number: 260 loop: 1 play: self)
				(Animate (gCast elements:) 0)
				(PicNotValid 1)
				(DrawPic 300 9 1)
				(localproc_1 global188 228 60 -1)
				(localproc_1 global189 280 62 -1)
				(PicNotValid 0)
				(Animate (gCast elements:) 0)
			)
			(1
				(gCSoundFX number: 195 loop: -1 play:)
				(geneZaps init: cel: 0 setCycle: ForwardCounter 2 self)
			)
			(2
				(geneZaps dispose:)
				(gCSoundFX number: 262 loop: 1 play: self)
				(PicNotValid 1)
				(DrawPic 300 9 1)
				(localproc_1 global188 228 60 -1)
				(localproc_1 global189 280 62 -1)
				(localproc_1 global200 260 90 -1)
				(PicNotValid 0)
			)
			(3
				(if (and (not (elevator sightAngle:)) (IsFlag 9))
					(elevator setScript: elevatorArrive)
				)
				(self dispose:)
			)
		)
	)
)

(instance elevatorArrive of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 127 loop: 1 play:)
				(elevator show: setMotion: MoveTo 184 24 self)
			)
			(1
				(gCSoundFX number: 149 loop: 1 play: self)
			)
			(2
				(gCSoundFX number: 135 loop: 1 play:)
				(if (and (not (door sightAngle:)) (gEgo has: 15))
					(proc5_12 15)
					(gGame setCursor: gTheCursor 1 97 110)
				)
				(elevator sightAngle: 1)
				(self dispose:)
			)
		)
	)
)

(instance doorOpenClose of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (door sightAngle:))
					(gCSoundFX number: 124 loop: 1 play:)
					(doorKey init: setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (not (door sightAngle:))
					(doorKey dispose:)
				)
				(gCSoundFX number: 182 loop: 1 play:)
				(if (not (door cel:))
					(door setCycle: End self)
				else
					(door setCycle: Beg self)
				)
			)
			(2
				(gCSoundFX stop:)
				(if (not (door sightAngle:))
					(door sightAngle: 1)
					(gEgo put: 15)
					(proc0_1)
				)
				(self dispose:)
			)
		)
	)
)

(instance roomIntro of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 8 9 0 1 self 20) ; "I can wait no longer. Remember: I'm counting on you! Please bring it soon."
			)
			(1
				(gCSoundFX number: 233 loop: 1 play:)
				(ShakeScreen 20 ssLEFTRIGHT)
				(gMessager say: 17 9 0 0 self) ; "Whoa. This place almost came apart! You better get off this island quickly."
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance treeWin of SysWindow
	(properties
		bottom 189
		right 319
		back 45
		priority -1
	)
)

(instance tree of PuzzleBar
	(properties
		noun 3
	)

	(method (dispatchEvent event)
		(if (& (event type:) $0105) ; evJOYDOWN | evMOUSEKEYBOARD
			(self goAway:)
			(self dispose:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (init &tmp temp0)
		(= msgModule gCurRoomNum)
		(= window treeWin)
		(for ((= temp0 0)) (< temp0 8) ((++ temp0))
			(self
				add:
					((geneDude new:)
						nsLeft: [local22 temp0]
						nsTop: [local30 temp0]
						value: temp0
						yourself:
					)
			)
		)
		(self add: (dudeViewer value: -1 cursor: -2))
	)

	(method (show)
		(= shown 0)
		(super show: &rest)
	)
)

(instance geneDude of CodeIcon
	(properties
		view 304
		loop 4
	)

	(method (show &tmp temp0)
		(super show: &rest)
		(DrawCel 304 8 3 (- nsLeft 18) (+ nsTop 30) -1)
		(Display
			[local38 value]
			dsCOORD
			(- nsLeft (/ (- (* (StrLen [local38 value]) 5) 23) 2))
			(- nsTop 8)
			dsCOLOR
			11
			dsALIGN
			alLEFT
			dsFONT
			999
			&rest
		)
		(Display
			[local46 value]
			dsCOORD
			(- nsLeft 15)
			(+ nsTop 33)
			dsCOLOR
			12
			dsALIGN
			alLEFT
			dsFONT
			999
			&rest
		)
		(= temp0 [local54 value])
		(DrawCel
			305
			5
			[global201 (+ 0 (& temp0 $0001))]
			(+ nsLeft 6)
			(+ nsTop 4)
			-1
		)
		(DrawCel
			305
			6
			[global201 (+ 2 (& (>>= temp0 $0001) $0001))]
			(+ nsLeft 1)
			(+ nsTop 5)
			-1
		)
		(DrawCel
			305
			7
			[global201 (+ 4 (& (>>= temp0 $0001) $0001))]
			(+ nsLeft 6)
			(+ nsTop 2)
			-1
		)
		(DrawCel
			305
			8
			[global201 (+ 6 (& (>>= temp0 $0001) $0001))]
			(+ nsLeft 7)
			(+ nsTop 4)
			-1
		)
		(DrawCel
			305
			9
			[global201 (+ 8 (& (>>= temp0 $0001) $0001))]
			(+ nsLeft 3)
			(+ nsTop 11)
			-1
		)
	)

	(method (highlight param1)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super highlight: param1 &rest)
		(dudeViewer value: value show:)
		(if param1
			((Print new:)
				modeless: 1
				x: 1
				y: 1
				width: 300
				addText: 30 1 0 (+ value 1)
				init:
			)
		)
	)
)

(instance dudeViewer of CodeIcon
	(properties
		view 304
		loop 11
		cel 0
		nsLeft 8
		nsTop 120
		cursor 0
	)

	(method (show &tmp temp0)
		(if (!= value cursor)
			(DrawCel view loop cel nsLeft nsTop -1)
			(DrawCel view 8 3 (- nsLeft 5) (+ nsTop 55) -1)
			(Graph grDRAW_LINE 120 8 120 53 1 73 -1 -1)
			(Graph grUPDATE_BOX 118 6 122 55 1)
		)
		(if (and (!= value -1) (!= value cursor))
			(localproc_1 [local54 value] nsLeft nsTop -1)
			(Display
				[local46 value]
				dsCOORD
				(- nsLeft 2)
				(+ nsTop 58)
				dsCOLOR
				12
				dsALIGN
				alLEFT
				dsFONT
				999
				&rest
			)
			(= cursor value)
		)
	)

	(method (highlight))

	(method (select))
)

(instance tail of Prop
	(properties
		noun 12
		view 301
		loop 1
	)
)

