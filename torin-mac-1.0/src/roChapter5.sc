;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50000)
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
	roChapter5 0
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
		(= gtDreep 0)
		(goMusic1 stop: setRelVol: 100)
		(gCurRoom newRoom: 50100) ; roStoreroom
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 1 50001) ; PalLoad
				(= gtPecand toPecand)
				(poPecand setPri: 20 init:)
				(voPecandMouth init:)
				(PecandLookAway)
				(poPecandBlink init:)
				(= gtLycentia toLycentia)
				(poLycentia setPri: 20 init:)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 1 self) ; "...he's about to reach Tenebrous. I'm sure there's no way he'll ever find you, but I just thought you'd want to know."
			)
			(1
				(self setScript: soPecandCloseEyes self)
			)
			(2
				(PecandLookAt)
				(self setScript: soPecandOpenEyes self)
			)
			(3
				(gMessager say: 0 0 0 2 self) ; "(ANGRY) You old fool! `No complications,' you said. (BEGINNING TO CHOKE) `Simple,' you said!"
				(= ticks 180)
			)
			(4
				(voPecandMouth hide:)
				(poPecand view: 50001 setLoop: 2 setCycle: End)
			)
			(5
				(Load rsVIEW 50002)
				(gMessager say: 0 0 0 3 self) ; "(GAGS, CHOKES) I should have known."
			)
			(6
				(poPecand dispose:)
				(poPecandBlink dispose:)
				(voPecandMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 40002)
				(poLycentia
					view: 50002
					setLoop: 5
					cel: 3
					posn: 219 305
					setPri: 50
					init:
				)
				(voLycentiaBody
					view: 50002
					setLoop: 4
					posn: 219 305
					setPri: 45
					init:
				)
				(voLycentiaMouth init:)
				(gMessager say: 0 0 0 4 self) ; "(RECOVERING) All right, I'll take care of it. He won't find me...or his parents!"
			)
			(7
				(gMessager say: 0 0 0 5 self) ; "(SOFTER, MEANER VOICE) Now, what about the rest of our bargain?"
			)
			(8
				(voLycentiaMouth dispose:)
				(poLycentia dispose:)
				(voLycentiaBody dispose:)
				(gCurRoom drawPic: 40001)
				(goSound1 preload: 51437)
				(poPecand view: 50003 setLoop: 0 posn: 338 277 setPri: 10 init:)
				(voPecandMouth init:)
				(gMessager say: 0 0 0 6 self) ; "(PATRONIZING) In time, my dear. All in due time."
			)
			(9
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(gCurRoom drawPic: 40000)
				(poLycentia view: 50001 loop: 3 cel: 0 posn: 184 311 init:)
				(voLycentiaMouth init:)
				(poPecand view: 50001 setLoop: 2 cel: 0 posn: 384 306 init:)
				(= ticks 100)
			)
			(10
				(poPecand
					view: 50004
					setLoop: 0
					cel: 1
					posn: 384 306
					doit:
					setCycle: End self
				)
				(goSound1 playSound: 51437)
			)
			(11
				(poPecand dispose:)
				(voPecandMouth dispose:)
				(= ticks 110)
			)
			(12
				(voLycentiaMouth dispose:)
				(= gtLycentia 0)
				(= gtPecand 0)
				(gMessager say: 0 0 0 7) ; "DREEP!"
				(poLycentia view: 50004 setLoop: 1 cel: 0 setCycle: End self)
			)
			(13
				(poLycentia dispose:)
				(voLycentiaMouth dispose:)
				(gCurRoom drawPic: 51401)
				(poLycentia view: 50005 loop: 0 posn: 375 215 init:)
				(voLycentiaMouth init:)
				(= gtLycentia toLycentia)
				(poDreep init: setCycle: End self)
			)
			(14
				(= ticks 60)
			)
			(15
				(gMessager say: 0 0 0 8 self) ; "I have someone I'd like you to find..."
			)
			(16
				(= ticks 90)
			)
			(17
				(= gtDreep toDreep)
				(poDreep setPri: 30 setLoop: 3)
				(voDreepMouth init:)
				(gMessager say: 0 0 0 9 self) ; "(IT WOULD BE MY PLEASURE) Grunt"
			)
			(18
				(= gtDreep 0)
				(= gtLycentia 0)
				(= ticks 100)
			)
			(19
				(goMusic1 fadeOut: 12 10 self)
				(ActivateGameInventory)
				(FadeToBlack 1 15 self)
			)
			(20)
			(21
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
				(Load rsVIEW 50003)
				(Load rsVIEW 50004)
				(Load rsVIEW 50001)
				(Load rsPIC 40000)
			)
			(2
				(gCurRoom picture: 40000 drawPic: 40000 setScript: soPlayChapter)
			)
		)
	)
)

(instance roChapter5 of TPRoom
	(properties
		purge 2500
	)

	(method (init)
		(switch gnLanguage
			(1
				(= picture 61105)
			)
			(33
				(= picture 61115)
			)
			(49
				(= picture 61125)
			)
		)
		(super init: &rest)
		(goMusic1 relVolPercent: 150 setMusic: 50000)
		(= gnChapter 5)
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
		x 384
		y 306
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

(instance poPecand of Prop
	(properties
		x 384
		y 306
		view 50001
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

(instance poLycentia of Prop
	(properties
		x 184
		y 311
		view 50001
		loop 3
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
		(super dispose: &rest)
		(MouthSync oSpecialSync: 0)
		(MouthSync nSpecialSelector: 0)
		(voLycentiaMouth show:)
	)
)

(instance coHandleLycentia of CueMe
	(properties)

	(method (cue nWhich)
		(switch nWhich
			(8
				(if (toLycentia mouth:)
					((toLycentia mouth:) hide:)
				else
					(voLycentiaMouth hide:)
				)
				(poLycentia loop: 5 doit: setCycle: End coResetLycentia)
			)
		)
	)
)

(instance coResetLycentia of CueMe
	(properties)

	(method (cue)
		(if (and (== (poLycentia view:) 50001) (== (poLycentia loop:) 5))
			(if (toLycentia mouth:)
				((toLycentia mouth:) show:)
			else
				(voLycentiaMouth show:)
			)
			(poLycentia loop: 3 cel: 0 doit: setCycle: 0)
		)
	)
)

(instance poDreep of Prop
	(properties
		x 223
		y 232
		view 50005
		loop 2
	)
)

(instance toDreep of Talker
	(properties)

	(method (init)
		(= x (poDreep x:))
		(= y (poDreep y:))
		(= view (poDreep view:))
		(= loop (+ (poDreep loop:) 1))
		(= priority (+ (poDreep priority:) 1))
		(voDreepMouth hide:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
		(voDreepMouth show:)
	)
)

(instance voDreepMouth of Prop
	(properties)

	(method (init)
		(= x (poDreep x:))
		(= y (poDreep y:))
		(= view (poDreep view:))
		(= loop (+ (poDreep loop:) 1))
		(self setPri: (+ (poDreep priority:) 1))
		(super init: &rest)
	)
)

