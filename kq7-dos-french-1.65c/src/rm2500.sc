;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2500)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n098)
(use Str)
(use Print)
(use Sync)
(use Scaler)
(use ROsc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm2500 0
)

(local
	local0
	local1
	local2
	local3
	local4 = -1
	local5
	local6 = -1
	local7
	local8
	local9
	local10
	local11 = 19
	local12
	local13 = -1
	local14 = 9
	[local15 15] = [124 242 253 243 226 182 98 60 66 127 234 257 234 202 174]
	[local30 15] = [103 103 108 120 125 131 129 121 112 102 102 116 133 130 122]
	[local45 15] = [0 0 1 2 3 3 3 3 0 0 0 1 2 3 3]
	[local60 13] = [118 85 149 172 161 197 178 149 172 161 159 248 291]
	[local73 13] = [139 121 125 130 125 106 129 125 130 125 105 105 99]
	[local86 13] = [0 1 3 4 5 6 2 3 4 5 6 7 8]
	[local99 15] = [125 125 125 125 100 100 125 125 125 100 100 100 100 0 0]
	local114 = 10
	local115 = 8
	local116 = 10
	local117 = 10
)

(procedure (localproc_0 param1)
	(if (and local12 (== local13 2))
		(gCurRoom setScript: sLeaveKitchen 0 1)
	else
		(gCurRoom setScript: sLeaveKitchen 0 0)
	)
	(param1 claimed: 1)
)

(procedure (localproc_1 param1 &tmp temp0)
	(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
		(cond
			(([param1 temp0] respondsTo: #view)
				(if (not (gCast contains: [param1 temp0]))
					([param1 temp0] init:)
				)
			)
			((not (gFeatures contains: [param1 temp0]))
				([param1 temp0] init:)
			)
		)
		(switch [param1 0]
			(-1)
			(1
				([param1 temp0] setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			)
			(0
				([param1 temp0] setHotspot: 0 approachVerbs: 0)
			)
			(3
				([param1 temp0] setHotspot: 8 10 approachVerbs: 0) ; Do, Exit
			)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4)
	(if (not (gCast contains: cook))
		(cook init:)
	)
	(if (!= (cook view:) 2503)
		(cook view: 2503 setLoop: 2 1 cel: 0 x: 140 y: 118 setPri: 125)
	)
	(if (not (gCast contains: cookHead))
		(cookHead init:)
	)
	(if (not (gCast contains: cookArm))
		(cookArm init:)
	)
	(if argc
		(cook setHotspot: param1)
		(cookHead setHotspot: param1)
		(cookArm setHotspot: param1)
	)
	(cond
		((== argc 2)
			(cook setScript: param2)
		)
		((> argc 2)
			(cook setScript: param2 param3 param4)
		)
	)
	(UpdateScreenItem cook)
	(UpdateScreenItem cookHead)
	(UpdateScreenItem cookArm)
)

(procedure (localproc_3)
	(if (gCast contains: cookArm)
		(if (cookArm cycler:)
			((cookArm cycler:) dispose:)
		)
		(cookArm cycler: 0 dispose:)
	)
	(if (gCast contains: cookMouth)
		(if (cookMouth cycler:)
			((cookMouth cycler:) dispose:)
		)
		(cookMouth cycler: 0 dispose:)
	)
	(if (gCast contains: cookHead)
		(if (cookHead cycler:)
			((cookHead cycler:) dispose:)
		)
		(cookHead cycler: 0 dispose:)
	)
)

(procedure (localproc_4 param1)
	(sfx number: 0 stop:)
	(sfx2 number: 0 stop:)
	(bubbleFx number: 0 stop:)
	(flyBuzzFx number: 0 stop:)
	(mumbleFx number: 0 stop:)
	(gKqSound1 number: 0 stop:)
	(if (== param1 1)
		(gKqMusic1 number: 0 stop:)
	)
	(if (!= param1 3)
		(proc98_0 param1)
	)
)

(procedure (localproc_5) ; UNUSED
	(return
		(switch local14
			(1 {ON STAIRS})
			(2 {PEEKING})
			(3 {IN DOORWAY})
			(4 {IN KITCHEN})
			(5 {FIRST TIME})
			(6 {COOKING})
			(7 {DONE COOKING})
			(8 {LEAVING})
			(9 {TURNED OFF})
			(10 {TURNED ON})
			(11 {SHUT DOWN})
			(12 {INSTA-START})
			(13 {MUMBLING})
			(14 {BUBBLING})
			(15 {TOSSING ROSIE})
			(16 {SILENT})
			(17 {CHASING RAT})
			(18 {BEING TOSSED})
			(19 {BUSY})
			(20 {DONE})
		)
	)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2)
	((= temp2 (Str new:)) format: {Tues. 11-22-94 1:50pm})
	(= temp1 (Str new:))
	(cond
		((and (cook script:) (not ((cook script:) script:)))
			(temp1
				format:
					{%scook script: %s\nstate: %d\n}
					(temp2 data:)
					((cook script:) name:)
					((cook script:) state:)
			)
			(proc98_1 (temp1 data:) 0)
		)
		((and (cook script:) ((cook script:) script:))
			(temp1
				format:
					{%scook script: %s\nstate: %d\n(cook script) script: %s\nstate: %d\n}
					(temp2 data:)
					((cook script:) name:)
					((cook script:) state:)
					(((cook script:) script:) name:)
					(((cook script:) script:) state:)
			)
			(proc98_1 (temp1 data:) 0)
		)
		((gCurRoom script:)
			(temp1
				format:
					{%scurRoom script: %s state: %d\n}
					(temp2 data:)
					((gCurRoom script:) name:)
					((gCurRoom script:) state:)
			)
			(proc98_1 (temp1 data:) 0)
		)
		((gEgo script:)
			(temp1
				format:
					{%sego script: %s state: %d\n}
					(temp2 data:)
					((gEgo script:) name:)
					((gEgo script:) state:)
			)
			(proc98_1 (temp1 data:) 0)
		)
		(else
			(temp1 format: {Kitchen updated: %s\n} (temp2 data:))
			(proc98_1 (temp1 data:) 0)
		)
	)
	(proc98_8 (temp1 data:) 0)
	(temp1 dispose:)
	(= temp1 0)
	(temp2 dispose:)
	(= temp2 0)
	(if (not local0)
		(= local0 1)
		((= temp0 (Str new:))
			format:
				{total mem: %uK current free: %uK\nmusic1 number: %d handle: %x }
				global322
				(MemoryInfo 0)
				(gKqMusic1 number:)
				(gKqMusic1 handle:)
		)
		(proc98_8 (temp0 data:) 0)
		(temp0 dispose:)
	)
)

(instance rm2500 of KQRoom
	(properties
		picture 2500
	)

	(method (init &tmp [temp0 5])
		(= global375 (Str with: {Locked views:}))
		(= global376 (Str with: {Locked waves:}))
		(localproc_4 3)
		(if (== gPrevRoomNum 26)
			(gEgo put: 0) ; Golden_Comb
			(SetFlag 94)
			(gEgo get: 23) ; Toy_Rat
		)
		(if (IsFlag 55)
			(= local4 836)
		else
			(= local4 870)
		)
		(= gValOrRoz -3) ; Roz
		(= gChapter 2)
		(cond
			((and (= local12 (not (IsFlag 80))) (not (IsFlag 94)))
				(proc98_4 128 2503 2501 25012)
				(proc98_4 140 2502 2503 2504 2508 2523)
				(localproc_2 0 sFirstCookToon)
				(localproc_1 0 leftBowl rightBowl pantryDoor pot stew steam)
				(= local6 2500)
			)
			((and local12 (not (IsFlag 55)))
				(proc98_4 128 2501 2503 25012)
				(proc98_4 140 2502)
				(localproc_2 9998 sCookCooking 0 20)
				(localproc_1
					0
					leftBowl
					rightBowl
					pantryDoorF
					pantryDoor
					pot
					stew
					steam
				)
				(= local6 2500)
			)
			((not (IsFlag 55))
				(= local11 20)
				(= local6 25001)
				(if (not (IsFlag 378))
					(localproc_1 3 pantryDoorF pantryDoor)
				else
					(localproc_1 0 pantryDoor)
				)
				(if (not (IsFlag 380))
					(localproc_1 1 pot stew steam)
				else
					(localproc_1 0 pot stew steam)
				)
				(if (not (IsFlag 379))
					(localproc_1 1 oven)
				else
					(localproc_1 0 oven)
				)
				(if (not (IsFlag 53))
					(localproc_1 1 beetleDisp)
				)
				(localproc_1 1 stairs)
				(localproc_1 -1 rightBowlF leftBowlF)
			)
			(else
				(= local6 2500)
				(proc98_4 128 2503 2501 25012)
				(proc98_4 140 2502 2503 2504 2508 2523)
				(localproc_2 0 sSecondCookToon)
				(localproc_1 0 pantryDoor stew steam)
				(localproc_1 -1 rightBowlF leftBowlF)
			)
		)
		(gEgo
			x: 51
			y: 62
			init:
			normalize: 2 local4
			setLooper: 0
			looper: 0
			setPri: 50
			setScaler: Scaler 75 33 101 65
			setLoop: 2 1
			setCycle: Walk
			ignoreActors: 1
			z: 1000
		)
		(= local13 1)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 252 108 247 122 231 131 143 128 117 111 136 105
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 32 89 16 117 49 136 265 136 308 121 282 101 256 101 244 103 114 98 54 111 39 113
					yourself:
				)
			setScript: sEnterScr
		)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(Print font: gUserFont x: -1 y: -1 fore: 0 back: 84)
		(super init:)
	)

	(method (cue)
		(gKqMusic1 fade:)
		(gCurRoom setScript: sCleanUp 0 sFirstCookToon)
	)

	(method (handleEvent event &tmp [temp0 5])
		(cond
			((== (event type:) evKEYBOARD)
				(switch (event message:)
					($005c ; \
						(cond
							((IsFlag 541)
								(= local0 0)
								(= local1 0)
								(ClearFlag 562)
								(ClearFlag 541)
								(if (proc98_2 -1)
									(FrameOut)
								)
							)
							((and (not (IsFlag 541)) (IsFlag 562))
								(SetFlag 541)
							)
							(else
								(SetFlag 562)
							)
						)
						(event claimed: 1)
						(return)
					)
					(KEY_RETURN
						(if
							(and
								(gUser input:)
								(stairs onMe: (event x:) (event y:))
								(not (OneOf (gTheCursor view:) 990 991 992))
							)
							(localproc_0 event)
						else
							(event claimed: 0)
							(return)
						)
					)
					(else
						(event claimed: 0)
						(return)
					)
				)
			)
			(
				(and
					(gUser input:)
					(stairs onMe: (event x:) (event y:))
					(event type:)
					(not (OneOf (gTheCursor view:) 990 991 992))
				)
				(localproc_0 event)
			)
			(
				(and
					(cook script:)
					(OneOf (cook script:) sCookCooking sStirPot)
					(not (cook onMe: (event x:) (event y:)))
					(not (cookHead onMe: (event x:) (event y:)))
					(not (cookArm onMe: (event x:) (event y:)))
					(< (event y:) 136)
					(gUser input:)
				)
				(proc98_5)
				(cook doVerb: 8)
			)
			(else
				(event claimed: 0)
				(return)
			)
		)
	)

	(method (doVerb))

	(method (newRoom newRoomNumber &tmp temp0)
		(cookHeadTimer dispose: delete:)
		(proc98_5 2)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(localproc_4 1)
		(SetFlag 94)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (and local1 (not (Random 0 20)))
			(localproc_6)
		)
		(cond
			(script)
			((and (== local13 4) (< (gEgo x:) 49) (< (gEgo y:) 103))
				(gCurRoom setScript: sLeaveKitchen 0 0)
			)
			((and (== local13 3) (< (gEgo x:) 49) (> (gEgo y:) 103))
				(= local13 4)
			)
		)
		(super doit:)
	)
)

