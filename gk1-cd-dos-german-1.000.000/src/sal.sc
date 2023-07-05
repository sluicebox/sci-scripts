;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use n013)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	sal 0
	rep 1
	seal 2
	umbrellaStand 3
	coatRack 4
	desk 5
	fileCab 6
	windows 7
	franksDesk 8
	bench 9
	repair 10
	frankCam 11
	chair1 12
	chair2 13
	drummer 14
	mosely 15
	theVendor 16
	useXerox 17
	copier 18
	bullBoard 19
	copyTop 20
	turnUpHeat 21
	folder 22
	grabOriginalVeve 23
	extDoor 24
	leaveStation 25
)

(local
	local0
)

(instance stroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom notify:)
					(client hide:)
				else
					(= seconds (Random 5 10))
				)
			)
			(1
				(if (> (++ local0) 7)
					(= local0 1)
				)
				(self
					setScript:
						(switch local0
							(1 sallyTalkToSarg)
							(2 salDownAroundDesk)
							(3 salTalkToFranky)
							(4 sallyUpAroundDesk)
							(5 sallyOutToRead)
							(6 salTalkToFranky)
							(else sallyDownAroundDesk)
						)
						self
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sallyOutToRead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 236
					setCycle: StopWalk -1
					posn: 328 88
					setMotion: MoveTo 230 93 self
				)
			)
			(1
				(Face sal 230 70 self)
			)
			(2
				(= seconds 5)
			)
			(3
				(sal setMotion: MoveTo 328 88 self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sallyTalkToSarg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 236
					posn: 330 155
					setCycle: StopWalk -1
					setMotion: MoveTo 276 156 self
				)
			)
			(1
				(= seconds 3)
			)
			(2
				(sal setMotion: MoveTo 330 162 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance salTalkToFranky of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 237
					setCycle: StopWalk -1
					posn: 330 170
					setMotion: MoveTo 306 135 self
				)
			)
			(1
				(sal setHeading: 0)
				(= seconds 3)
			)
			(2
				(sal setMotion: MoveTo 330 135 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sallyUpAroundDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 237
					posn: 330 135
					setCycle: StopWalk -1
					setMotion: MoveTo 274 127 self
				)
			)
			(1
				(sal setMotion: MoveTo 270 115 self)
			)
			(2
				(sal setHeading: 90)
				(= seconds 5)
			)
			(3
				(sal setMotion: MoveTo 279 101 self)
			)
			(4
				(sal setMotion: MoveTo 319 84 self)
			)
			(5
				(Face sal 319 60 self)
			)
			(6
				(sal setMotion: MoveTo 330 84 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance salDownAroundDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 237
					posn: 330 84
					setCycle: StopWalk -1
					setMotion: MoveTo 319 90 self
				)
			)
			(1
				(sal setMotion: MoveTo 319 90 self)
			)
			(2
				(sal setMotion: MoveTo 279 101 self)
			)
			(3
				(sal setMotion: MoveTo 270 115 self)
			)
			(4
				(sal setMotion: MoveTo 274 127 self)
			)
			(5
				(sal setMotion: MoveTo 330 135 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sallyDownAroundDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sal
					view: 236
					posn: 330 84
					setCycle: StopWalk -1
					setMotion: MoveTo 319 84 self
				)
			)
			(1
				(sal setMotion: MoveTo 319 84 self)
			)
			(2
				(sal setHeading: 90)
				(= seconds 4)
			)
			(3
				(sal setMotion: MoveTo 279 101 self)
			)
			(4
				(sal setMotion: MoveTo 270 115 self)
			)
			(5
				(sal setMotion: MoveTo 274 127 self)
			)
			(6
				(sal setHeading: 0)
				(= seconds 4)
			)
			(7
				(sal setMotion: MoveTo 330 135 self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance standAndTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pep setLoop: 4 1 setCel: 0 setSpeed: 18 init: posn: 295 86)
				(sal setMotion: MoveTo 312 91 self)
			)
			(1
				(Face sal pep self)
			)
			(2
				(= ticks 30)
			)
			(3
				(pep setCycle: End self)
			)
			(4
				(= seconds 8)
			)
			(5
				(sal setMotion: MoveTo 328 91 self)
			)
			(6
				(pep setCycle: Beg self)
			)
			(7
				(sal setScript: stroll)
			)
		)
	)
)

