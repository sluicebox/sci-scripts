;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Garbage)
(use Scaler)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm200 0
)

(local
	local0 = 7
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0 param1 &tmp temp0)
	((= temp0 (Prop new:))
		view: 70
		posn: (orpheus x:) (orpheus y:)
		setLoop: 8
		setCel: 0
		cycleSpeed: (orpheus cycleSpeed:)
		init:
		setScript: (ripScript new:) param1 (orpheus cel:)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	((= temp0 (Prop new:))
		view: 71
		posn: (morpheus x:) (morpheus y:)
		setLoop: 8
		setCel: 0
		cycleSpeed: (morpheus cycleSpeed:)
		init:
		setScript: (ripScript new:) param1 (morpheus cel:)
	)
)

(instance rm200 of Eco2Room
	(properties
		noun 17
		picture 200
		style 10
		east 220
	)

	(method (init)
		(if (== gPrevRoomNum 220)
			(exiteast init:)
			(= style 11)
		)
		(= local2 (OneOf gPrevRoomNum 100 160))
		(bottle init:)
		(garbage init:)
		(can init:)
		(garbage2 init:)
		(garbage3 init:)
		(roots init:)
		(mudwater init:)
		(if (or (< (MemoryInfo 4) 17000) (< gHowFast 3)) ; TotalHunk
			(mudwater addToPic:)
		)
		(thickTrunk init: setOnMeCheck: 1 8192)
		(foliage init: setOnMeCheck: 1 4096)
		(thinTrunk init: setOnMeCheck: 1 16384)
		(floor init: setOnMeCheck: 1 256)
		(leaves init: setOnMeCheck: 1 512)
		(understory init: setOnMeCheck: 1 1024)
		(canopy init: setOnMeCheck: 1 64)
		(if (not (gEgo has: 6))
			(stickyLeaf init:)
		)
		(sapDrip init:)
		(puddle init:)
		(dripPlant init: setOnMeCheck: 1 2048)
		(gEgo
			illegalBits: 0
			scaleSignal: (| (gEgo scaleSignal:) $0004)
			setStep: 3 2
		)
		(if local2
			(LoadMany rsVIEW 204 201 15 70 71 202 80)
			(gWalkHandler add: self mudwater)
			(gKeyDownHandler add: self)
			(gMouseDownHandler add: self)
			(self setScript: youOtterBeInPictures)
		else
			(gGame handsOn:)
			(= local1 1)
			(gEgo
				init:
				actions: (ScriptID 299 3) ; egoActions
				normalize: 0
				setScale: Scaler 100 80 185 90
			)
			(canoe detailLevel: 3 init:)
			(sapDrip setScript: dripper)
			(antsMarch init: setCycle: Fwd)
		)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 55 113 116 113 171 142 157 165 319 187 319 189 0 189 0 0 319 0 319 100 309 100 237 126 224 139 199 139 192 127 177 134 164 134 163 120 145 122 147 113 160 103 127 103 111 109 100 111 88 104 60 107 37 102 37 107
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 4 3) (not local1) (not script)) ; Do, Walk
			(gMessager say: noun theVerb 12)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance sFX2 of Sound
	(properties)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 101
		nsLeft 311
		nsBottom 188
		nsRight 319
		cursor 11
		exitDir 2
	)

	(method (doit)
		(if (OneOf (gTheCursor cel:) cursor 0)
			(super doit: &rest)
		)
	)
)

(instance roots of Feature
	(properties
		x 39
		y 114
		noun 1
		approachX 39
		approachY 114
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 1 96 37 94 50 106 69 113 80 123 48 129 11 124
					yourself:
				)
		)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (not (IsEcorderFlag 1))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (onMe param1)
		(if (super onMe: param1 &rest)
			(if
				(or
					(understory onMe: param1 &rest)
					(orpheus onMe: param1 &rest)
				)
				(return 0)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 1))
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance thinTrunk of Feature
	(properties
		x 21
		y 44
		noun 6
		onMeCheck 16384
	)
)

(instance thickTrunk of Feature
	(properties
		x 72
		y 57
		noun 4
		onMeCheck 8192
	)
)