(instance cookHead of Prop
	(properties)

	(method (init)
		(self
			view: 2503
			setLoop: 22 1
			cel: 0
			x: 140
			y: 118
			setPri: 125
			z: 0
			cycleSpeed: 24
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cook doVerb: theVerb)
	)
)

(instance cookArm of Prop
	(properties)

	(method (init)
		(self
			view: 2503
			setLoop: 23 1
			cel: 0
			x: 140
			y: 118
			setPri: 125
			z: 0
			cycleSpeed: 24
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cook doVerb: theVerb)
	)
)

(instance steam of Prop
	(properties
		sightAngle 90
		approachX 165
		approachY 105
		x 190
		y 80
		priority 122
		fixPriority 1
		view 25012
		signal 30753
	)

	(method (doVerb theVerb)
		(gEgo loop: 8 cel: 4 heading: 125)
		(if (== theVerb 8) ; Do
			(SetFlag 380)
			(gMessager say: 2 8 4 1) ; "(THINKS TO HERSELF)Bleh. That's enough to give a person nightmares."
			(self setHotspot: 0)
			(stew setHotspot: 0)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd cycleSpeed: local115 setScript: sSteam)
	)
)

(instance stew of Prop
	(properties
		sightAngle 90
		approachX 165
		approachY 105
		x 189
		y 78
		z 1000
		priority 123
		fixPriority 1
		view 25012
		loop 1
		signal 30753
	)

	(method (doVerb theVerb)
		(gEgo loop: 8 cel: 4 heading: 125)
		(if (== theVerb 8) ; Do
			(SetFlag 380)
			(gMessager say: 2 8 4 1) ; "(THINKS TO HERSELF)Bleh. That's enough to give a person nightmares."
			(self setHotspot: 0)
			(steam setHotspot: 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pot of Feature
	(properties
		noun 2
		nsLeft 172
		nsTop 73
		nsRight 203
		nsBottom 82
		sightAngle 90
		approachX 165
		approachY 105
		x 198
		y 124
	)

	(method (doVerb theVerb)
		(gEgo loop: 8 cel: 4 heading: 125)
		(if (== theVerb 8) ; Do
			(SetFlag 380)
			(gMessager say: 2 8 4 1) ; "(THINKS TO HERSELF)Bleh. That's enough to give a person nightmares."
			(stew setHotspot: 0)
			(steam setHotspot: 0)
			(self dispose:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pantryDoor of Prop
	(properties
		noun 4
		sightAngle 90
		approachX 282
		approachY 101
		x 272
		y 46
		z -50
		priority 50
		fixPriority 1
		view 2500
		signal 30753
	)

	(method (init)
		(if local12
			(= loop 3)
		else
			(= loop 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 8) (not local12)) ; Do
			(SetFlag 378)
			(gMessager say: 4 8 4 1) ; "(THINKS TO HERSELF)I'm not letting HIM out! No way!"
			(self setHotspot: 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance oven of Feature
	(properties
		noun 3
		sightAngle 90
		approachX 110
		approachY 105
		x 74
		y 84
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 74 25 65 29 67 43 76 46 76 72 67 72 78 100 113 96 113 73 90 73 87 31
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(gCurRoom setScript: sMooseJoke)
			(self dispose:)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance cook of Prop
	(properties
		priority 125
		fixPriority 1
		signal 30753
	)

	(method (init)
		(self view: 2503 setLoop: 2 1 cel: 0 x: 140 y: 118 setPri: 125)
		(super init:)
		(self cycleSpeed: local115)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: throwOutScript 0 0)
			)
			(32 ; Toy_Rat
				(sfx number: 12 setLoop: 1 loop: 1 play: setVol: 127)
				(gCurRoom setScript: sRatCartoon)
			)
			(else
				(gCurRoom setScript: throwOutScript 0 3)
			)
		)
	)
)

(instance rat of View
	(properties
		view 25013
		loop 2
		signal 30753
	)
)

(instance spoon of View
	(properties
		x 114
		y 105
		view 25012
		loop 3
		signal 30753
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance sfx2 of Sound
	(properties
		flags 5
	)
)

(instance sfx3 of Sound ; UNUSED
	(properties
		flags 5
	)
)

(instance bubbleFx of Sound
	(properties
		flags 5
	)
)

(instance flyBuzzFx of Sound
	(properties
		flags 5
	)
)

(instance mumbleFx of Sound
	(properties
		flags 5
		number 2502
	)
)

(instance beetleDisp of Feature
	(properties
		noun 5
		nsLeft 145
		nsTop 52
		nsRight 165
		nsBottom 71
		sightAngle 90
		approachX 136
		approachY 99
		x 161
		y 61
	)

	(method (doVerb theVerb)
		(if (or local12 (not (gUser controls:)) (!= theVerb 8)) ; Do
			(super doVerb: theVerb)
		else
			(gCurRoom setScript: sGetBeetle)
			(localproc_1 3 self)
		)
	)
)

(instance pantryDoorF of Feature
	(properties
		sightAngle 90
		approachX 282
		approachY 101
		x 316
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 278 26 268 48 268 96 308 102 309 50 301 26
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(localproc_1 0 self)
		(pantryDoor doVerb: theVerb)
	)
)

(instance sSteam of Script
	(properties)

	(method (init)
		(proc98_4 140 24600 25500 2501 2505 2515 812)
		(super init: &rest)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((== local14 12)
				(if (and (> ticks 1) (not state))
					(= ticks 30)
				)
				(= local14 10)
			)
			((and (== local14 9) (bubbleFx handle:))
				(localproc_4 3)
			)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (> (++ local7) 6)
					(= local7 0)
				)
				(if (!= local14 10)
					(= ticks (Random 120 600))
				else
					(= ticks 120)
				)
			)
			(1
				(cond
					((== local14 11)
						(self init:)
					)
					((OneOf local14 14 10 9)
						(if (== local7 1)
							(= register 1)
							(stew
								setLoop: 1
								z: 0
								x: 191
								y: 78
								cel: 0
								cycleSpeed: local115
								setCycle: End self
							)
							(if
								(and
									(not local8)
									(!= local14 9)
									(not (OneOf local11 19 13))
								)
								(bubbleFx
									number: 2501
									setLoop: -1
									loop: -1
									play:
									setVol: 127
								)
							)
						else
							(= register 2)
							(stew
								setLoop: 2
								z: 0
								x: 187
								y: 86
								cel: 0
								cycleSpeed: local115
								setCycle: End self
							)
							(= temp0 0)
							(switch local7
								(2
									(= temp0 2505)
								)
								(3
									(= temp0 812)
								)
								(4
									(= temp0 2515)
								)
								(5
									(= temp0 25500)
								)
								(6
									(= temp0 24600)
									(= local7 0)
								)
							)
							(if
								(and
									temp0
									(not local8)
									(!= local14 9)
									(not (OneOf local11 19 13))
								)
								(bubbleFx
									number: temp0
									setLoop: -1
									loop: -1
									play:
									setVol: 127
								)
							)
						)
					)
				)
			)
			(2
				(if (-- register)
					(-- state)
					(= temp0 0)
					(switch (Random 1 5)
						(1
							(= temp0 2505)
						)
						(2
							(= temp0 812)
						)
						(3
							(= temp0 2515)
						)
						(4
							(= temp0 25500)
						)
						(5
							(= temp0 24600)
						)
					)
					(if
						(and
							(not local8)
							(!= local14 9)
							(not (OneOf local11 19 13))
						)
						(bubbleFx
							number: temp0
							setLoop: -1
							loop: -1
							play:
							setVol: 127
						)
					)
					(stew cel: 0 setCycle: End self)
				else
					(bubbleFx stop:)
					(stew z: 1000)
					(self changeState: 0)
				)
			)
		)
	)
)

(instance leftBowl of View
	(properties
		noun 7
		sightAngle 90
		approachX 124
		approachY 101
		x 122
		y 4
		z -70
		view 2500
		signal 30753
	)
)

(instance rightBowl of View
	(properties
		noun 6
		sightAngle 90
		approachX 128
		approachY 104
		x 135
		y 3
		z -60
		view 2500
		loop 1
		signal 30753
	)
)

(instance stairs of ExitFeature
	(properties
		approachX 33
		approachY 102
		exitDir 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 45 23 42 23 41 10 37 4 34 9 31 33 29 33 26 10 24 31 21 29 19 13 18 34 16 33 12 18 10 17 4 22 5 38 14 42 20 71 19 84 23 94 52 94 60 55 53 25
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
	)
)

(instance sGetRightBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo loop: 8 cel: 6 heading: 45)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 8775
					setLoop: 0
					setCycle: 0
					cel: 0
					setSpeed: local115
					x: 131
				)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 8 1 self)
			)
			(3
				(if (not (IsFlag 555))
					(SetFlag 555)
				)
				(gEgo get: 33 1) ; Bowl_b
				(if (IsFlag 99)
					(SetFlag 68)
				else
					(ClearFlag 68)
				)
				(ClearFlag 52)
				(rightBowl dispose:)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo heading: 45 normalize: 6 local4 loop: 8 cel: 6 x: 128)
				(= cycles 2)
			)
			(5
				(gEgo setHeading: 180 self)
			)
			(6
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance leftBowlF of Feature
	(properties
		noun 7
		sightAngle 90
		approachX 101
		approachY 101
		x 126
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 121 63 121 73 134 73 134 63
					yourself:
				)
		)
		(if
			(and
				(not (IsFlag 57))
				(not (gEgo has: 24)) ; Bowl_a
				(not (gCast contains: leftBowl))
			)
			(leftBowl setPri: -1 init:)
		)
		(if (and (not (IsFlag 57)) (not (gEgo has: 24))) ; Bowl_a
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		else
			(self setHotspot: 0 33 approachVerbs: 33) ; Bowl_a, Bowl_a
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			(local12
				(super doVerb: theVerb)
			)
			((and (gCast contains: leftBowl) (gEgo has: 33)) ; Bowl_b
				(gMessager say: 6 8 6 1) ; "(THINKS TO HERSELF)I already have a brass bowl. I shouldn't get greedy."
			)
			((and (gEgo has: 24) (== theVerb 33)) ; Bowl_a, Bowl_a
				(gCurRoom setScript: putBackLeftBowl 0 self)
			)
			((gCast contains: leftBowl)
				(self setHotspot: 0 33 approachVerbs: 33) ; Bowl_a, Bowl_a
				(gCurRoom setScript: sGetLeftBowl)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sEnterScr of Script
	(properties)

	(method (dispose)
		(proc98_3 140 801 802)
		(if (and local12 (not (IsFlag 94)))
			(proc98_4 128 25011 25014 2501 25010)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (IsFlag 539)
			(client setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(proc98_4 140 801 802)
					(gKqMusic1
						number: local6
						setLoop: -1
						loop: -1
						play:
						setVol: 1
					)
					(if (not (IsFlag 94))
						(proc98_5 1)
					else
						(proc98_5)
					)
					(= ticks 240)
				)
				(1
					(sfx number: 802 setLoop: 1 loop: 1 play: setVol: 127)
					(gKqMusic1 fade: 127 10 10 0)
					(= ticks 60)
				)
				(2
					(if local12
						(= local11 6)
					)
					(if (IsFlag 55)
						(gEgo
							z: 0
							setSpeed: local115
							setMotion: MoveTo 42 102 self
						)
					else
						(gEgo
							z: 0
							setSpeed: local115
							setMotion: MoveTo 40 94 self
						)
					)
				)
				(3
					(cond
						((and local12 (not (IsFlag 55)))
							(gEgo
								view: 2502
								setCycle: 0
								setLooper: 0
								setLoop: 0 1
								cel: 0
								x: 43
								y: 95
								z: 0
								setScaler: 0
								setScale: 0
								ignoreActors: 1
								setPri: 59
							)
							(UpdateScreenItem gEgo)
							(if (not (IsFlag 94))
								(= local13 5)
								(self dispose:)
							else
								(= local13 2)
								(localproc_1 3 stairs)
								(proc98_6)
								(self dispose:)
							)
						)
						((IsFlag 55)
							(gEgo
								view: 2504
								setCycle: 0
								setLooper: 0
								setLoop: 1 1
								cel: 0
								x: 44
								y: 100
								z: 0
								setScaler: 0
								setScale: 0
								ignoreActors: 1
								setPri: -1
							)
							(= local11 6)
							(= local14 9)
							(proc98_5 1)
							(self dispose:)
						)
						(else
							(gEgo setMotion: MoveTo 32 104 self)
						)
					)
				)
				(4
					(= local14 14)
					(= local13 4)
					(gEgo
						setPri: -1
						setCycle: 0
						normalize: 2 local4
						loop: 8
						cel: 2
						setScaler: Scaler 100 77 137 104
					)
					(stairs init:)
					(proc98_6 1)
					(self dispose:)
				)
			)
		)
	)
)