(instance sal of Actor
	(properties
		noun 25
		x 330
		y 88
		view 237
		yStep 3
		signal 20513
		xStep 7
	)

	(method (init param1)
		(self
			setLooper: Grooper
			setCycle: StopWalk -1
			setScript: (if param1 stroll else standAndTalk)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(if (== view 236)
				(gMessager say: 10 theVerb 0 0) ; "She's not bad."
			else
				(gMessager say: noun theVerb 0 0) ; "A uniformed officer of the N.O.P.D."
			)
		else
			(gMessager say: 10 0 13 0) ; "Gabriel can't do anything with the officer from the front lobby."
		)
	)
)

(instance pep of Actor
	(properties
		noun 25
		view 244
		loop 4
		signal 20513
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(gMessager say: noun theVerb 0 0) ; "A uniformed officer of the N.O.P.D."
		else
			(gMessager say: 10 0 13 0) ; "Gabriel can't do anything with the officer from the front lobby."
		)
	)
)

(instance rep of Actor
	(properties
		x 262
		y 82
		priority 86
		fixPriority 1
		view 2342
		signal 20513
	)

	(method (init)
		(super init: &rest)
		(repCase init:)
		(gCurRoom setScript: repair)
	)
)

(instance repCase of View
	(properties
		noun 29
		x 231
		y 58
		priority 89
		fixPriority 1
		view 2342
		loop 2
		signal 4129
	)
)

