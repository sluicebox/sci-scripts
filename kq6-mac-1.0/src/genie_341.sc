;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 341)
(include sci.sh)
(use Main)
(use rSacred)
(use n913)
(use Conversation)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	proc341_0 0
	proc341_1 1
	proc341_2 2
	proc341_3 3
	genie 4
	poofAwayScript 5
)

(local
	local0
	local1
	local2
)

(procedure (proc341_0)
	(genie init:)
)

(procedure (proc341_1)
	(genie setScript: genieTrap)
)

(procedure (proc341_2)
	(genie dispose:)
)

(procedure (proc341_3)
	(genie addToPic:)
)

(instance myConv of Conversation
	(properties)
)

(instance geniePoly of Polygon
	(properties)
)

(instance eyeGlint of Prop
	(properties
		view 902
		cycleSpeed 15
	)

	(method (init)
		(self setPri: 15 setCycle: End self)
		(super init:)
	)

	(method (cue)
		(if (== cel 2)
			(self setPri: 15 setCycle: Beg self)
		else
			((genie script:) cue:)
			(self dispose:)
		)
	)
)

(instance genie of Actor
	(properties
		x 260
		y 116
		noun 8
		modNum 340
		yStep 8
		view 334
		signal 24576
		xStep 12
	)

	(method (init)
		(gCurRoom
			addObstacle:
				(geniePoly
					type: PBarredAccess
					init: 279 120 239 120 234 116 239 113 279 113 283 116
					yourself:
				)
		)
		(rSacred geniePresent: 1)
		(super init:)
	)

	(method (dispose)
		(gGlobalSound3 fade: 0 6 6)
		(eyeGlint dispose:)
		((gCurRoom obstacles:) delete: geniePoly)
		(geniePoly dispose:)
		(rSacred geniePresent: 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if local0
					(myConv add: 340 8 2 26 1 add: 340 8 2 26 2 init:) ; "(CURIOUS, FRIENDLY) How can this plant give the power of flight?", "(IMPATIENT) Listen, son! I'll be happy to answer any questions you like, but only if you at least taste these delicious berries."
				else
					(= local0 1)
					(myConv add: 340 8 2 25 1 add: 340 8 2 25 2 init:) ; "(CURIOUS, FRIENDLY) But...who are you, matron?", "(IMPATIENT) Who cares? Er.... I mean, I am only a poor old woman who wishes you well, handsome stranger. Think of me as your grandmama, if you like."
				)
			)
			(63 ; mint
				(gEgo setScript: 0)
				(gGame handsOff:)
				(gCurRoom setScript: genieAsMintJunkie)
			)
			(43 ; huntersLamp
				(gMessager say: noun theVerb 0 0) ; "I have this hunter's lamp...."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance poofAwayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(genie setScript: 0 setCycle: 0 setMotion: 0)
				(eyeGlint dispose:)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 0 7 1 self 340) ; "(VERY ANGRY) ALL RIGHT THEN! Stay tied to the ground like a load of lead! See if I care, you...you...you human!"
			)
			(2
				(gGlobalSound4 number: 943 setLoop: 1 play:)
				(genie setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 1 0 7 2 self 340) ; "How odd! The old woman just disappeared in a cloud of smoke. Perhaps those berries are even more powerful than she led Alexander to believe!"
			)
			(4
				(rSacred geniePresent: 0)
				(self dispose:)
				(genie dispose:)
			)
		)
	)
)

(instance genieAsMintJunkie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (gEgo x:) (genie x:))
					(gEgo setMotion: PolyPath 249 118 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setHeading: 45)
				(= cycles 8)
			)
			(2
				(myConv add: 340 8 63 0 1 add: 340 8 63 0 2 init: self) ; "(ENTICINGLY) Would you care for a mint?", "(EXCITED) Mint? Really? OOOH!"
			)
			(3
				(genie
					setLoop: 3
					posn: (- (genie x:) 1) (- (genie y:) 25)
					setCycle: End self
				)
			)
			(4
				(genie
					setCycle: 0
					setMotion:
						MoveTo
						(+ (gEgo x:) 12)
						(- (gEgo y:) 27)
						self
				)
			)
			(5
				(genie setCycle: Beg self)
			)
			(6
				(genie
					setLoop: 5
					cel: 0
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 3)
				)
				(gEgo
					view: 334
					normal: 0
					setLoop: 6
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(7
				(genie setCycle: End self)
				(gEgo cel: 3)
			)
			(8
				(myConv add: 340 8 63 0 3 add: 340 8 63 0 4 init: self) ; "HMMM! <CRUNCH> <SMACK> <SLOBBER> YUM!", "Er...oops <hic>. Heh-heh. I'll just be <hic> going now."
			)
			(9
				(gEgo reset: 6 put: 23 340) ; mint
				(gGlobalSound4 number: 943 setLoop: 1 play:)
				(genie
					setLoop: 2
					cel: 0
					posn: (+ (gEgo x:) 13) (- (gEgo y:) 2)
					setCycle: End self
				)
			)
			(10
				(= local1 1)
				(genie dispose:)
				(= cycles 4)
			)
			(11
				(gMessager say: 8 63 0 5 self 340) ; "How odd. That woman simply disappeared."
			)
			(12
				(gGame handsOn:)
				(self dispose:)
				(DisposeScript 341)
			)
		)
	)
)

