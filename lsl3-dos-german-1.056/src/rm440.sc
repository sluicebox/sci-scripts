;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm440 0
)

(local
	[local0 2]
)

(procedure (PrintCherri)
	(gTheWindow color: 12 back: 8)
	(Print &rest #at 20 -1 #title {Cherri says} #width 150)
	(gTheWindow color: 0 back: 8)
)

(procedure (PrintLarry)
	(gTheWindow color: 9 back: 8)
	(Print &rest #at 180 -1 #title {You say} #width 120)
	(gTheWindow color: 0 back: 8)
)

(instance rm440 of Rm
	(properties
		picture 440
		east 420
	)

	(method (init)
		(SL disable:)
		(TheMenuBar hide:)
		(Load rsVIEW 440)
		(Load rsVIEW 444)
		(super init:)
		(self setScript: RoomScript)
		(NormalEgo 1)
		(gEgo
			viewer: shadowViewer
			posn: 315 151
			observeBlocks: theCage
			init:
		)
		(cond
			((not (TestFlag 35))
				(SetFlag 35)
				(SetFlag 5)
				(Load rsVIEW 443)
				(Load rsVIEW 442)
				(Load rsSOUND 8)
				(Load rsSOUND 10)
				(Load rsPIC 99)
				(HandsOff)
				(aCherri init: setCycle: Walk ignoreActors:)
				(RoomScript changeState: 1)
			)
			((== gEgoState 11)
				(Load rsVIEW 441)
				(Load rsVIEW 445)
				(aLclothes ignoreActors: init:)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'smell,smell,smell')
				(Print 440 0) ; "Suddenly, you feel hungry for tuna."
			)
			(
				(or
					(Said 'strip')
					(Said
						'(alter,alter<(out<of),from),(off<get),(get<off),drain/cloth,dress,dress,cloth'
					)
					(Said 'dress<get,get')
					(Said 'get,get/dress')
					(Said
						'wear,get,get,(alter,alter<in,to),(drop<on)//cloth,cloth[<leisure]'
					)
					(Said
						'wear,get,get,(alter,alter<in,to),(drop<on)/cloth,cloth[<leisure]'
					)
				)
				(cond
					((not (gEgo inRect: 121 127 199 159))
						(NotClose) ; "You're not close enough."
					)
					((!= gEgoState 11)
						(Print 440 1) ; "You have no desire to wear women's clothing again."
						(Print 440 2) ; "Well, perhaps a little desire."
						(Print 440 3) ; "But you'll do your best to sublimate it!"
					)
					(else
						(self changeState: 33)
					)
				)
			)
			((Said 'look,look>')
				(cond
					((Said '/burn,burn,ceiling')
						(Print 440 4) ; "The lights are once again dimmed. You vividly remember how they felt when you were on-stage dancing."
					)
					(
						(and
							(== gEgoState 11)
							(Said '/backstage,carpet')
							(Print 440 5) ; "There they are! Your clothes are still here, right where you left them."
						))
					((Said '/cloth,hat,bra,panties')
						(if (== gEgoState 11)
							(Print 440 5) ; "There they are! Your clothes are still here, right where you left them."
						else
							(Print 440 6) ; "You are so happy to once again be back in your white leisure suit."
							(Print 440 7 #at -1 144) ; "(Although you are becoming more and more fond of cross-dressing!)"
						)
					)
					((Said '/prop,drop,drop')
						(Print 440 8) ; "Say! What the heck are they doing there?"
					)
					((Said '/bottle')
						(Print 440 9) ; "The set pieces here are very strange."
					)
					((Said '[/area,backstage]')
						(Print 440 10) ; "Backstage is an interesting sight. Those set pieces always look so real from out front, but from here you can tell they are merely a facade."
						(Print 440 11 #at -1 144) ; "(Much like your life, Larry!)"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 7)
		(switch (= state newState)
			(0)
			(1
				(gEgo setMotion: MoveTo 155 151 self)
				(aCherri setMotion: MoveTo 210 151 self)
			)
			(2
				(PrintCherri 440 12) ; "Larry! You're so wonderful. You've given me what I've always wanted."
				(aCherri view: 442 setLoop: 0 setMotion: MoveTo 94 151 self)
			)
			(3
				(PrintLarry 440 13) ; "I think you know what I've always wanted!"
			)
			(4
				(aCherri setLoop: 1 cel: 0)
				(= seconds 3)
			)
			(5
				(PrintCherri 440 14) ; "Cherri smiles at you in the darkness, "At last I'll be able to remove this costume, never to wear it again!""
				(gMusic number: 8 loop: -1 play:)
				(= seconds 3)
			)
			(6
				(aCherri cycleSpeed: 1 setCycle: End self)
			)
			(7
				(aCherri setLoop: 2 cel: 0)
				(aHat ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(8
				(aCherri setCycle: End self)
			)
			(9
				(aCherri setLoop: 3 cel: 0)
				(aTail ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(10
				(aCherri setCycle: End self)
			)
			(11
				(aBra ignoreActors: init: stopUpd:)
				(= seconds 3)
			)
			(12
				(aCherri
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 114 151 self
				)
			)
			(13
				(PrintCherri 440 15) ; "What are you? Modest? Hurry up, Larry, the second show's about to start."
				(= seconds 3)
			)
			(14
				(Print 440 16) ; "You carefully consider her offer..."
				(Print 440 17) ; "...but not for long!"
				(= gEgoState 1)
				(gEgo
					viewer: 0
					view: 442
					loop: 4
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(15
				(aLclothes ignoreActors: init: stopUpd:)
				(gEgo setLoop: 6 cel: 0 setCycle: Walk)
				(= seconds 2)
			)
			(16
				(aCherri loop: 7 cel: 0 setCycle: End)
				(gEgo setMotion: MoveTo 145 151 self)
			)
			(17
				(aCherri dispose:)
				(gEgo
					view: 443
					loop: 0
					cel: 0
					posn: 114 151
					setCycle: End self
				)
			)
			(18
				(= seconds 3)
			)
			(19
				(PrintCherri 440 18) ; "Oh, Larry!" cries Cherri. "Don't you just love the real estate business?!"
				(= seconds 3)
			)
			(20
				(if (< gFilthLevel 1)
					(self changeState: 24)
				else
					(gEgo viewer: humpCycler loop: 1 cel: 0 setCycle: Fwd)
					(= seconds 3)
				)
			)
			(21
				(if (<= gFilthLevel 2)
					(self changeState: 24)
				else
					(gEgo loop: 2)
					(= seconds 3)
				)
			)
			(22
				(if (<= gFilthLevel 3)
					(self changeState: 24)
				else
					(gEgo loop: 3)
				)
				(= seconds 3)
			)
			(23
				(if (< gFilthLevel 4)
					(self changeState: 24)
				else
					(gEgo loop: 4)
				)
				(= seconds 3)
			)
			(24
				(PrintCherri 440 19) ; "Oh, Larry! I could go on like this all night!"
				(= seconds 3)
			)
			(25
				(PrintLarry 440 20) ; "You're the only one!"
				(= seconds 3)
			)
			(26
				(gMusic number: 10 loop: -1 play:)
				(gCurRoom drawPic: 99 2)
				(gCast eachElementDo: #hide)
				(PrintLarry 440 21) ; "Who turned out that light?"
				(= cycles 11)
			)
			(27
				(PrintLarry 440 22) ; "What's that drum roll!?"
				(= seconds 3)
			)
			(28
				(PrintCherri 440 23) ; "Oh, no!!" she cries, "Quick, Larry! Get dressed! The second show is starting!!"
				(= seconds 3)
			)
			(29
				(Print 440 24) ; "You both scramble to find, sort, and wear whatever articles of clothing you can!"
				(= seconds 3)
			)
			(30
				(PrintLarry 440 25) ; "Geez, it's dark, Cherri," you shout, "I can't tell what's what!"
				(= seconds 3)
			)
			(31
				(Print 440 26 #at 10 5 #width 290) ; "The public address system booms, "Lady and gentlemen, welcome to `Nontoonyt For You,' our spectacular tribute to the thing we all love most.""
				(= seconds 2)
			)
			(32
				(PrintLarry 440 27) ; "Where's my pants?"
				(gTheWindow color: gTextColor back: gBackgroundColor)
				(gCurRoom newRoom: 431)
			)
			(33
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 155 151 self)
			)
			(34
				(gEgo
					viewer: 0
					view: 445
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(35
				(aHat posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo setLoop: 1 cel: 0 setCycle: End self)
			)
			(36
				(aTail posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
			)
			(37
				(aBra posn: 155 151 ignoreActors: init: stopUpd:)
				(gEgo loop: 3 cel: 0 setCycle: End self)
				(= cycles 9)
			)
			(38
				(aLclothes dispose:)
			)
			(39
				(= gShowroomState 6)
				(= gNewspaperState 3)
				(= gEgoState 18)
				(= gNormalEgoView 700)
				(NormalEgo 1 444)
				(gEgo viewer: shadowViewer)
				(gGame changeScore: 25)
				(= cycles 22)
			)
			(40
				(Print 440 28) ; "Ah! Now that feels like home."
			)
		)
	)
)

(instance aCherri of Act
	(properties
		y 151
		x 290
		view 446
		illegalBits 0
	)
)

(instance aHat of View
	(properties
		y 144
		x 63
		view 440
	)
)

(instance aTail of View
	(properties
		y 148
		x 93
		view 440
		cel 1
	)
)

(instance aBra of View
	(properties
		y 143
		x 83
		view 440
		cel 2
	)
)

(instance aLclothes of View
	(properties
		y 145
		x 150
		view 440
		cel 3
	)
)

(instance theCage of Cage
	(properties)
)

(instance shadowViewer of Code
	(properties)

	(method (doit)
		(gEgo
			view:
				(cond
					((not (& (gEgo onControl: 1) $0200)) gNormalEgoView)
					((== gEgoState 11) 441)
					((!= gEgoState 1) 444)
					(else
						(Print 440 29) ; "error"
					)
				)
		)
	)
)

(instance humpCycler of Code
	(properties)

	(method (doit)
		(if (not (Random 0 9))
			(gEgo cycleSpeed: (Random 0 5))
		)
	)
)