(instance foliage of Feature
	(properties
		x 240
		y 171
		noun 5
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 4 3) (not local1)) ; Do, Walk
			(gMessager say: 17 theVerb 12)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance understory of Feature
	(properties
		x 170
		y 90
		noun 17
		onMeCheck 1024
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 3))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 3))
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance floor of Feature
	(properties
		x 241
		y 101
		noun 7
		onMeCheck 256
	)

	(method (init)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 2))
			(if (and (OneOf theVerb 4 3) (not local1)) ; Do, Walk
				(gMessager say: 17 theVerb 12)
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 2))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (onMe param1 &tmp temp0)
		(if (super onMe: param1 &rest)
			(if (IsObject param1)
				(= x (param1 x:))
				(= y (param1 y:))
			else
				(= temp0 [param1 1])
				(if
					(or
						(bottle onMe: param1 temp0)
						(garbage onMe: param1 temp0)
						(can onMe: param1 temp0)
						(garbage2 onMe: param1 temp0)
						(garbage3 onMe: param1 temp0)
					)
					(return 0)
				)
			)
			(return 1)
		)
		(return 0)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)
)

(instance leaves of Feature
	(properties
		x 24
		y 159
		noun 11
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 4 3) (not local1)) ; Do, Walk
			(gMessager say: 17 theVerb 12)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance canopy of Feature
	(properties
		x 159
		y 5
		noun 18
		onMeCheck 64
	)
)

(instance dripPlant of Feature
	(properties
		x 209
		y 125
		noun 21
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 4 3) (not local1)) ; Do, Walk
			(gMessager say: noun theVerb 12)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance canoe of Actor
	(properties
		x 91
		y 132
		noun 3
		approachX 154
		approachY 140
		view 208
		loop 2
		priority 13
		signal 20497
		cycleSpeed 12
	)

	(method (init)
		(if local1
			(self setCycle: Fwd)
		)
		(super init: &rest)
	)
)