(instance genieTrap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 4)
				(= seconds 2)
				(gEgo setHeading: 30)
			)
			(1
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(2
				(= cycles 2)
			)
			(3
				(gMessager say: 1 0 1 2 0 340) ; "(SWEETLY) Why do you make such an effort to climb the cliffs, young man? The Winged Ones who live on this island have the power of flight."
				(= seconds 1)
			)
			(4
				(genie setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(genie setCycle: Beg self)
			)
			(6
				(genie setCycle: End self)
			)
			(7
				(genie setCycle: Beg self)
			)
			(8
				(= seconds 2)
			)
			(9
				(gMessager say: 1 0 1 3 0 340) ; "You can have it too if only you would eat a berry from this magical flying nightshade bush!"
				(= seconds 1)
			)
			(10
				(= seconds 2)
			)
			(11
				(genie setLoop: 1 cel: 0)
				(= cycles 6)
			)
			(12
				(genie setLoop: 5 cel: 0 setCycle: End self)
				(gGlobalSound4 number: 348 setLoop: 1 play:)
			)
			(13
				(genie setCycle: Beg self)
			)
			(14
				(genie setLoop: 0 posn: 260 116)
				(= seconds 2)
			)
			(15
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(16
				(= cycles 2)
			)
			(17
				(genie setLoop: 3 cel: 0 posn: 259 89 setCycle: End self)
			)
			(18
				(gGlobalSound4 number: 347 setLoop: -1 play:)
				(genie setCycle: Beg self)
			)
			(19
				(genie
					setLoop: 4
					cel: 0
					setCycle: Fwd
					setMotion: MoveTo (- (genie x:) 30) (- (genie y:) 20) self
				)
			)
			(20
				(genie
					setMotion: MoveTo (+ (genie x:) 60) (- (genie y:) 20) self
				)
			)
			(21
				(genie
					setMotion: MoveTo (- (genie x:) 60) (- (genie y:) 20) self
				)
			)
			(22
				(genie
					setMotion: MoveTo (+ (genie x:) 60) (- (genie y:) 20) self
				)
			)
			(23
				(genie
					setMotion: MoveTo (- (genie x:) 60) (+ (genie y:) 20) self
				)
			)
			(24
				(genie
					setMotion: MoveTo (+ (genie x:) 60) (+ (genie y:) 20) self
				)
			)
			(25
				(genie
					setMotion: MoveTo (- (genie x:) 30) (+ (genie y:) 20) self
				)
			)
			(26
				(genie setLoop: 3 cel: 3 posn: 259 89 setCycle: Beg self)
			)
			(27
				(gGlobalSound4 stop:)
				(genie setLoop: 0 posn: 260 116)
				(= seconds 2)
			)
			(28
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(29
				(= cycles 2)
			)
			(30
				(gGame handsOn:)
				(gMessager say: 1 0 1 4 0 340) ; "(SWEETLY) See? The sweet berries will make you float like a petal on the wind! Try some!"
				(= seconds 1)
			)
			(31
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(32
				(= seconds 10)
			)
			(33
				(if (and (not (gCurRoom script:)) (not gModelessDialog))
					(gMessager say: 1 0 5 1 0 340) ; "(LESS FRIENDLY) Come, stranger, trust me! Think of what I'm offering you!"
					(= seconds 1)
				else
					(self cue:)
				)
			)
			(34
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(35
				(= seconds 10)
			)
			(36
				(if (and (not (gCurRoom script:)) (not gModelessDialog))
					(gMessager say: 1 0 6 1 0 340) ; "(HARSHER, IMPATIENT) Young man, you offend me! I try to help you, and you insist on being rude!"
					(= seconds 1)
				else
					(self cue:)
				)
			)
			(37
				(eyeGlint posn: (genie x:) (- (genie y:) 44) init:)
			)
			(38
				(= seconds 10)
			)
			(39
				(if (and (not (gCurRoom script:)) (not gModelessDialog))
					(gMessager say: 1 0 7 1 0 340) ; "(VERY ANGRY) ALL RIGHT THEN! Stay tied to the ground like a load of lead! See if I care, you...you...you human!"
					(= seconds 1)
				else
					(self cue:)
				)
			)
			(40
				(gGame handsOff:)
				(if (not (gCurRoom script:))
					(Face gEgo genie)
				)
				(gGlobalSound4 number: 943 setLoop: 1 play:)
				(genie setLoop: 2 cel: 0 setCycle: End self)
			)
			(41
				(gMessager say: 1 0 7 2 0 340) ; "How odd! The old woman just disappeared in a cloud of smoke. Perhaps those berries are even more powerful than she led Alexander to believe!"
				(= seconds 1)
			)
			(42
				(gGame handsOn:)
				(genie dispose:)
			)
		)
	)
)