(instance sThrowTrollOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo view: 996 setLoop: 0 z: 1000)
				(cook cel: 9)
				(sfx number: 824 setLoop: 1 loop: 1 play: 127 self)
				(UpdateScreenItem cook)
				(UpdateScreenItem gEgo)
				(FrameOut)
			)
			(1
				(= ticks local116)
			)
			(2
				(sfx number: 0 stop:)
				(proc98_3 140 824)
				(gEgo view: 996 setLoop: 0 z: 1000)
				(cook view: 2503 setLoop: 5 cel: 0 x: 43 y: 106)
				(= ticks local116)
			)
			(3
				(cook cel: 1 x: 34 y: 103)
				(= ticks local116)
			)
			(4
				(cook cel: 2 x: 27 y: 102)
				(= ticks local116)
			)
			(5
				(cook cel: 3 x: 23 y: 97 setPri: 50)
				(= ticks local116)
			)
			(6
				(cook cel: 4 x: 35 y: 88)
				(= ticks local116)
			)
			(7
				(cook cel: 5 x: 33 y: 95)
				(= ticks local116)
			)
			(8
				(cook cel: 6 x: 32 y: 97)
				(UpdateScreenItem cook)
				(self dispose:)
			)
		)
	)
)

(instance sMooseJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(proc98_4 140 1216)
				(SetFlag 379)
				(bubbleFx stop:)
				(= local14 9)
				(= ticks 30)
			)
			(1
				(gMessager say: 3 8 4 1 self) ; "(THINKS TO HERSELF, THEN GIGGLES)They could cook a MOOSE in there. Gosh, they probably are!"
			)
			(2
				(sfx number: 1216 setLoop: 1 loop: 1 play: 127 self)
			)
			(3
				(proc98_3 140 1216)
				(= local14 12)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance sGetBeetle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gEgo has: 26) ; Baked_Beetles
					(gMessager say: 5 8 5 1) ; "(THINKS TO HERSELF)I already have some of those. I guess I don't need any more right now."
					(self dispose:)
				else
					(proc98_5)
					(proc98_4 140 2517 2504 815)
					(proc98_4 128 2507)
					(gEgo
						heading: 90
						setLooper: 0
						looper: 0
						setLoop: 8 1
						setCycle: 0
						cel: 6
					)
					(= register 4)
					(= ticks local116)
				)
			)
			(1
				(gEgo
					view: 2507
					setLoop: 0 1
					cel: 0
					setScaler: 0
					setScale: 0
				)
				(= ticks local116)
			)
			(2
				(= local14 9)
				(gEgo cel: 0 cycleSpeed: local115 setCycle: CT 4 1 self)
				(sfx number: 815 setLoop: 1 loop: 1 play: setVol: 127)
			)
			(3
				(if (-- register)
					(-= state 2)
				)
				(= ticks local116)
			)
			(4
				(gEgo setCycle: CT 10 1 self)
			)
			(5
				(gKqSound1 number: 2517 setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo cel: 11)
				(= ticks 90)
			)
			(6
				(gEgo setCycle: CT 20 1 self)
			)
			(7
				(sfx number: 2504 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 60)
			)
			(8
				(gEgo cel: 21)
				(= ticks local116)
			)
			(9
				(gEgo cel: 22)
				(sfx number: 2504 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 90)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo
					normalize: 0 local4
					heading: 90
					setScaler: Scaler 100 77 137 104
					loop: 8
					cel: 0
				)
				(if (not (IsFlag 556))
					(SetFlag 556)
					(sfx number: 12 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(gEgo get: 26 1) ; Baked_Beetles
				(= cycles 2)
			)
			(12
				(proc98_6 1)
				(= local14 12)
				(proc98_3 140 2517 2504 815)
				(proc98_3 128 2507)
				(self dispose:)
			)
		)
	)
)

