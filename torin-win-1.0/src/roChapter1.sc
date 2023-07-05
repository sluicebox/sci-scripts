;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10000)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use Talker)
(use Motion)
(use Actor)
(use System)

(public
	roChapter1 0
)

(local
	bTalking
)

(instance soPlayChapter of TPScript
	(properties
		bHasFF 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 1 10001) ; PalLoad
				(gCurRoom drawPic: 10004)
				(voAx init:)
				(voRope init:)
				(poSmoke
					view: 11003
					cel: 0
					setLoop: 0
					posn: 320 58
					cycleSpeed: 9
					setCycle: Fwd
					init:
				)
				(poTorin
					view: 10004
					setLoop: 0
					cel: 0
					posn: 239 240
					cycleSpeed: 60
					init:
					setCycle: Fwd
				)
				(FrameOut)
				(gMessager say: 0 0 2 1 self) ; "NO! They never hurt anyone! What happened?"
			)
			(1
				(poTorin cel: 0 cycleSpeed: 7 setCycle: 0)
				(poPecand
					view: 10004
					setLoop: 2
					cel: 0
					posn: 51 191
					init:
					setCycle: CT 10 1 self
				)
			)
			(2
				(= bTalking 1)
				(FrameOut)
				(gMessager sayRange: 0 0 2 2 3 coDoneTalking) ; "I saw it. I saw everything!"
				(poPecand setCycle: CT 32 1 self)
			)
			(3
				(poPecand setCycle: End)
				(poTorin setLoop: 1 cel: 0 doit: setCycle: End self)
			)
			(4
				(= cycles 1)
			)
			(5
				(if bTalking
					(self changeState: (- state 1))
				else
					(self cue:)
				)
			)
			(6
				(poTorin dispose:)
				(poPecand dispose:)
				(poSmoke dispose:)
				(voAx dispose:)
				(voRope dispose:)
				(gCurRoom drawPic: 10001)
				(poPecand
					view: 10001
					loop: 0
					cel: 0
					posn: 273 310
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(= gtPecand toPecand)
				(= gtTorin toTorin)
				(FrameOut)
				(gMessager say: 0 0 2 4 self) ; "I was just passing by when all that started. I was so scared, I hid behind your barn."
			)
			(7
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10002)
				(poTorin
					view: 10002
					setLoop: 0
					cel: 0
					posn: 277 233
					setPri: 20
					init:
				)
				(voTorinMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 5 self) ; "Who could have done this?"
			)
			(8
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10001)
				(poPecand
					view: 10001
					loop: 0
					cel: 0
					posn: 273 310
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 6 self) ; "It must have been one powerful sorcerer. (SOFTER; CASTING THE FIRST BAIT) Or sorceress!"
			)
			(9
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10000)
				(poTorin
					view: 10000
					setLoop: 0
					cel: 0
					posn: 496 210
					setPri: 20
					init:
				)
				(voTorinMouth init:)
				(poPecand
					view: 10000
					setLoop: 2
					cel: 0
					posn: 181 194
					setPri: 20
					init:
				)
				(voPecandMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 7 self) ; "Why? And who around here has such power?"
			)
			(10
				(gMessager say: 0 0 2 8 self) ; "No one I know. (TROLLING THE BAIT) But... once there was such a person...but, no, Lycentia's been gone for years."
			)
			(11
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10002)
				(poTorin
					view: 10002
					setLoop: 0
					cel: 0
					posn: 277 233
					setPri: 20
					init:
				)
				(voTorinMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 9 self) ; "Lycentia? Who's Lycentia?"
			)
			(12
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10001)
				(poPecand
					view: 10001
					loop: 0
					cel: 0
					posn: 273 310
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 10 self) ; "(LYING) Oh, I don't think it could possibly be her. She was banished to The Lands Below years ago!"
			)
			(13
				(= gtTorin 0)
				(gMessager say: 0 0 2 11 self) ; "The Lands Below! She must have been evil to be sent there!"
			)
			(14
				(= gtTorin toTorin)
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10001)
				(poPecand
					view: 10001
					loop: 0
					cel: 0
					posn: 273 310
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(FrameOut)
				(gMessager say: 0 0 2 12 self) ; "Yes. (SETTING THE HOOK) And there's no way you could ever find her down there!"
			)
			(15
				(poTorin dispose:)
				(voTorinMouth dispose:)
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 10003)
				(poTorin
					view: 10003
					setLoop: 0
					cel: 0
					posn: 370 246
					setPri: 20
					init:
				)
				(voTorinMouth init:)
				(poPecand
					view: 10003
					setLoop: 3
					cel: 0
					posn: 143 222
					setPri: 15
					init:
				)
				(= ticks 120)
			)
			(16
				(gMessager say: 0 0 2 13 self) ; "I know what I'll do. I'll find this Lycentia and force her to release my parents!"
			)
			(17
				(= ticks 100)
			)
			(18
				(voTorinMouth dispose:)
				(poTorin setLoop: 2 doit: setCycle: End self)
			)
			(19
				(poTorin dispose:)
				(= seconds 2)
			)
			(20
				(poPecand setCycle: End self)
			)
			(21
				(poPecand setLoop: 4 cel: 0 doit:)
				(voPecandMouth init:)
				(gMessager say: 0 0 2 14 self) ; "(TO SELF, EVIL GRIN) I'm sure you will."
			)
			(22
				(voPecandMouth dispose:)
				(poPecand setLoop: 6 cel: 0 doit: setCycle: End self)
			)
			(23
				(poPecand dispose:)
				(goMusic1 fadeOut: 12 10 self)
				(FadeToBlack 1 15 self)
			)
			(24)
			(25
				(self ff:)
			)
		)
	)

	(method (ff)
		(= gtTorin 0)
		(= gtPecand 0)
		(goMusic1 stop: setRelVol: 100)
		(gCurRoom newRoom: 10100) ; roForestScroll
	)
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= bTalking 0)
	)
)

