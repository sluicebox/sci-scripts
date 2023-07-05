;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40000)
(include sci.sh)
(use Main)
(use oInterface)
(use oHandsOnWhenCued)
(use TPScript)
(use CueMe)
(use n64896)
(use Talker)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	roChapter4 0
)

(procedure (PecandLookAway)
	(poPecandBlink loop: 7)
)

(procedure (PecandLookAt)
	(poPecandBlink loop: 6)
)

(instance soPlayChapter of TPScript
	(properties
		bHasFF 1
	)

	(method (ff)
		(= gtLycentia 0)
		(= gtPecand 0)
		(goMusic1 stop: setRelVol: 100)
		(gCurRoom newRoom: 40100) ; roAstheniaEntrance
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 1 50001) ; PalLoad
				(= gtPecand toPecand)
				(= gtLycentia toLycentia)
				(poPecand init: setPri: 10)
				(voPecandMouth init:)
				(poLycentia setPri: 200 init:)
				(= ticks 1)
			)
			(1
				(= ticks 20)
			)
			(2
				(gMessager say: 0 0 0 1 self) ; "I always felt you were innocent. Kurtzwell needed a scapegoat. (CONTINUE, SYRUPY SWEET) All these years away from your home...your family, your friends. You must be so bitter."
			)
			(3
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 40000)
				(poPecand
					view: 50001
					setLoop: 0
					cel: 0
					posn: 385 308
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(PecandLookAway)
				(poPecandBlink init:)
				(poLycentia
					view: 50001
					setLoop: 3
					cel: 0
					posn: 222 311
					setPri: 20
					init:
				)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 2 self) ; "Perhaps. I've learned to use the darkness to get what I want."
			)
			(4
				(gMessager say: 0 0 0 3 self) ; "I've heard you've become quite the powerful sorceress."
			)
			(5
				(self setScript: soPecandCloseEyes self)
			)
			(6
				(PecandLookAt)
				(self setScript: soPecandOpenEyes self)
			)
			(7
				(gMessager say: 0 0 0 4 self) ; "Oh?"
			)
			(8
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(poPecandBlink dispose:)
				(gCurRoom drawPic: 40001)
				(poPecand view: 50003 setLoop: 0 cel: 0 posn: 338 279 init:)
				(voPecandMouth init:)
				(gMessager say: 0 0 0 5 self) ; "(TWISTING THE KNIFE) But, not quite powerful enough to overcome the magic of that collar."
			)
			(9
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 40002)
				(poLycentia view: 50002 setLoop: 0 cel: 0 posn: 219 306 init:)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 6 self) ; "Not yet, but perhaps soon. And when I do, I promise revenge!"
			)
			(10
				(voLycentiaMouth dispose:)
				(poLycentiaBlink dispose:)
				(poLycentia setLoop: 2 cel: 0 doit: setCycle: CT 7 1 self)
			)
			(11
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(poPecandBlink dispose:)
				(gCurRoom drawPic: 40000)
				(poPecand
					view: 50001
					setLoop: 0
					cel: 0
					posn: 385 308
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(PecandLookAway)
				(poPecandBlink init:)
				(poLycentia
					view: 50001
					setLoop: 3
					cel: 0
					posn: 222 311
					setPri: 20
					init:
				)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 7 self) ; "(UNIMPRESSED) I'm sure. (NOW DANGLE THE LURE) But what if you could return sooner?"
			)
			(12
				(gMessager say: 0 0 0 8 self) ; "(DISGUSTED) What? Hah! The collar will not be denied."
			)
			(13
				(self setScript: soPecandCloseEyes self)
			)
			(14
				(PecandLookAt)
				(self setScript: soPecandOpenEyes self)
			)
			(15
				(gMessager say: 0 0 0 9 self) ; "(CASTING THE BAIT) I...could release it for you."
			)
			(16
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(poPecandBlink dispose:)
				(gCurRoom drawPic: 40002)
				(poLycentia
					view: 50002
					setLoop: 5
					cel: 4
					posn: 220 305
					setPri: 50
					init:
				)
				(voLycentiaBody
					view: 50002
					setLoop: 4
					cel: 0
					posn: 220 305
					setPri: 45
					init:
				)
				(voLycentiaMouth init:)
				(poLycentiaBlink init:)
				(gMessager say: 0 0 0 10 self) ; "(SARCASTICALLY) Ha, ha, ha. Oh, Pecand. You know its spell can only be broken by royalty. (NOW DIG IT INTO HIM) And no matter how much you scheme, you'll never be King as long as the boy lives!"
			)
			(17
				(= gtPecand 0)
				(gMessager say: 0 0 0 11 self) ; "(UNABASHED) Yes...but think, Lycentia! Who sealed the collar?"
			)
			(18
				(= gtPecand toPecand)
				(gMessager say: 0 0 0 12 self) ; "(DISGUSTED) Kurtzwell! That... (SLOWLY REALIZE PECAND'S DRIFT) ...wait! Are you suggesting you could become Arch-Authority?"
			)
			(19
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(voLycentiaBody dispose:)
				(poPecandBlink dispose:)
				(poLycentiaBlink dispose:)
				(gCurRoom drawPic: 40000)
				(poPecand
					view: 50001
					setLoop: 0
					cel: 0
					posn: 385 308
					setPri: 10
					init:
				)
				(voPecandMouth init:)
				(poPecandBlink init:)
				(poLycentia
					view: 50001
					setLoop: 3
					cel: 0
					posn: 222 311
					setPri: 20
					init:
				)
				(voLycentiaMouth init:)
				(PecandLookAway)
				(gMessager say: 0 0 0 13 self) ; "(SETTING THE HOOK) Let's just say, if you'll do a small favor for me, I'll do a large favor for you!"
			)
			(20
				(gMessager say: 0 0 0 14 self) ; "And just WHAT would that small favor be?"
			)
			(21
				(self setScript: soPecandCloseEyes self)
			)
			(22
				(PecandLookAt)
				(self setScript: soPecandOpenEyes self)
			)
			(23
				(gMessager say: 0 0 0 15 self) ; "Nothing, much. Just a little magic spell..."
			)
			(24
				(= ticks 180)
			)
			(25
				(goMusic1 fadeOut: 6 10 self)
				(ActivateGameInventory)
				(FadeToBlack 1 15 self)
			)
			(26)
			(27
				(self ff:)
			)
		)
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
				(Load rsVIEW 50001)
				(Load rsVIEW 50002)
				(Load rsVIEW 50001)
				(Load rsPIC 51401)
			)
			(2
				(gCurRoom picture: 51401 drawPic: 51401 setScript: soPlayChapter)
			)
		)
	)
)