(instance sThrowRosieOut of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(gCurRoom setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(cook
						view: 2504
						setLoop: 0
						cel: 0
						x: 65
						y: 110
						setCycle: CT 2 1 self
					)
				)
				(1
					(cook setCycle: CT 6 1 self)
				)
				(2
					(gEgo view: 996 setLoop: 0 z: 1000)
					(cook setCycle: CT 8 1 self)
				)
				(3
					(cook cel: 9 x: 43 y: 103)
					(= ticks 10)
				)
				(4
					(if (IsFlag 55)
						(gMessager say: 0 0 7 4 0) ; "OUT! OUT! OUT!"
					)
					(cook setPri: 30 setLoop: 2 x: 44 y: 94 cel: 0)
					(= ticks 10)
				)
				(5
					(cook x: 46 y: 93 cel: 1)
					(= ticks 10)
				)
				(6
					(cook x: 48 y: 93 cel: 2)
					(= ticks 10)
				)
				(7
					(self dispose:)
				)
			)
		)
	)
)

(instance sLeaveKitchen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(if
					(and
						(OneOf
							(gEgo view:)
							2241
							800
							836
							870
							902
							9021
							9022
						)
						(not (gEgo inRect: 13 98 41 105))
					)
					(-- state)
					(gEgo
						setMotion:
							PolyPath
							(stairs approachX:)
							(stairs approachY:)
							self
					)
				else
					(= local13 8)
					(= cycles 2)
				)
			)
			(1
				(if register
					(gEgo
						normalize: 4 local4
						loop: 8
						cel: 4
						x: 36
						y: 97
						setPri: 50
						heading: 125
						setScaler: Scaler 75 33 101 65
						setSpeed: local115
					)
					(= state 999)
					(= ticks local116)
				else
					(gEgo
						setScaler: Scaler 75 33 101 65
						normalize: 3 local4
						loop: 8
						cel: 3
						setPri: 50
						heading: 360
					)
					(= cycles local115)
				)
			)
			(2
				(gKqMusic1 fade:)
				(gEgo
					setCycle: 0
					setLoop: 3 1
					setCycle: Walk
					setSpeed: local115
					setMotion: MoveTo 56 60 self
				)
			)
			(3
				(sfx number: 801 setLoop: 1 loop: 1 play: setVol: 127)
				(gEgo setMotion: MoveTo 59 55 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(sfx number: 823 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 90)
			)
			(6
				(gCurRoom newRoom: 2450)
			)
			(1000
				(= local10 1)
				(gEgo setHeading: 360 self)
			)
			(1001
				(= cycles local115)
			)
			(1002
				(gEgo
					setCycle: 0
					setLoop: 3 1
					setCycle: Walk
					setMotion: MoveTo 47 76 self
				)
			)
			(1003
				(gEgo setMotion: MoveTo 56 60 self)
			)
			(1004
				(gKqMusic1 fade:)
				(sfx number: 801 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 90)
			)
			(1005
				(gEgo z: 1000)
				(= ticks 30)
			)
			(1006
				(sfx number: 823 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 90)
			)
			(1007
				(gCurRoom newRoom: 2450)
			)
		)
	)
)

(instance cookMouth of Prop
	(properties
		view 996
		signal 30753
	)
)

(instance cookHeadTimer of Timer
	(properties)

	(method (cue)
		(if (gCast contains: cookHead)
			(cookHead setCycle: 0)
		)
	)
)

