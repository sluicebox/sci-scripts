;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Motion)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	local0
)

(instance myConv of Conversation
	(properties)
)

(instance rm350 of KQ6Room
	(properties
		noun 3
		picture 350
	)

	(method (init)
		(super init: &rest)
		(gGlobalSound number: 350 setLoop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 304 189 268 167 233 162 169 162 169 150 148 150 148 162 79 162 47 169 14 189 0 189 0 0 319 0 319 189
					yourself:
				)
		)
		(if (not (IsFlag 2))
			(LoadMany rsVIEW 343 344 348 3481 349 3491)
		)
		(gFeatures add: nests palace oracleMtn gate eachElementDo: #init)
		(leftGuard init:)
		(riteGuard init:)
		(gEgo reset: 3 posn: 160 188 init:)
		(if (not (IsFlag 2))
			(gTheIconBar
				enable:
				disable: 0 1 2 3 4 5 6
				height: -100
				activateHeight: -100
			)
			(Cursor showCursor: 0)
			(gCurRoom setScript: egoEnters)
		else
			(gGame handsOn:)
		)
	)

	(method (doit)
		(cond
			((gCurRoom script:))
			((== (gEgo onControl: 1) 64)
				(gCurRoom setScript: stayOut)
			)
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: walkOut)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(gEgo setScale: 0)
		(super dispose:)
	)

	(method (scriptCheck param1 &tmp temp0)
		(= temp0 1)
		(if (== param1 87)
			(gMessager say: 0 0 94 1 0 899) ; "Alexander doesn't know what that potion might do! He doesn't want to frighten the Winged Ones' guards, and there's no one else here who might be impressed with the results!"
			(= temp0 0)
		)
		(return temp0)
	)
)

(instance gate of Feature
	(properties
		noun 5
		onMeCheck 2
	)
)

(instance nests of Feature
	(properties
		noun 6
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 1 0 1) ; "Beyond the gates is a strange city made of nests atop tall pillars."
			)
			(2 ; Talk
				(gMessager say: 6 2 0 1) ; "No one in the city could hear Alexander from here."
			)
			(else
				(gMessager say: 6 5 0 1) ; "Alexander cannot reach the distant city from here."
			)
		)
	)
)

(instance palace of Feature
	(properties
		noun 8
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 8 1 0 1) ; "The Palace Nest, as befits its status, is taller than the other nests in the city."
			)
			(2 ; Talk
				(gMessager say: 6 2 0 1) ; "No one in the city could hear Alexander from here."
			)
			(else
				(gMessager say: 6 5 0 1) ; "Alexander cannot reach the distant city from here."
			)
		)
	)
)

(instance oracleMtn of Feature
	(properties
		noun 7
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 7 1 0 1) ; "Rearing tall behind the city is the peak of the Sacred Mountain. The Oracle's cave is gashed into the face of the mountain like a wound."
			)
			(2 ; Talk
				(gMessager say: 7 2 0 1) ; "No one in the Oracle's cave could hear Alexander from here."
			)
			(else
				(gMessager say: 7 5 0 1) ; "Alexander cannot reach the Oracle's cave from here."
			)
		)
	)
)

(instance stayOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(leftGuard
					view: 345
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: End
				)
				(riteGuard
					view: 345
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(1
				(gMessager say: 4 2 8 2 self) ; "You are not welcome here, human! Be gone!"
			)
			(2
				(gEgo
					setLoop: (gEgo cel:)
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
			)
			(3
				(gEgo setLoop: -1)
				(leftGuard setCycle: Beg)
				(riteGuard setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dummyEgo of Actor
	(properties)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 160 160 self)
			)
			(1
				(= cycles 6)
			)
			(2
				(gMessager say: 1 0 1 1 self) ; "(AMAZED, ALARMED) Look! An intruder!"
			)
			(3
				(leftGuard setCycle: StopWalk -1 setMotion: MoveTo 134 158)
				(riteGuard setCycle: StopWalk -1 setMotion: MoveTo 189 158 self)
			)
			(4
				(leftGuard setHeading: 90 self)
				(riteGuard setHeading: 270 self)
			)
			(5 0)
			(6
				(= cycles 2)
			)
			(7
				(myConv
					add: -1 1 0 1 2 ; "(COLD, VICIOUS) Hold! How did you get up here, human?"
					add: -1 1 0 1 3 ; "(POLITE, A LITTLE NERVOUS) I climbed the cliffs."
					add: -1 1 0 1 4 ; "(DISDAINFUL) That is not possible! No one has solved the Cliffs of Logic in several centuries--and if the cliffs WERE to be solved, it would certainly not be by a HUMAN!"
					add: -1 1 0 1 5 ; "I...I didn't mean to trespass. I only wanted to visit this beautiful island."
					add: -1 1 0 1 6 ; "No visitors have been welcome on the Isle of the Sacred Mountain in years! Not since the red and white queens had spies in the guise of 'friendly visitors' steal our island's sacred golden fleece!"
					add: -1 1 0 1 7 ; "But we will not display such foolish trust again! You will have to answer to Lord Azure and Lady Aeriel. They will determine what will be done with you! I can assure you, it will not be pleasant!"
					init: self
				)
			)
			(8
				(leftGuard dispose:)
				(riteGuard dispose:)
				(gEgo hide:)
				(dummyEgo view: 351 posn: 160 164 init: setCycle: End self)
				(UnLoad 128 900)
			)
			(9
				(dummyEgo
					view: 352
					ignoreHorizon:
					cycleSpeed: 6
					moveSpeed: 6
					posn: 160 164
					setCycle: End self
				)
				(UnLoad 128 351)
			)
			(10
				(dummyEgo
					view: 353
					posn: 162 103
					setCycle: Fwd
					cycleSpeed: 3
					setStep: 15 12
					setMotion: MoveTo (gEgo x:) -50 self
				)
				(UnLoad 128 352)
			)
			(11
				(dummyEgo
					view: 353
					setScale: Scaler 50 49 190 0
					setLoop: 1
					setStep: 3 2
					posn: 230 -20
					setCycle: Fwd
					setMotion: MoveTo 139 7 self
				)
			)
			(12
				(gGlobalSound fade: 0 20 15)
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance walkOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
			(1
				(gGlobalSound fade: 0 15 15)
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance leftGuard of Actor
	(properties
		x 120
		y 150
		noun 4
		approachX 120
		approachY 160
		yStep 3
		view 344
		loop 2
		signal 24576
		xStep 5
	)

	(method (init)
		(self approachVerbs: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 101)
					(gCurRoom setScript: talkToGuards)
				else
					(SetFlag 101)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance riteGuard of Actor
	(properties
		x 200
		y 150
		noun 4
		approachX 200
		approachY 160
		yStep 3
		view 343
		loop 2
		signal 24576
		xStep 5
	)

	(method (init)
		(self approachVerbs: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (IsFlag 101)
					(gCurRoom setScript: talkToGuards)
				else
					(SetFlag 101)
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance talkToGuards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 160 160 self)
			)
			(1
				(= cycles 4)
			)
			(2
				(gMessager say: 4 2 8 0 self) ; "Are you sure I can't revisit the city?"
			)
			(3
				(gEgo setLoop: 3 setMotion: MoveTo 160 175 self)
			)
			(4
				(gEgo reset: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

