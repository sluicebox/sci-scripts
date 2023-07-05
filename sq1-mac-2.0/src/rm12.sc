;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Interface)
(use arcadaRegion)
(use eRS)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm12 0
)

(instance rm12 of SQRoom
	(properties
		lookStr {This is the cavernous Vehicle Bay. An escape pod rests on launch rails at the end of the platform. Bay doors at the end of the rails allow access to the emptiness beyond.}
		picture 12
		west 11
	)

	(method (init)
		(LoadMany rsVIEW 11 1 17 112)
		(Load rsSOUND 363)
		(self setRegions: 700) ; arcadaRegion
		(super init:)
		(gEgo init:)
		(if (proc700_1 556 1)
			(buttons setCycle: Fwd)
			(motors setCycle: Fwd)
		)
		(buttons init: stopUpd:)
		(motors init: stopUpd:)
		(if (not (IsFlag 10))
			(bayDoors init:)
		else
			(stars setCycle: Fwd init:)
		)
		(if (> global172 30)
			(tv init:)
			(if (>= (gGame detailLevel:) (tv detailLevel:))
				(tv setScript: tvScript)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PTotalAccess
					init: 0 176 32 176 111 162 186 119 180 117 214 92 209 90 175 115 151 104 89 132 12 142 0 142 0 0 319 0 319 189 0 189
					yourself:
				)
		)
		(gFeatures add: monitorFeat podFeat eachElementDo: #init)
		(if (IsFlag 10)
			(gFeatures add: bayDoorFeat spaceFeat eachElementDo: #init)
		)
		(podDoor init: approachVerbs: 3 2) ; Do, Look
		(switch gPrevRoomNum
			(13
				(podDoor cel: 0)
				(self setScript: exitPod)
				(gEgo view: 11 posn: 179 123 setPri: 0 loop: 2 cel: 0 hide:)
			)
			(11
				(if (not (IsFlag 16))
					(gEgo cel: 0 posn: 18 169 view: 11 normal: 0)
					(self setScript: explode)
				else
					(gEgo illegalBits: -32768 posn: 16 157)
					(HandsOn)
				)
			)
			(else
				(gEgo view: 1 posn: 16 157)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (= temp0 (gEgo onControl: 1)) $0004)
				(self setScript: fallingScript)
			)
			((& temp0 $0002)
				(self
					setScript:
						fallingScript
						0
						(if (>= (gEgo x:) 87) 7 else 6)
				)
			)
		)
		(super doit:)
	)
)

(instance tvScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(tv setCycle: Beg self)
			)
			(1
				(= seconds (Random 2 5))
			)
			(2
				(tv setCycle: Fwd)
				(= seconds (Random 1 4))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance fallingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					illegalBits: 0
					view: 17
					loop: register
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setPri: (if register 3 else -1) setCycle: End self)
			)
			(2
				(gSoundEffects number: 363 loop: 1 play: self)
				(gEgo
					setLoop: (+ (gEgo loop:) 2)
					setCycle: Fwd
					setStep: 3 13
					setMotion: MoveTo (gEgo x:) 250
				)
			)
			(3
				(= register 0)
				(EgoDead 939 0 0 12 0) ; "Does that artificial gravity do the job, or what."
				(self dispose:)
			)
		)
	)
)

(instance enterPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(podDoor setPri: 7)
				(gEgo
					illegalBits: 0
					view: 11
					loop: 1
					setPri: 0
					cel: 0
					setCycle: End self
				)
			)
			(1
				(gEgo hide:)
				(gSoundEffects number: 324 loop: 1 play:)
				(podDoor setCycle: Beg self)
			)
			(2
				(gSoundEffects number: 369 loop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance exitPod of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0)
				(= cycles 3)
			)
			(1
				(gSoundEffects number: 324 loop: 1 play:)
				(podDoor setCycle: End self)
			)
			(2
				(gSoundEffects stop:)
				(gEgo show: setPri: 0 cycleSpeed: 12 setCycle: CT 6 1 self)
			)
			(3
				(gEgo setPri: -1 setCycle: End self)
			)
			(4
				(NormalEgo 1 1 61)
				(gEgo setMotion: MoveTo 166 124 self)
			)
			(5
				(gEgo illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance explode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(gEgo cycleSpeed: 8 setCycle: CT 4 1 self)
			)
			(2
				(gSoundEffects number: 320 loop: 1 play:)
				(gEgo cycleSpeed: 25 setCycle: CT 7 1 self)
			)
			(3
				(gSoundEffects number: 321 loop: 1 play:)
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(4
				(EgoDead 941 0 0 12 1) ; "That concludes your experiment on the effects of vacuum on the unprotected human body. Wasn't that fun!"
			)
		)
	)
)