(instance repair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rep cycleSpeed: 5 setCel: 0 setLoop: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(Face gEgo rep self)
			)
			(2
				(rep cycleSpeed: 15 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(3
				(rep cycleSpeed: 5 setCel: 0 setLoop: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(4
				(rep
					view: 2342
					setCel: 0
					setLoop: 3 1
					setStep: 5 2
					ignoreActors:
					setCycle: Walk
					setMotion: MoveTo 334 81 self
				)
			)
			(5
				(gGame handsOn:)
				(rep dispose:)
				(self dispose:)
			)
		)
	)
)

(instance seal of Feature
	(properties
		noun 12
		sightAngle 40
		approachX 139
		approachY 109
		approachDist 30
		x 81
		y 122
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 109 103 110 127 117 146 130 147 141 143 144 40 144 31 135 32 122 45 114 66 109
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance umbrellaStand of Feature
	(properties
		noun 4
		nsLeft 72
		nsTop 70
		nsRight 86
		nsBottom 93
		sightAngle 40
		approachX 80
		approachY 95
		approachDist 22
		x 79
		y 81
	)
)

(instance coatRack of Feature
	(properties
		noun 3
		sightAngle 40
		approachX 66
		approachY 93
		approachDist 43
		x 66
		y 59
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 63 83 69 82 67 43 64 37 68 40 69 24 71 24 71 28 74 26 72 32 71 38 76 36 72 44 72 82 75 82 76 86 64 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance desk of Feature
	(properties
		noun 2
		sightAngle 40
		approachX 190
		approachY 145
		approachDist 62
		x 219
		y 131
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 109 220 104 253 122 232 130
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance fileCab of Feature
	(properties
		noun 9
		nsLeft 293
		nsTop 47
		nsRight 319
		nsBottom 84
		sightAngle 40
		approachX 299
		approachY 88
		approachDist 38
		x 306
		y 65
	)
)

(instance windows of Feature
	(properties
		noun 14
		nsLeft 114
		nsTop 22
		nsRight 187
		nsBottom 65
		sightAngle 40
		approachX 153
		approachY 95
		approachDist 55
		x 150
		y 43
	)
)

(instance franksDesk of Feature
	(properties
		noun 16
		sightAngle 40
		approachX 275
		approachY 120
		approachDist 24
		x 299
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 124 282 102 279 101 278 98 310 95 312 89 319 87 319 130 302 132
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bench of Feature
	(properties
		noun 13
		sightAngle 40
		approachX 31
		approachY 137
		approachDist 16
		x 16
		y 134
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 35 144 0 145 1 120 yourself:)
		)
		(super init: &rest)
	)
)

(instance frankCam of View
	(properties
		noun 22
		x 288
		y 124
		z 26
		priority 9
		view 238
		loop 3
	)

	(method (init)
		(super init: &rest)
		(+= nsTop 2)
		(+= nsBottom 1)
		(+= nsRight 2)
		(+= nsLeft 2)
	)
)

(instance chair2 of View
	(properties
		x 307
		y 114
		view 2380
		loop 2
		cel 1
	)
)

(instance chair1 of View
	(properties
		x 262
		y 116
		view 232
		loop 4
	)
)

(instance drummer of Prop
	(properties
		noun 21
		x 183
		y 57
		view 229
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setPri: 1 setCycle: Fwd)
	)

	(method (doVerb theVerb)
		(if (== theVerb 7) ; Look
			(if (IsFlag 51)
				(gMessager say: noun theVerb 62 1) ; "One of the Gedde drummers watches the police station."
			else
				(gMessager say: noun theVerb 63 1) ; "Street musicians abound in the French Quarter. This one's a drummer."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance mosely of Actor
	(properties
		view 245
		signal 24609
		xStep 4
	)
)

(instance theVendor of Actor
	(properties
		noun 20
		x -27
		y 76
		priority 1
		fixPriority 1
		view 231
		signal 26657
		xStep 6
		moveSpeed 0
	)
)

(instance useXerox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 8 48 33 1 self) ; "(TRYING TO PRETEND HE'S NOT DOING SOMETHING WRONG)<whistle>Just wanna check this machine, here."
			)
			(1
				(gEgo
					setCel: 0
					view: 235
					setLoop: 2 1
					setSpeed: 14
					setCycle: Osc 2 self
				)
			)
			(2
				(gEgo
					setCel: 0
					setLoop: 1 1
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(gEgo setCel: 0 setLoop: 2 1 setCycle: Blink 50)
				(= seconds 3)
			)
			(4
				(copyTop
					view: 235
					setCel: 0
					setLoop: 3
					setCycle: ForwardCounter 5 self
				)
				(gGkSound2 number: 233 loop: 1 play:)
			)
			(5
				(copyTop view: 2300 setLoop: 2 setCel: 0)
				(gEgo setCycle: Beg self)
			)
			(6
				(gEgo
					setCel: 6
					setLoop: 1 1
					cycleSpeed: 8
					setCycle: Beg self
				)
			)
			(7
				(gEgo
					get: 15 ; veveCopy
					getPoints: -999 5
					setLoop: 4
					setSpeed: 6
					setCycle: End self
				)
			)
			(8
				(SetFlag 2)
				(gEgo normalize: 5 posn: 228 92)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance copyTop of Prop
	(properties
		sightAngle 40
		approachX 226
		approachY 91
		x 213
		y 57
		priority 88
		fixPriority 1
		view 2300
		loop 2
		signal 2081
		cycleSpeed 8
	)

	(method (handleEvent)
		(if (== (gCurRoom notify:) 2)
			(self approachVerbs: 48) ; policeVeve_
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb)
		(copier doVerb: &rest)
	)
)

(instance copier of Feature
	(properties
		noun 8
		sightAngle 40
		approachX 226
		approachY 91
		x 216
		y 74
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 190 83 190 77 184 76 184 63 189 63 189 56 234 55 244 63 244 85 202 88
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent)
		(if (== (gCurRoom notify:) 2)
			(self approachVerbs: 48) ; policeVeve_
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48 ; policeVeve_
				(cond
					((not (== (gCurRoom notify:) 2))
						(gMessager say: 0 0 13 1) ; "Gabriel can't do that from the front lobby."
					)
					((IsFlag 2)
						(gMessager say: noun theVerb 32 1) ; "Gabriel already copied the file."
					)
					(else
						(gCurRoom setScript: (ScriptID 230 1)) ; goToCopier
					)
				)
			)
			(24 ; veveCopy
				(gMessager say: 1 theVerb 0 0) ; "Gabriel would be wiser not to flaunt that photocopy around here."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bullBoard of Feature
	(properties
		noun 18
		nsLeft 195
		nsTop 22
		nsRight 234
		nsBottom 50
		sightAngle 40
		approachX 224
		approachY 91
		approachDist 68
		x 214
		y 25
	)

	(method (handleEvent)
		(if (== (gCurRoom notify:) 2)
			(self approachVerbs: 7) ; Look
		else
			(self approachVerbs: 0)
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(if (== (gCurRoom notify:) 2)
					(gMessager say: noun 7 12 1) ; "Gabriel scans the bulletin board and sees a lot of bad photographs and worse writing."
				else
					(gMessager say: noun 7 13 1) ; "Gabriel can't read the bulletin board from where he's standing."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance turnUpHeat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Face gEgo 259 80 self)
			)
			(1
				(gMessager say: 19 8 46 1 self) ; "!!!Blank msg"
			)
			(2
				(gEgo
					setCel: 0
					view: 234
					setLoop: 0
					cycleSpeed: 12
					posn: 261 85
					setPri: 91
					setCycle: CT 4 1 self
				)
			)
			(3
				(gGame handsOn:)
				((ScriptID 235 0) init: self gCurRoom 1) ; thermoInset
			)
			(4
				(gGame handsOff:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo normalize:)
				(= cycles 4)
			)
			(6
				(gEgo setMotion: PolyPath 261 88 self)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance folder of View
	(properties
		x 301
		y 98
		priority 130
		fixPriority 1
		view 2350
	)
)

(instance grabOriginalVeve of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 267 115 self)
			)
			(1
				(gEgo setMotion: MoveTo 276 120 self)
			)
			(2
				(= cycles 4)
			)
			(3
				(gEgo
					setCel: 5
					view: 235
					setLoop: 0
					setPri: 135
					setCycle: CT 3 -1 self
				)
			)
			(4
				(gEgo setCycle: Beg self)
				(folder dispose:)
				(gMessager say: 15 12 register 0 self)
			)
			(5
				(gEgo normalize: 6 setMotion: MoveTo 267 115 self)
			)
			(6
				(gGame handsOn:)
				(gEgo get: 16) ; policeVeve
				(self dispose:)
			)
		)
	)
)

(instance extDoor of Prop
	(properties
		noun 5
		sightAngle 40
		approachX 15
		approachY 91
		x 41
		y 79
		view 2300
		signal 16417
		cycleSpeed 8
	)

	(method (handleEvent)
		(if (== (gCurRoom notify:) 2)
			(self approachVerbs:)
		else
			(self approachVerbs: 6 8) ; Open, Operate
		)
		(super handleEvent: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 8) ; Open, Operate
			(if (== (gCurRoom notify:) 2)
				(self setScript: (ScriptID 230 2)) ; sExitDoorFromOffice
			else
				(gCurRoom setScript: leaveStation)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance leaveStation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCel: 0
					view: 233
					setLoop: 5
					cel: 0
					setCycle: CT 4 1 self
				)
				(gGkSound1 number: 373 loop: 1 play:)
				(extDoor setCycle: CT 4 1 self)
			)
			(1 1)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(if (gEgo has: 16) ; policeVeve
					(SetFlag 3)
				)
				(ClearFlag 34)
				(ClearFlag 20)
				(gEgo setLoop: -1)
				(ClearFlag 97)
				(ClearFlag 98)
				(gGkMusic1 fade:)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