(instance roChapter4 of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(switch gnLanguage
			(1
				(= picture 61104)
			)
			(33
				(= picture 61114)
			)
			(49
				(= picture 61124)
			)
		)
		(super init: &rest)
		(goMusic1 relVolPercent: 150 setMusic: 40000)
		(= gnChapter 4)
		(gCurRoom setScript: soIntro)
	)
)

(instance soPecandCloseEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecandBlink setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance soPecandOpenEyes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPecandBlink setCycle: Beg self)
			)
			(1
				(poPecandBlink setCycle: Blink 140)
				(self dispose:)
			)
		)
	)
)

(instance poPecandBlink of Prop
	(properties
		x 385
		y 308
		priority 500
		fixPriority 1
		view 50001
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 140)
	)
)

(instance poLycentiaBlink of Prop
	(properties
		x 220
		y 305
		priority 500
		fixPriority 1
		view 50002
		loop 7
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Blink 90)
	)
)

(instance poPecand of Prop
	(properties
		x 417
		y 143
		view 50006
		loop 1
	)
)

(instance toPecand of Talker
	(properties)

	(method (init)
		(= x (poPecand x:))
		(= y (poPecand y:))
		(= view (poPecand view:))
		(= loop (+ (poPecand loop:) 1))
		(= priority (+ (poPecand priority:) 1))
		(voPecandMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(voPecandMouth show:)
	)
)

(instance voPecandMouth of Prop
	(properties)

	(method (init)
		(= x (poPecand x:))
		(= y (poPecand y:))
		(= view (poPecand view:))
		(= loop (+ (poPecand loop:) 1))
		(self setPri: (+ (poPecand priority:) 1))
		(super init: &rest)
	)
)

(instance coHandleLycentia of CueMe
	(properties)

	(method (cue nWhich)
		(switch nWhich
			(0
				(if
					(and
						(== (poLycentia view:) 50002)
						(== (poLycentia loop:) 3)
					)
					(if (toLycentia mouth:)
						((toLycentia mouth:) show:)
					else
						(voLycentiaMouth show:)
					)
					(voLycentiaBody show:)
					(poLycentiaBlink init:)
					(poLycentia loop: 5 cel: 4 doit: setCycle: 0)
				)
			)
			(8
				(if (toLycentia mouth:)
					((toLycentia mouth:) hide:)
				else
					(voLycentiaMouth hide:)
				)
				(voLycentiaBody hide:)
				(poLycentiaBlink dispose:)
				(poLycentia loop: 3 cel: 0 cycleSpeed: 5 doit: setCycle: Fwd)
			)
		)
	)
)

(instance poLycentia of Prop
	(properties
		x 431
		y 223
		view 50006
	)
)

(instance voLycentiaBody of View
	(properties)
)

(instance voLycentiaMouth of Prop
	(properties)

	(method (init)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= view (poLycentia view:))
		(= loop (+ (poLycentia loop:) 1))
		(self setPri: (+ (poLycentia priority:) 1))
		(super init: &rest)
	)
)

(instance toLycentia of Talker
	(properties)

	(method (init)
		(= x (poLycentia x:))
		(= y (poLycentia y:))
		(= view (poLycentia view:))
		(= loop (+ (poLycentia loop:) 1))
		(= priority (+ (poLycentia priority:) 1))
		(MouthSync oSpecialSync: coHandleLycentia)
		(MouthSync nSpecialSelector: 178)
		(voLycentiaMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(coHandleLycentia cue: 0)
		(super dispose: &rest)
		(MouthSync oSpecialSync: 0)
		(MouthSync nSpecialSelector: 0)
		(voLycentiaMouth show:)
	)
)