(instance bayDoors of View
	(properties
		x 52
		y 99
		description {bay doors}
		sightAngle 45
		lookStr {The massive bay doors are tightly sealed.}
		view 112
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Printf ; "The massive bay doors are %s."
					12
					2
					(if (IsFlag 10)
						{open wide leaving nothing but millions of kilometers of empty space between you and the very stars themselves}
					else
						{tightly sealed}
					)
				)
			)
			(3 ; Do
				(Print 12 3) ; "You can't open the Bay doors from this room."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance podDoor of Prop
	(properties
		x 193
		y 78
		description {pod door}
		sightAngle 45
		approachX 172
		approachY 119
		lookStr {This is one of the Arcada's escape pods. You vaguely remember receiving some orientation on these when you joined the crew. Unfortunately, you were deep into research on sleeping with your eyes open and, hence, don't remember much.}
		view 112
		loop 1
		cel 5
		priority 2
		signal 16
		cycleSpeed 5
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: enterPod)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tv of Prop
	(properties
		x 185
		y 81
		z 40
		description {tv}
		sightAngle 45
		view 112
		cel 1
		cycleSpeed 6
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (> global172 30)
					(Print 12 4) ; "Some alien anchorbeing is broadcasting a message about the stolen Star Generator."
				else
					(Print 12 5) ; "A blank monitor hangs from the ceiling."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance motors of Prop
	(properties
		x 299
		y 133
		description {motors}
		sightAngle 45
		lookStr {These powerful Pyron Weezpump drives propel the pod.}
		view 112
		loop 2
		cel 3
		cycleSpeed 8
		detailLevel 2
	)
)

(instance stars of Prop
	(properties
		x 36
		y 47
		description {star}
		sightAngle 45
		lookStr {Even though we all know that the empty atmosphere of space would not permit this twinkling effect, you have to admit it looks nice.}
		view 112
		loop 3
		cel 2
		cycleSpeed 12
		detailLevel 2
	)
)

(instance buttons of Prop
	(properties
		x 145
		y 68
		description {buttons}
		sightAngle 45
		lookStr {Through the cabin window you can see an array of displays and controls inside the pod.}
		view 112
		loop 5
		cel 1
		cycleSpeed 8
		detailLevel 2
	)
)

(instance bayDoorFeat of Feature
	(properties
		x 53
		y 50
		nsTop -1
		nsBottom 102
		nsRight 106
		description {bay door}
		sightAngle 45
		onMeCheck 16
		lookStr {Beyond the yawning doors lies the serenity of deep space.}
	)
)

(instance spaceFeat of Feature
	(properties
		x 53
		y 50
		nsTop -1
		nsBottom 102
		nsRight 106
		description {space}
		sightAngle 45
		onMeCheck 32
		lookStr {Beyond the yawning doors lies the serenity of deep space.}
	)
)

(instance monitorFeat of Feature
	(properties
		x 194
		y 111
		z 90
		nsLeft 164
		nsBottom 43
		nsRight 225
		description {monitor}
		sightAngle 45
		onMeCheck 64
		lookStr {There's that butt-ugly green guy again. Of all the systems destroyed thus far, you wish the teleview would have been one of them.}
	)

	(method (doVerb theVerb)
		(tv doVerb: theVerb &rest)
	)
)

(instance podFeat of Feature
	(properties
		x 224
		y 97
		description {pod}
		sightAngle 45
		onMeCheck 8
		approachX 172
		approachY 119
		lookStr {A giant, silver, pill-shaped pod sits poised to fire, much like a bullet in the chamber of an ancient pistol.}
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 2) ; Do, Look
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: enterPod)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