(instance poTorin of Prop
	(properties)
)

(instance voTorinMouth of View
	(properties)

	(method (init)
		(= x (poTorin x:))
		(= y (poTorin y:))
		(self setPri: (+ (poTorin priority:) 5))
		(= view (poTorin view:))
		(= loop (+ (poTorin loop:) 1))
		(super init: &rest)
	)
)

(instance toTorin of Talker
	(properties)

	(method (init)
		(= x (voTorinMouth x:))
		(= y (voTorinMouth y:))
		(= priority (voTorinMouth priority:))
		(= view (voTorinMouth view:))
		(= loop (voTorinMouth loop:))
		(voTorinMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(voTorinMouth show:)
	)
)

(instance poPecand of Prop
	(properties)
)

(instance voPecandMouth of View
	(properties)

	(method (init)
		(= x (poPecand x:))
		(= y (poPecand y:))
		(self setPri: (+ (poPecand priority:) 5))
		(= view (poPecand view:))
		(= loop (+ (poPecand loop:) 1))
		(super init: &rest)
	)
)

(instance toPecand of Talker
	(properties)

	(method (init)
		(= x (voPecandMouth x:))
		(= y (voPecandMouth y:))
		(= priority (voPecandMouth priority:))
		(= view (voPecandMouth view:))
		(= loop (voPecandMouth loop:))
		(voPecandMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(voPecandMouth show:)
	)
)

(instance poSmoke of Prop
	(properties)
)

(instance voAx of View
	(properties
		x 493
		y 266
		priority 271
		fixPriority 1
		view 10007
	)
)

(instance voRope of View
	(properties
		x 229
		y 32
		view 10008
	)
)

(instance soIntro of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(FrameOut)
				(= cycles 1)
			)
			(1
				(= ticks 400)
				(Load rsPIC 11000)
				(Load rsVIEW 10004)
			)
			(2
				(gCurRoom picture: 10004 drawPic: 10004 setScript: soPlayChapter)
			)
		)
	)
)

(instance roChapter1 of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(switch gnLanguage
			(1
				(= picture 61101)
			)
			(33
				(= picture 61111)
			)
			(49
				(= picture 61121)
			)
		)
		(= gnChapter 1)
		(super init: &rest)
		(goMusic1 relVolPercent: 150 setMusic: 10000)
		(gCurRoom setScript: soIntro)
	)
)