(instance sSecondCookToon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(gCurRoom setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(self setScript: sStirPot self 4)
				)
				(1
					(= local14 9)
					(mumbleFx number: 2502 setLoop: 1 loop: 1 play: setVol: 127)
					(cook
						view: 25014
						setLoop: 0
						cel: 17
						x: 154
						y: 117
						setPri: 125
						setCycle: CT 10 -1 self
					)
				)
				(2
					(cook
						view: 2501
						setLoop: 0
						cel: 0
						x: 143
						y: 122
						setCycle: CT 10 1 self
					)
					(= register 8)
				)
				(3
					(if (== (cook cel:) 10)
						(cook cel: 9)
					else
						(cook cel: 10)
					)
					(if (-- register)
						(-- state)
					else
						(mumbleFx stop:)
					)
					(= ticks local116)
				)
				(4
					(= ticks local116)
				)
				(5
					(gMessager say: 0 0 7 1) ; "Yes, yes, yes! You are the loveliest centipede-and-fungus croquettes I've ever seen!"
					(cook setCycle: ROsc 2 13 27 self)
				)
				(6
					(cook view: 25014 setLoop: 0 cel: 7 x: 154 y: 117)
					(= ticks local116)
				)
				(7
					(cook cel: 2)
					(= ticks local116)
				)
				(8
					(cook setCycle: CT 9 1 self)
				)
				(9
					(= ticks (+ 10 (DoAudio audPLAY 2500 0 0 7 2))) ; "Eeeeow!"
					(cook setCycle: End self)
				)
				(10)
				(11
					(proc98_3 128 25014)
					(= ticks local116)
				)
				(12
					(self setScript: throwOutScript self 1)
				)
				(13
					(self dispose:)
				)
			)
		)
	)
)

(instance sStirPot of Script
	(properties)

	(method (dispose)
		(if local3
			(gCurRoom newRoom: 2450)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(if (IsFlag 539)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(= local8 1)
					(if
						(or
							(not (gCast contains: cookArm))
							(!= (cook view:) 2503)
						)
						(localproc_2)
					)
					(= ticks local116)
				)
				(1
					(if (not (cookArm cycler:))
						(cookArm cel: 1)
					)
					(= ticks (Random 20 60))
				)
				(2
					(if (not (cookArm cycler:))
						(cookArm cel: 0)
					)
					(if (-- register)
						(-= state 2)
						(= ticks (Random 20 60))
						(if (and local3 (== register 2))
							(gKqMusic1 fade:)
						)
					else
						(= local8 0)
						(if (and (not local2) (not local3))
							(localproc_3)
						)
						(= local2 0)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance cookMouthSync of MouthSync
	(properties)
)

(instance cookRandCycle of RandCycle
	(properties)
)

(instance throwOutScript of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(switch register
				(0
					(gCurRoom setScript: sCleanUp 0 self)
				)
				(else
					(= local11 16)
					(cook setScript: sCookCooking 0 999)
					(gCurRoom setScript: sCleanUp 0 sCookCooking)
				)
			)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(if (!= client sSecondCookToon)
						(proc98_5 1)
					)
					(= local11 15)
					(= local14 9)
					(= local13 18)
					(= ticks 30)
				)
				(1
					(switch register
						(0
							(gMessager say: 1 8 0 1) ; "Excuse me, Mr. Cook..."
						)
						(1
							(gMessager say: 0 0 1 4) ; "Oh, I'm sorry! I didn't mean--"
						)
						(2
							(= ticks local116)
						)
						(3
							(gMessager say: 0 0 2 1) ; "(CAUTIOUSLY)Sir, I was wondering if you'd be interested--"
						)
					)
					(localproc_3)
					(cook
						view: 2503
						setLoop: 2
						cel: 1
						x: 140
						y: 118
						setCycle: End self
					)
				)
				(2
					(= ticks 90)
				)
				(3
					(cook
						view: 25035
						setLoop: 7
						cel: 1
						x: 128
						y: 126
						cycleSpeed: 6
						setCycle: CT 10 1 self
					)
					(cond
						((IsFlag 55)
							(gMessager say: 0 0 7 3) ; "Eeeeow! What are YOU? Get out of here, you pasty-faced croquette thief! You'll not get a bite!"
						)
						((== register 3)
							(gMessager say: 0 0 2 2) ; "OUT, YOU PEASANT! OUT!"
						)
						(else
							(gMessager say: 0 0 1 5) ; "OUT! OUT! OUT OF MY KITCHEN, YOU DREADFUL PEASANT!"
						)
					)
				)
				(4
					(cook setCycle: ROsc 2 10 20 self)
				)
				(5
					(cook setCycle: End self)
				)
				(6
					(cook view: 2503 setLoop: 4 cel: 8 x: 79 y: 110)
					(if (not (IsFlag 55))
						(spoon
							view: 25012
							setLoop: 3
							cel: 0
							x: 114
							y: 105
							init:
						)
						(self setScript: sThrowTrollOut self)
					else
						(spoon view: 2504 setLoop: 3 cel: 0 x: 94 y: 109 init:)
						(gEgo setCycle: End)
						(self setScript: sThrowRosieOut self 0)
					)
				)
				(7
					(self setScript: sCookReturns self 0)
				)
				(8
					(proc98_5 3)
					(= cycles 2)
				)
				(9
					(cond
						((mumbleFx handle:)
							(-- state)
							(= ticks 30)
						)
						((IsFlag 55)
							(= local3 1)
							(= local14 12)
							(cook setScript: sStirPot 0 5)
							(self dispose:)
						)
						((!= register 1)
							(mumbleFx number: 0 stop:)
							(= local11 16)
							(= local14 10)
							(cook setScript: sCookCooking 0 999)
							(if (not (gCast contains: cookArm))
								(cookArm init:)
							)
							(cookArm setCycle: cookRandCycle)
							(gCurRoom setScript: sCleanUp 0 sCookCooking)
						)
						(else
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance sCookReturns of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(cook view: 996 setLoop: 0 z: 1000)
				(UpdateScreenItem cook)
				(= cycles 2)
			)
			(1
				(proc98_4 140 4082 2506 823 2535)
				(sfx number: 801 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 120)
			)
			(2
				(sfx number: 0 stop:)
				(proc98_3 140 801)
				(while (== global324 (= temp0 (Random 1 5)))
				)
				(switch (= global324 temp0)
					(1
						(DoAudio audPLAY 4400 12 8 1 1) ; "(SCREAM THAT SOUNDS LIKE ROSELLA IS FALLING INTO A DEEP, DEEP PIT--SCREAM TRAILS OFF)EEEEEEEEEEEEEEEEEEEEEEEE!"
						(= ticks 10)
					)
					(2
						(DoAudio audPLAY 4350 0 0 3 1) ; "(MUFFLED; VOICE COMING FROM FAR UNDER THE GROUND)Nooooooooo!"
						(= ticks 90)
					)
					(3
						(DoAudio audPLAY 1450 1 8 0 2) ; "(TERRIFIED, SHOUTING)No! Stop!"
						(= ticks 90)
					)
					(4
						(sfx2 number: 2535 setLoop: 1 loop: 1 play: setVol: 127)
						(= ticks 90)
					)
					(5
						(sfx2 number: 4082 setLoop: 1 loop: 1 play: setVol: 127)
						(= ticks 90)
					)
				)
			)
			(3
				(sfx number: 856 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks 180)
			)
			(4
				(DoAudio audSTOP)
				(sfx stop:)
				(switch (Random 1 3)
					(1
						(= register 2506)
					)
					(2
						(= register 865)
					)
					(3
						(= register 1211)
					)
				)
				(sfx2 number: register setLoop: 1 loop: 1 play: setVol: 127)
				(= cycles 1)
			)
			(5
				(proc98_14)
				(proc98_3 140 4082 856)
				(= ticks 180)
			)
			(6
				(sfx number: 823 setLoop: 1 loop: 1 play: setVol: 127)
				(proc98_3 140 865)
				(proc98_15)
				(= ticks 90)
			)
			(7
				(proc98_3 140 823)
				(cook
					view: 25035
					setLoop: 6
					cel: 0
					x: 133
					y: 113
					setPri: 50
					z: 0
					cycleSpeed: local115
				)
				(= local11 13)
				(mumbleFx number: 2502 setLoop: 1 loop: 1 play: setVol: 127)
				(= ticks local116)
			)
			(8
				(cook setCycle: CT 10 1 self)
			)
			(9
				(cook cel: 11 x: 136 y: 113)
				(= ticks local116)
			)
			(10
				(cook cel: 12 x: 127 y: 115)
				(= ticks local116)
			)
			(11
				(cook cel: 13 x: 120 y: 117 setPri: -1 setCycle: CT 21 1 self)
			)
			(12
				(cook cel: 22 x: 140 y: 120)
				(spoon dispose:)
				(= ticks local116)
			)
			(13
				(cook cel: 23 x: 153 y: 119 setPri: 125)
				(= ticks local116)
			)
			(14
				(cook cel: 24 x: 156 y: 117 setCycle: End self)
			)
			(15
				(self dispose:)
			)
		)
	)
)

(instance sCookCooking of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (OneOf local11 15 20)
			(= cycles (= ticks 0))
			(self dispose:)
		)
	)

	(method (changeState newState)
		(if (IsFlag 539)
			(localproc_4 0)
			(= local14 9)
			(= local11 20)
			(gCurRoom setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(= local10 register)
					(if (and (!= local11 19) (!= register 999))
						(= local11 6)
					else
						(= local11 16)
					)
					(localproc_2)
					(= ticks local116)
				)
				(1
					(cond
						((OneOf local11 15 20)
							(self dispose:)
						)
						((== local11 17)
							(= local14 9)
							(= local11 7)
							(sRatCartoon register: 1)
							(self dispose:)
						)
						((OneOf local11 6 13 16)
							(cond
								((== local11 16))
								(
									(and
										(not (mumbleFx handle:))
										(not (bubbleFx handle:))
										(> (Random 0 100) 40)
									)
									(mumbleFx stop:)
									(= local14 10)
									(= local11 6)
									(if
										(and
											(gCast contains: cookHead)
											(cookHead cycler:)
										)
										(cookHead setCycle: 0)
									)
								)
								(
									(and
										(not (bubbleFx handle:))
										(not (mumbleFx handle:))
										(> (Random 0 100) 60)
									)
									(mumbleFx
										number: 2502
										setLoop: 1
										loop: 1
										play:
										setVol: 127
									)
									(bubbleFx stop:)
									(= local14 9)
									(= local11 13)
									(if
										(and
											(gCast contains: cookHead)
											(not (cookHead cycler:))
										)
										(cookHead setCycle: cookRandCycle)
									)
								)
							)
							(if (not (cookArm cycler:))
								(cookArm cel: 1)
							)
							(if (== local13 8)
								(= cycles 2)
							else
								(= ticks (Random 30 90))
							)
						)
					)
				)
				(2
					(if (!= local13 8)
						(if (not (cookArm cycler:))
							(cookArm cel: 0)
						)
						(if (-- local10)
							(= state 0)
						)
					)
					(= ticks (Random 30 90))
				)
				(3
					(proc98_5 3)
					(= local14 9)
					(if (== local13 8)
						(localproc_3)
						(cook cel: 1 setCycle: End self)
						(cook setLoop: 3)
						(cookHead init: setLoop: 24 setCycle: cookRandCycle)
					)
					(= cycles 2)
				)
				(4
					(= local11 16)
					(mumbleFx stop:)
					(if (== local13 8)
						(gMessager say: 1 32 0 1 self) ; "(STARTLED AND IRRITATED)What's going on? Who's there?"
					else
						(gCurRoom setScript: throwOutScript 0 2)
						(self dispose:)
					)
				)
				(5
					(localproc_3)
					(cook view: 2503 setLoop: 2 1 cel: 4)
					(self dispose:)
				)
			)
		)
	)
)