(instance morpheus of Actor
	(properties
		x -49
		y 232
		noun 15
		view 71
		loop 3
		signal 18432
		scaleSignal 5
		scaleX 117
		scaleY 117
		cycleSpeed 10
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 20))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (self perform: gWriteEcorderData theVerb 20))
			(if (OneOf theVerb 1 2 4) ; Look, Talk, Do
				(gMessager say: noun theVerb local0)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance orpheus of Actor
	(properties
		x -62
		y 225
		noun 14
		view 70
		loop 3
		signal 18432
		scaleSignal 5
		scaleX 116
		scaleY 116
		cycleSpeed 10
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 20))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 55) (== local0 7) (IsEcorderFlag 20) (not (IsEcorderFlag 1))) ; E-corder
				(roots doVerb: theVerb)
			)
			((not (self perform: gWriteEcorderData theVerb 20))
				(switch theVerb
					(2 ; Talk
						(switch local0
							(7
								(self setScript: firstTalk)
							)
							(3
								(self setScript: nextTalk)
							)
							(else
								(gMessager say: 14 2 11) ; "I'm waiting, but you're making me nervous."
							)
						)
					)
					(1 ; Look
						(gMessager say: noun theVerb local0)
					)
					(4 ; Do
						(if (OneOf local0 7 3)
							(gMessager say: noun theVerb local0)
						else
							(self setScript: getAmulet)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance bottle of Garbage
	(properties
		x 230
		y 145
		view 200
	)
)

(instance garbage of Garbage
	(properties
		x 129
		y 107
		view 200
		cel 2
		flag 1
	)
)

(instance can of Garbage
	(properties
		x 282
		y 112
		view 200
		cel 4
		flag 2
	)
)

(instance garbage2 of Garbage
	(properties
		x 200
		y 151
		view 200
		cel 1
		flag 3
	)
)

(instance garbage3 of Garbage
	(properties
		x 141
		y 107
		view 200
		cel 3
		flag 11
	)
)

(instance sapDrip of Prop
	(properties
		x 198
		y 112
		noun 9
		view 200
		loop 5
		signal 16384
		cycleSpeed 12
	)

	(method (init)
		(if (gCast contains: stickyLeaf)
			(self approachX: 212 approachY: 141 approachVerbs: 4) ; Do
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (gCast contains: stickyLeaf)) ; Do
			(stickyLeaf doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance puddle of Prop
	(properties
		x 210
		y 136
		noun 9
		view 200
		loop 6
		priority 10
		signal 16400
		cycleSpeed 12
	)

	(method (init)
		(if (gCast contains: stickyLeaf)
			(self approachX: 212 approachY: 141 approachVerbs: 4) ; Do
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (gCast contains: stickyLeaf)) ; Do
			(stickyLeaf doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance stickyLeaf of View
	(properties
		x 217
		y 138
		noun 10
		view 200
		loop 4
		priority 11
		signal 16401
	)

	(method (init)
		(self approachX: (- x 5) approachY: (+ y 3) approachVerbs: 4) ; Do
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local1
				(gEgo setScript: getLeaf)
			else
				(gMessager say: noun theVerb 12) ; "Adam can't reach that from here."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mudwater of Prop
	(properties
		x 84
		y 121
		noun 2
		view 207
		loop 2
		priority 1
		signal 20496
		cycleSpeed 12
		detailLevel 4
	)

	(method (init)
		(if (>= gHowFast 2)
			(self setCycle: Fwd)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (and (OneOf theVerb 4 3) (not local1)) ; Do, Walk
			(gCurRoom setScript: fishJump 0 (Random 0 1))
		else
			(super doVerb: theVerb)
		)
	)
)

(instance antsMarch of Prop
	(properties
		x 177
		y 106
		noun 8
		view 200
		loop 2
		priority 11
		signal 16401
		cycleSpeed 18
	)

	(method (doit)
		(super doit: &rest)
		(if (not (IsEcorderFlag 21))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 21))
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fishJump of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= local3 (Prop new:))
					view: 204
					loop: (if register 0 else 1)
					cel: 0
					x: (if register 10 else 145)
					y: (if register 170 else 125)
					init:
					cycleSpeed: 3
					setCycle: CT 6 1 self
				)
				(sFX number: 212 loop: 1 play:)
			)
			(1
				(sFX2 number: 213 loop: 1 play:)
				(local3 setCycle: End self)
			)
			(2
				(local3 dispose:)
				(= ticks 12)
			)
			(3
				(gMessager say: 2 4 12 0 self) ; "Yikes! A piranha! Now those are teeth!"
			)
			(4
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance youOtterBeInPictures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(canoe
					setLoop: 2
					posn: -53 193
					setStep: 2 1
					init:
					setCycle: Fwd
				)
				(gEgo
					view: 15
					setLoop: 1
					setCel: 255
					x: (+ (canoe x:) 27)
					y: (+ (canoe y:) 11)
					setStep: 2 1
					setPri: (canoe priority:)
					setScale: 0
					setSpeed: 6
					ignoreActors: 1
					init:
				)
				(orpheus
					x: (+ (canoe x:) 14)
					y: (+ (canoe y:) 38)
					setStep: 2 1
					setPri: (canoe priority:)
					init:
				)
				(morpheus
					x: (- (canoe x:) 16)
					y: (+ (canoe y:) 29)
					setStep: 2 1
					setPri: (- (canoe priority:) 1)
					init:
				)
				(= seconds 2)
			)
			(1
				(gGameSound2 number: 201 loop: -1 play: 127)
				(orpheus
					setCycle: Fwd
					setMotion: MoveTo (+ (orpheus x:) 114) (+ (orpheus y:) -55)
				)
				(morpheus
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ (morpheus x:) 114)
						(+ (morpheus y:) -55)
				)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 114) (+ (gEgo y:) -55)
				)
				(canoe
					setMotion: MoveTo (+ (canoe x:) 114) (+ (canoe y:) -55) self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(canoe detailLevel: 3 checkDetail:)
				(orpheus
					setCycle: Rev
					setMotion: MoveTo (- (orpheus x:) 16) (+ (orpheus y:) 12)
				)
				(morpheus
					setCycle: Rev
					setMotion:
						MoveTo
						(- (morpheus x:) 16)
						(+ (morpheus y:) 12)
						self
				)
			)
			(4
				(orpheus
					setLoop: 7
					setCel: 0
					setMotion: MoveTo (+ (orpheus x:) 6) (orpheus y:)
					setCycle: End
				)
				(morpheus
					setLoop: 7
					setCel: 0
					setMotion: MoveTo (+ (morpheus x:) 6) (morpheus y:)
					setCycle: End self
				)
			)
			(5
				(orpheus setLoop: 0 setCycle: Fwd)
				(morpheus setLoop: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(6
				((ScriptID 1078) setupTalker: 2) ; Orpheus
				(gMessager say: 17 0 4 0 self) ; "(COMPLAINING) Ow! I SAID steer to the left."
			)
			(7
				(orpheus
					setStep: 3 2
					setMotion: MoveTo (- (orpheus x:) 60) (+ (orpheus y:) 45)
				)
				(morpheus
					setStep: 3 2
					setMotion:
						MoveTo
						(- (morpheus x:) 60)
						(+ (morpheus y:) 45)
						self
				)
			)
			(8
				(orpheus dispose:)
				(morpheus dispose:)
				(ScriptID 201) ; eyesScr
				(PalVary pvINIT 200 6)
				(gGameSound1 fade: 50 25 4 0)
				(gGameSound2 fade: 65 25 4 0)
				(sFX number: 214 loop: -1 play: 90 fade: 127 25 4 0)
				(= ticks 300)
			)
			(9
				(self setScript: (ScriptID 201) self) ; eyesScr
			)
			(10
				(PalVary pvREVERSE 5)
				(= seconds 4)
				(gGameSound1 fade: 127 20 4 0)
				(gGameSound2 fade: 127 20 4 0)
				(sFX fade:)
			)
			(11
				((= local4 (Actor new:))
					view: 80
					setLoop: 3
					setCel: 4
					posn: 110 -2
					ignoreActors: 1
					ignoreHorizon:
					init:
					setStep: 10 20
					setMotion: MoveTo 101 52 self
				)
			)
			(12
				(local4 setCycle: Fwd)
				(= seconds 5)
			)
			(13
				(local4 setCycle: End self)
			)
			(14
				(local4 setLoop: 2 setCel: 0 posn: 106 72)
				(= ticks 10)
			)
			(15
				(if (< (local4 cel:) 3)
					(local4 setCel: (+ (local4 cel:) 1) y: (+ (local4 y:) 14))
					(-- state)
					(= ticks 10)
				else
					(= seconds 2)
				)
			)
			(16
				(gEgo setCycle: CT (- (gEgo cel:) 2) -1)
				(local4 setLoop: 1 setCel: 0 setCycle: End self)
				((= register (Sound new:)) number: 205 loop: 1 play:)
			)
			(17
				(local4 setLoop: 1 setCel: 0 setCycle: End self)
				(register play:)
			)
			(18
				(local4 setLoop: 7 setCel: 2 setCycle: Beg self)
				(register stop:)
			)
			(19
				(local4
					setLoop: 4
					setStep: 16 8
					setCycle: Walk
					setMotion: MoveTo 330 115 self
				)
				(= register 0)
				(= ticks 60)
			)
			(20
				(gEgo setCycle: End)
			)
			(21
				(local4 dispose:)
				(= seconds 2)
			)
			(22
				(DisposeScript 201)
				((= local3 (Prop new:))
					view: 204
					loop: 3
					cel: 0
					posn: 132 147
					scaleSignal: 1
					scaleX: 95
					scaleY: 95
					ignoreActors: 1
					init:
					setCycle: CT 6 1 self
				)
				(sFX number: 212 loop: 1 play:)
			)
			(23
				(sFX2 number: 215 loop: 1 play:)
				(local3 setCycle: End self)
				(gEgo setCycle: CT 3 -1)
			)
			(24
				(local3 dispose:)
				(= seconds 2)
			)
			(25
				(orpheus posn: 93 176 setLoop: 5 setCel: 0 cycleSpeed: 10 init:)
				(morpheus
					posn: 55 178
					setLoop: 6
					setCel: 0
					cycleSpeed: 10
					init:
				)
				(gEgo setCycle: Beg self)
			)
			(26
				(morpheus setCycle: End)
				(localproc_1 self)
			)
			(27
				(gEgo
					setLoop: 2
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 5 1 self
				)
				(= register 6)
			)
			(28
				(if (not (-- register))
					(gEgo setCycle: End self)
				else
					(gEgo setCel: (if (== (gEgo cel:) 4) 5 else 4))
					(-= state 1)
					(= ticks (Max (gEgo cycleSpeed:) 1))
				)
			)
			(29
				((= register (Sound new:)) number: 216 loop: 1 play:)
				(orpheus setCycle: End)
				(localproc_0 self)
			)
			(30
				(gEgo setCel: 3 setCycle: Beg self)
			)
			(31
				(gEgo view: 201 setLoop: 4)
				(= ticks 12)
			)
			(32
				(gMessager say: 17 0 6 0 self) ; "Where am I?"
			)
			(33
				(orpheus setCycle: Beg)
				(localproc_0 self)
			)
			(34
				(= seconds 4)
			)
			(35
				(orpheus setLoop: 6 setPri: -1 posn: 52 122 setCycle: End)
				(localproc_0 self)
			)
			(36
				(gMessager say: 17 0 5 0 self) ; "(DISGUSTED) Honestly! I can see I have to do the hard part, like always. (CLEARS THROAT)"
			)
			(37
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance firstTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 1)
				(gEgo view: 201 setLoop: 4 setCel: 0 setCycle: CT 2 1 self)
			)
			(1
				(= ticks (Max (gEgo cycleSpeed:) 1))
			)
			(2
				(gMessager say: 14 2 7 0 self) ; "(SOFTLY)Won't you please come out, Orpheus? I'm sorry I spoke so loud..."
			)
			(3
				(orpheus setCycle: Beg)
				(localproc_0 self)
			)
			(4
				(gEgo setCel: 1)
				(= seconds 4)
			)
			(5
				(orpheus posn: 43 144 setCel: 0 cycleSpeed: 10 setCycle: End)
				(localproc_0 self)
			)
			(6
				(gEgo setCel: 0)
				(= local0 3)
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance nextTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 1)
				(gEgo setCel: 1)
				(= ticks (Max (gEgo cycleSpeed:) 1))
			)
			(1
				(gMessager say: 14 2 3 0 self) ; "Won't you please give me what, er, Forest Heart sent?"
			)
			(2
				(orpheus setCycle: Beg)
				(localproc_0 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo setCel: 0)
				(orpheus
					posn: (+ (gEgo x:) 41) (+ (gEgo y:) 13)
					setLoop: 5
					setCycle: End
				)
				(localproc_0 self)
			)
			(5
				(gEgo view: 201 setLoop: 3 setCel: 1)
				(orpheus view: 202 setLoop: 0 setCel: 0 setCycle: CT 3 1 self)
			)
			(6
				(= local0 11)
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance getAmulet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 14 4 11 0 self) ; "Adam bends over and gently takes a necklace from Orpheus's neck."
			)
			(1
				(orpheus setCel: 4)
				(gEgo view: 201 cycleSpeed: 10 setCycle: CT 3 1 self)
			)
			(2
				(= ticks 10)
			)
			(3
				(gGame points: 5)
				(orpheus setCel: 5)
				(gEgo setCel: 4)
				(= ticks 20)
			)
			(4
				(gEgo setCycle: CT 7 1)
				(orpheus setCycle: End self)
			)
			(5
				(orpheus view: 70 setLoop: 5 setCel: 255)
				(= ticks 12)
			)
			(6
				((= local5 (View new:))
					view: 203
					loop: 0
					cel: 0
					posn: 146 20
					setPri: 15
					init:
				)
				(canoe setCycle: 0)
				(mudwater setCycle: 0)
				(gGameSound2 pause: 1)
				(sFX number: 210 loop: 1 play: self)
			)
			(7
				(local5 dispose:)
				(= cycles 2)
			)
			(8
				(canoe setCycle: Fwd)
				(mudwater setCycle: Fwd)
				(gGameSound2 pause: 0)
				(= ticks 60)
			)
			(9
				(gMessager say: 17 0 8 0 self) ; "It's beautiful, but why are you giving it to me?"
			)
			(10
				(gEgo setCycle: End)
				(= ticks (* (Max (gEgo cycleSpeed:) 1) 2))
			)
			(11
				(gEgo get: 3 setLoop: 4 setCel: 0) ; amulet
				(= ticks (* (gEgo cycleSpeed:) 2))
			)
			(12
				(orpheus setCycle: Beg)
				(localproc_0 self)
			)
			(13
				(localproc_1 self)
				(morpheus setCycle: Beg)
			)
			(14
				(= seconds 3)
			)
			(15
				(orpheus
					posn: 65 188
					setLoop: 9
					setCel: 255
					cycleSpeed: 16
					setCycle: Beg
				)
				(morpheus
					posn: 35 179
					setLoop: 9
					setCel: 255
					cycleSpeed: 16
					setCycle: Beg self
				)
			)
			(16
				(orpheus setLoop: 2 cycleSpeed: 10 setCycle: End)
				(morpheus setLoop: 2 cycleSpeed: 10 setCycle: End self)
			)
			(17
				(orpheus setLoop: 3 setCycle: Fwd setMotion: MoveTo 73 178)
				(morpheus
					setLoop: 3
					setCycle: Fwd
					setMotion: MoveTo 43 169 self
				)
			)
			(18
				(canoe
					detailLevel: 0
					checkDetail:
					setMotion: MoveTo (+ (canoe x:) 30) (- (canoe y:) 6) self
				)
				(orpheus
					setMotion: MoveTo (+ (orpheus x:) 30) (- (orpheus y:) 6)
				)
				(morpheus
					setMotion: MoveTo (+ (morpheus x:) 30) (- (morpheus y:) 6)
				)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 30) (- (gEgo y:) 6)
					moveSpeed: (canoe moveSpeed:)
					xStep: (canoe xStep:)
					yStep: (canoe yStep:)
				)
			)
			(19
				(gEgo setLoop: 4 setCel: 0 setCycle: CT 8 1 self)
			)
			(20
				(= ticks 8)
			)
			(21
				(gEgo cel: 9 posn: (- (gEgo x:) 2) (- (gEgo y:) 4))
				(= ticks 8)
			)
			(22
				(gEgo hide:)
				(canoe view: 201 setLoop: 1 setCel: 0)
				(= ticks 60)
			)
			(23
				(canoe setCycle: End self)
			)
			(24
				(canoe
					view: 208
					setLoop: 2
					detailLevel: 3
					checkDetail:
					setCycle: Fwd
				)
				(gEgo
					setLoop: 6
					posn: (+ (canoe x:) 78) (+ (canoe y:) 9)
					normalize: 0
					setScale: Scaler 100 80 185 90
					show:
				)
				(orpheus
					setCycle: Rev
					setMotion: MoveTo (- (orpheus x:) 16) (+ (orpheus y:) 12)
				)
				(morpheus
					setCycle: Rev
					setMotion:
						MoveTo
						(- (morpheus x:) 16)
						(+ (morpheus y:) 12)
						self
				)
			)
			(25
				(gEgo setHeading: 225)
				(orpheus
					setLoop: 7
					setCel: 0
					setMotion: MoveTo (+ (orpheus x:) 6) (orpheus y:)
					setCycle: End
				)
				(morpheus
					setLoop: 7
					setCel: 0
					setMotion: MoveTo (+ (morpheus x:) 6) (morpheus y:)
					setCycle: End self
				)
			)
			(26
				(orpheus setLoop: 0 setCycle: Fwd)
				(morpheus setLoop: 0 setCycle: Fwd)
				(= seconds 2)
			)
			(27
				(orpheus
					setMotion: MoveTo (- (orpheus x:) 40) (+ (orpheus y:) 40)
				)
				(morpheus
					setMotion:
						MoveTo
						(- (morpheus x:) 40)
						(+ (morpheus y:) 40)
						self
				)
				(= ticks 30)
			)
			(28
				(gMessager say: 17 0 9 0) ; "Hey, wait! Stop!"
			)
			(29
				(gEgo setHeading: 180 self)
			)
			(30
				(= ticks 6)
			)
			(31
				(gMessager say: 17 0 10 0 self) ; "Oh, great. What now, I wonder?"
			)
			(32
				(exiteast init:)
				(antsMarch init: setCycle: Fwd)
				(sapDrip setScript: dripper)
				(gGame handsOn:)
				(gGameSound2 fade:)
				(= local1 1)
				(gWalkHandler delete: rm200 mudwater)
				(gKeyDownHandler delete: rm200)
				(gMouseDownHandler delete: rm200)
				(morpheus dispose:)
				(orpheus dispose:)
			)
		)
	)
)

(instance ripScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT (if register 6 else 3) 1 self)
			)
			(1
				(client setCycle: End self)
				(sFX number: 211 loop: 1 play:)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance getLeaf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 5 setLoop: 3 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gMessager say: 10 4 0 0 self) ; "Adam takes the sticky leaf and puts it away."
			)
			(3
				(gGame points: 5)
				(gEgo setCycle: Beg self)
				(stickyLeaf dispose:)
			)
			(4
				(gGame handsOn:)
				(gEgo normalize: 0 get: 6)
				(sapDrip approachVerbs: 0)
				(puddle approachVerbs: 0)
				(self dispose:)
			)
		)
	)
)

(instance dripper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCel: 0 setCycle: CT 5 1 self)
			)
			(1
				(puddle setCel: 0 setCycle: End self)
				(client setCycle: End)
			)
			(2
				(= seconds (Random 3 8))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