(instance sFirstCookToon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (IsFlag 539)
			(gCurRoom setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(self setScript: sStirPot self 4)
				)
				(1
					(mumbleFx number: 2502 setLoop: 1 loop: 1 play: setVol: 127)
					(cook
						view: 25014
						setLoop: 0
						cel: 17
						x: 154
						y: 117
						setPri: 125
						setCycle: CT 10 -1 self
					)
				)
				(2
					(cook
						view: 2501
						setLoop: 0
						cel: 0
						x: 143
						y: 122
						setCycle: CT 10 1 self
					)
					(= register 8)
				)
				(3
					(if (== (cook cel:) 10)
						(cook cel: 9)
					else
						(cook cel: 10)
					)
					(if (-- register)
						(-- state)
					else
						(mumbleFx stop:)
					)
					(= ticks local116)
				)
				(4
					(proc98_4 140 2503)
					(= ticks local116)
				)
				(5
					(gMessager say: 0 0 1 1) ; "All right then! Just a touch of frog lips! A dash of mouse noses! A sprinkling of spider legs!"
					(cook cycleSpeed: 6 setCycle: CT 27 1 self)
				)
				(6
					(cook setCycle: ROsc 4 13 27 self)
				)
				(7
					(flyBuzzFx
						number: 2503
						setLoop: -1
						loop: -1
						play:
						setVol: 127
					)
					(cook setCycle: End self)
				)
				(8
					(cook
						view: 25010
						cel: 0
						x: 143
						y: 123
						setCycle: CT 4 1 self
					)
					(proc98_3 128 2501)
				)
				(9
					(= ticks 90)
				)
				(10
					(cook setCycle: CT 10 1 self)
				)
				(11
					(cook cel: 11)
					(UpdateScreenItem cook)
					(= cycles 1)
				)
				(12
					(sfx number: 2508 setLoop: 1 loop: 1 play: setVol: 127)
					(flyBuzzFx stop:)
					(cook cel: 12)
					(UpdateScreenItem cook)
					(= ticks 90)
				)
				(13
					(cook setCycle: CT 16 1 self)
				)
				(14
					(cook setCycle: CT 19 1 self)
					(mumbleFx number: 2502 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(15
					(cook cel: 19)
					(= ticks 120)
				)
				(16
					(mumbleFx stop:)
					(cook setCycle: CT 24 1 self)
				)
				(17
					(gEgo setPri: 50 setCycle: End self)
					(sfx number: 2523 setLoop: 1 loop: 1 play: setVol: 127)
					(= local14 12)
				)
				(18
					(= ticks (+ 10 (DoAudio audPLAY 2500 0 0 1 3))) ; "EEEEEOW!"
				)
				(19
					(gEgo setLoop: 0 cel: 0 setPri: 59)
					(= seconds 4)
				)
				(20
					(= local14 9)
					(bubbleFx stop:)
					(cook setCycle: End self)
				)
				(21
					(cookMouth
						view: 25011
						setLoop: 20 1
						x: (cook x:)
						y: (cook y:)
						setPri: (+ (cook priority:) 1)
						cycleSpeed: 12
						init:
					)
					(cook
						view: 25011
						setLoop: 0
						cel: 3
						setPri: 125
						x: 143
						y: 120
						setCycle: 0
					)
					(= cycles 2)
				)
				(22
					(cookMouth setCycle: cookRandCycle)
					(gMessager say: 0 0 1 2 self) ; "(LOVINGLY)You are so wonderful! You are the most beautiful stew in the world. All you need is...a juicy bat! Or a tender rat! Mmmmmm!"
				)
				(23
					(cookMouth setCycle: 0 cel: 0 z: 1000)
					(cook cel: 2 setCycle: Beg self)
					(sfx number: 2504 setLoop: 1 loop: 1 play: setVol: 127)
					(proc98_3 128 25010)
				)
				(24
					(= ticks local116)
				)
				(25
					(cook setCycle: CT 2 1 self)
				)
				(26
					(cookMouth z: 0)
					(cook cel: 3)
					(= ticks 60)
				)
				(27
					(cookMouth z: 1000)
					(sfx number: 2504 setLoop: 1 loop: 1 play: setVol: 127)
					(cook cel: 2 setCycle: Beg self)
				)
				(28
					(= ticks local116)
				)
				(29
					(cook setCycle: CT 2 1 self)
				)
				(30
					(cookMouth z: 0)
					(cook cel: 3)
					(= cycles 1)
				)
				(31
					(localproc_3)
					(cook cel: 4 setCycle: End self)
				)
				(32
					(cook view: 25014 setLoop: 0 cel: 7 x: 154 y: 117)
					(proc98_3 128 25011)
					(= ticks local116)
				)
				(33
					(cook cel: 2)
					(= ticks local116)
				)
				(34
					(gEgo cel: 0 setPri: 50 setCycle: End)
					(cook setCycle: CT 9 1 self)
				)
				(35
					(localproc_4 3)
					(= local14 9)
					(DoAudio audPLAY 2500 0 0 1 3) ; "EEEEEOW!"
					(cook setCycle: End self)
				)
				(36
					(proc98_3 128 25014)
					(= local14 11)
					(= local2 1)
					(self setScript: sStirPot self 3)
				)
				(37
					(gEgo setLoop: 0 cel: 0 setPri: 59)
					(= ticks 60)
				)
				(38
					(self setScript: throwOutScript self 1)
				)
				(39
					(proc98_5 3)
					(localproc_2)
					(cookHead setCycle: cookRandCycle)
					(= register (+ 10 (DoAudio audPLAY gCurRoomNum 0 0 1 6 0)))
					(cookHeadTimer setTicks: register cookHeadTimer)
					(= local3 1)
					(client setScript: sStirPot 0 6)
				)
			)
		)
	)
)

(instance sCleanUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5 3)
				(switch register
					(sRatCartoon
						(proc98_1 {sCleanup called from sRatCartoon})
						(= state 99)
					)
					(sCookCooking
						(proc98_1 {sCleanup called from sCooking})
						(= state 199)
					)
					(else
						(= state 200)
					)
				)
				(= cycles 2)
			)
			(100
				(= local13 3)
				(gEgo
					heading: 180
					setPri: -1
					setCycle: 0
					normalize: 2 local4
					setScaler: Scaler 75 33 101 65
					loop: 8
					cel: 2
					x: 32
					y: 103
					setMotion: MoveTo 32 104 self
				)
				(localproc_3)
				(if (gCast contains: cook)
					(cook dispose:)
				)
				(if (gCast contains: rat)
					(rat dispose:)
				)
				(pantryDoor view: 2500 setLoop: 2 cel: 0)
				(= local14 12)
			)
			(101
				(= local13 4)
				(gEgo setScaler: Scaler 100 77 137 104)
				(proc98_3 128 25013 2506 2505 2501 2503 25035)
				(localproc_1 3 pantryDoorF pantryDoor)
				(pantryDoor setLoop: 2)
				(localproc_1 1 pot stew steam oven stairs beetleDisp)
				(localproc_1 -1 rightBowlF leftBowlF)
				(SetFlag 80)
				(= local12 0)
				(= local14 10)
				(= local11 16)
				(proc98_6 1)
				(gKqMusic1 number: 25001 setLoop: -1 loop: -1 play: setVol: 127)
				(self dispose:)
			)
			(200
				(gEgo view: 996 setLoop: 0 z: 1000)
				(= local11 6)
				(= local14 10)
				(if (not (& (gEgo signal:) $0008))
					(UpdateScreenItem gEgo)
				)
				(UpdateScreenItem cook)
				(if (IsFlag 55)
					(= cycles 2)
				else
					(= seconds 8)
				)
			)
			(201
				(bubbleFx number: 0 stop:)
				(gKqMusic1 fade:)
				(= local11 20)
				(= local14 9)
				(= ticks 240)
			)
			(202
				(gCurRoom newRoom: 2450)
			)
		)
	)
)

(instance rightBowlF of Feature
	(properties
		noun 6
		sightAngle 90
		approachX 128
		approachY 104
		x 138
		y 88
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					name: {Polygon}
					type: PTotalAccess
					init: 133 55 134 63 142 62 142 54
					yourself:
				)
		)
		(if
			(and
				(not (gEgo has: 33)) ; Bowl_b
				(not (gCast contains: rightBowl))
				(not (IsFlag 382))
			)
			(rightBowl init:)
		)
		(if
			(and
				(not (IsFlag 57))
				(not (gEgo has: 33)) ; Bowl_b
				(not (IsFlag 382))
			)
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
		else
			(self setHotspot: 0 95 approachVerbs: 95) ; Bowl_b, Bowl_b
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			(local12
				(super doVerb: theVerb)
			)
			((and (gCast contains: rightBowl) (gEgo has: 24)) ; Bowl_a
				(gMessager say: 7 8 6 1) ; "I already have a gold bowl. I shouldn't be greedy."
			)
			((and (gEgo has: 33) (== theVerb 95)) ; Bowl_b, Bowl_b
				(gCurRoom setScript: putBackRightBowl 0 self)
			)
			((gCast contains: rightBowl)
				(self setHotspot: 0 95 approachVerbs: 95) ; Bowl_b, Bowl_b
				(gCurRoom setScript: sGetRightBowl)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGetLeftBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo
					setLoop: 8 1
					setLooper: 0
					looper: 0
					setCycle: 0
					cel: 6
					heading: 45
				)
				(= ticks local116)
			)
			(1
				(gEgo view: 8765 setLoop: 0 1 setCycle: 0 cel: 0)
				(= ticks local116)
			)
			(2
				(gEgo setCycle: CT 7 1 self)
			)
			(3
				(leftBowl setPri: (+ (gEgo priority:) 1) x: 123 y: 3)
				(= ticks local116)
			)
			(4
				(gEgo setCycle: CT 9 1 self)
			)
			(5
				(leftBowl x: 123 y: 3)
				(gEgo cel: 10)
				(= ticks local116)
			)
			(6
				(leftBowl x: 112 y: 4)
				(gEgo cel: 11)
				(= ticks local116)
			)
			(7
				(leftBowl x: 118 y: 4)
				(gEgo cel: 12)
				(= ticks local116)
			)
			(8
				(gEgo setCycle: End self)
				(leftBowl dispose:)
			)
			(9
				(if (not (IsFlag 554))
					(SetFlag 554)
					(sfx number: 12 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(gEgo get: 24 1) ; Bowl_a
				(SetFlag 52)
				(if (IsFlag 93)
					(SetFlag 68)
				else
					(ClearFlag 68)
				)
				(gEgo heading: 45 normalize: 6 local4 loop: 8 cel: 6)
				(= ticks local116)
			)
			(10
				(gEgo setHeading: 180 self)
			)
			(11
				(= cycles 2)
			)
			(12
				(gEgo setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self)
			)
			(13
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance putBackRightBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo heading: 45 loop: 8 cel: 6)
				(register setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				(= cycles 2)
			)
			(1
				(gEgo
					view: 8775
					setLoop: 0
					setCycle: 0
					cel: 0
					setSpeed: local115
					x: 131
				)
				(= cycles 2)
			)
			(2
				(gEgo setCycle: CT 7 1 self)
			)
			(3
				(if (IsFlag 68)
					(SetFlag 99)
				else
					(ClearFlag 99)
				)
				(gEgo put: 33) ; Bowl_b
				(rightBowl init:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo x: 128 normalize: 6)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance putBackLeftBowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc98_5)
				(gEgo
					setLoop: 8 1
					setLooper: 0
					looper: 0
					setCycle: 0
					cel: 6
					heading: 45
				)
				(= ticks local116)
			)
			(1
				(gEgo view: 8765 setLoop: 0 1 setCycle: 0 cel: 15)
				(= ticks local116)
			)
			(2
				(gEgo setCycle: CT 9 -1 self)
			)
			(3
				(if (IsFlag 68)
					(SetFlag 93)
				else
					(ClearFlag 93)
				)
				(gEgo put: 24) ; Bowl_a
				(leftBowl setPri: -1 x: 122 y: 4 init:)
				(register setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: 6)
				(proc98_6 1)
				(self dispose:)
			)
		)
	)
)

(instance sRatCartoon of Script
	(properties)

	(method (changeState newState)
		(if (IsFlag 539)
			(sfx setLoop: 1 stop:)
			(sfx2 setLoop: 1 stop:)
			(gCurRoom setScript: sCleanUp 0 self)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(proc98_5 1)
					(proc98_4 140 2513 2512 2510 2511 823 815 25091 25090)
					(proc98_4 128 25013 2505 2506)
					(= local10 9999)
					(= local13 19)
					(= local14 11)
					(= local11 16)
					(gEgo
						view: 25013
						setLoop: 1
						cel: 0
						x: 40
						y: 97
						setPri: 65
					)
					(= cycles 2)
				)
				(1
					(gEgo setCycle: CT 4 1 self)
					(= register 4)
				)
				(2
					(gEgo cel: 5)
					(= ticks local116)
				)
				(3
					(gEgo setCycle: CT 8 1 self)
					(sfx number: 815 setLoop: 1 loop: 1 play: setVol: 127)
				)
				(4
					(if (-- register)
						(-= state 3)
					)
					(= ticks local116)
				)
				(5
					(gEgo setCycle: End self)
				)
				(6
					(= ticks local116)
				)
				(7
					(sfx stop:)
					(proc98_3 140 815)
					(gEgo setLoop: 0 cel: 0 x: 39 y: 97)
					(= register 0)
					(= ticks local116)
				)
				(8
					(if (not register)
						(sfx2
							number: 25091
							setLoop: 1
							loop: 1
							play:
							setVol: 127
						)
					)
					(if (<= (++ register) 2)
						(gEgo cel: register)
						(-- state)
					)
					(UpdateScreenItem gEgo)
					(= ticks local116)
				)
				(9
					(rat init: x: 85 y: 103)
					(gEgo cel: 3)
					(= register 0)
					(= cycles 2)
				)
				(10
					(sfx2 stop:)
					(sfx number: 25090 setLoop: -1 loop: -1 play: setVol: 127)
					(rat x: 124 y: 103 cel: 0)
					(= local9 0)
					(= ticks local117)
				)
				(11
					(if (<= (++ local9) 14)
						(rat
							x: [local15 local9]
							y: [local30 local9]
							cel: [local45 local9]
						)
						(if (== local9 13)
							(sfx stop:)
							(sfx2
								number: 25091
								setLoop: 1
								loop: 1
								play:
								setVol: 127
							)
						)
						(-- state)
					else
						(rat x: 180 y: 120 setPri: 130 cel: 3)
					)
					(UpdateScreenItem rat)
					(= ticks local116)
				)
				(12
					(sfx2 stop:)
					(localproc_3)
					(rat z: 1000)
					(cook
						view: 2506
						setPri: 125
						setLoop: 0
						cel: 0
						x: 158
						y: 121
						setScript: 0
					)
					(= local14 9)
					(= local11 7)
					(mumbleFx stop:)
					(= ticks local116)
				)
				(13
					(gMessager say: 1 32 0 1) ; "(STARTLED AND IRRITATED)What's going on? Who's there?"
					(cook cel: 1 setCycle: End self)
				)
				(14
					(cook
						view: 2505
						setLoop: 1 1
						cel: 0
						setPri: 125
						x: 159
						y: 125
					)
					(= ticks 30)
				)
				(15
					(cookMouth
						view: 2505
						setLoop: 21 1
						x: (cook x:)
						y: (cook y:)
						setPri: (+ (cook priority:) 1)
						init:
						setCycle: cookMouthSync gCurRoomNum 1 32 0 2
					)
					(gMessager say: 1 32 0 2 self) ; "(EXCITED)A juicy, tender rat! Just what I need for my stew! C'mere, you little tidbit!"
				)
				(16
					(localproc_3)
					(cook setCycle: End self)
					(= register -1)
				)
				(17
					(if (< (++ register) 13)
						(switch register
							(3
								(sfx
									number: 25090
									setLoop: -1
									loop: -1
									play:
									setVol: 127
								)
							)
							(1
								(sfx2
									number: 25091
									setLoop: 1
									loop: 1
									play:
									setVol: 127
								)
							)
						)
						(cook
							loop: 2
							x: [local60 register]
							y: [local73 register]
							cel: [local86 register]
							priority: [local99 register]
						)
						(UpdateScreenItem cook)
						(-- state)
					)
					(= ticks local114)
				)
				(18
					(cook dispose:)
					(= ticks local116)
				)
				(19
					(if (not (sfx handle:))
						(proc98_8 {ERROR: lost sfx!} -2)
						(sfx
							number: 25090
							setLoop: -1
							loop: -1
							play:
							setVol: 127
						)
					)
					(sfx2 number: 25091 setLoop: 1 loop: 1 play: setVol: 127)
					(= ticks 90)
				)
				(20
					(sfx2 stop:)
					(sfx number: 2511 setLoop: 1 loop: 1 play: setVol: 127)
					(proc98_14)
					(= ticks 60)
				)
				(21
					(sfx number: 2511 setLoop: 1 loop: 1 play: setVol: 127)
					(proc98_15)
					(= ticks 90)
				)
				(22
					(sfx number: 2511 setLoop: 1 loop: 1 play: setVol: 127)
					(proc98_14)
					(= ticks 30)
				)
				(23
					(sfx number: 2511 setLoop: 1 loop: 1 play: setVol: 127)
					(proc98_15)
					(= ticks 30)
				)
				(24
					(sfx fade:)
					(sfx2 number: 2513 setLoop: -1 loop: -1 play: setVol: 127)
					(= ticks 120)
				)
				(25
					(sfx2 setVol: 30)
					(gMessager say: 1 32 0 3 self) ; "(GROGGY, FROM BEHIND THE PANTRY DOOR)Where'd he go?"
				)
				(26
					(sfx2 fade:)
					(= ticks local116)
				)
				(27
					(pantryDoor
						view: 2505
						setLoop: 3 1
						cel: 0
						cycleSpeed: local115
						setCycle: CT 3 1 self
					)
				)
				(28
					(proc98_3 140 2510)
					(= ticks local116)
				)
				(29
					(pantryDoor cel: 4)
					(UpdateScreenItem pantryDoor)
					(sfx2 number: 823 setLoop: 1 loop: 1 play: setVol: 127)
					(FrameOut)
					(= ticks 240)
				)
				(30
					(proc98_3 140 823 2511 2513)
					(pantryDoor cel: 2)
					(= ticks local116)
				)
				(31
					(sfx number: 2512 setLoop: -1 loop: -1 play: setVol: 127)
					(= ticks 90)
				)
				(32
					(rat
						view: 25013
						setLoop: 2
						cel: 2
						x: 303
						y: 93
						z: 0
						setPri: -1
					)
					(= ticks local116)
				)
				(33
					(rat x: 281 y: 111 cel: 2)
					(proc98_3 128 2505)
					(= ticks local116)
				)
				(34
					(pantryDoor view: 2500 setLoop: 2 cel: 0)
					(rat x: 255 y: 124 cel: 2)
					(= ticks local116)
				)
				(35
					(rat x: 236 y: 131 cel: 3)
					(= ticks local116)
				)
				(36
					(rat x: 167 y: 132 cel: 3)
					(= ticks 20)
				)
				(37
					(rat x: 109 y: 124 cel: 4)
					(= ticks 20)
				)
				(38
					(proc98_5 3)
					(sfx number: 25091 setLoop: 1 loop: 1 play: self)
					(gEgo view: 25013 setLoop: 3 cel: 0 setPri: 65)
					(rat
						x: (+ (gEgo x:) 31)
						y: (+ (gEgo y:) 4)
						cel: 4
						setPri: (+ (gEgo priority:) 1)
					)
				)
				(39
					(rat dispose:)
					(gEgo cel: 1)
					(sfx number: 0 stop:)
					(= ticks local116)
				)
				(40
					(proc98_5 2)
					(gKqMusic1 fade:)
					(gEgo cel: 0)
					(= ticks local116)
				)
				(41
					(gEgo setLoop: 0 cel: 3)
					(= ticks local116)
				)
				(42
					(client setScript: sCleanUp 0 self)
					(self dispose:)
				)
			)
		)
	)
)

