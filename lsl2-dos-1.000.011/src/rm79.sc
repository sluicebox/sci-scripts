;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 79)
(include sci.sh)
(use Main)
(use Airplane)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm79 0
)

(local
	work
	aWater1
	aWater2
	aSteam
	aPlane
	aLimb
	restoreX
	restoreY
	aChief
	aMouth
)

(instance theSound of Sound
	(properties)
)

(instance rm79 of Rm
	(properties
		picture 79
		horizon 5
	)

	(method (init)
		(Load rsVIEW 725)
		(Load rsVIEW 103)
		(Load rsVIEW 179)
		(Load rsSOUND 1)
		(super init:)
		(theSound number: 1 init:)
		((= aWater1 (Prop new:))
			view: 725
			setLoop: 2
			posn: 27 189
			setPri: 8
			cycleSpeed: 1
			setCycle: Fwd
			init:
		)
		((= aWater2 (Prop new:))
			view: 725
			setLoop: 1
			posn: 37 175
			setPri: 8
			setCycle: Fwd
			init:
		)
		((= aPlane (Airplane new:))
			view: 725
			posn: 444 44
			setPri: 5
			setStep: 2 1
			startX: 444
			startY: 44
			endX: -44
			endY: 44
			init:
			setLoop: 0
			setCycle: Fwd
		)
		((= aLimb (Act new:))
			view: 725
			setLoop: 3
			setPri: 14
			setStep: 1 9
			posn: 202 60
			cycleSpeed: 2
			illegalBits: 0
			stopUpd:
			ignoreActors:
			init:
		)
		(self setScript: rm79Script)
		(NormalEgo)
		(if (== gIslandStatus 2)
			(= gIslandStatus 3)
			(= gCurrentStatus 11)
			(Load rsVIEW 710)
			((= aMouth (Prop new:))
				view: 710
				ignoreActors:
				setLoop: 4
				posn: 999 999
				setCycle: Fwd
				setPri: 14
				init:
			)
			((= aChief (Act new:))
				view: 710
				setCycle: Walk
				cycleSpeed: 1
				moveSpeed: 1
				posn: 210 189
				init:
			)
			(rm79Script changeState: 1)
		)
		(gEgo loop: 3 posn: 250 186 init:)
	)
)

(instance rm79Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (== 3 (gEgo edgeHit:)) (== gCurrentStatus 0))
				(gCurRoom newRoom: 76)
			)
			((and (& (gEgo onControl:) $0002) (== gCurrentStatus 0))
				(gEgo setPri: 14)
				(self changeState: 19)
			)
			((and (& (gEgo onControl:) $0004) (== gCurrentStatus 0))
				(gEgo setPri: 8)
				(self changeState: 19)
			)
			((and gDebugging (== gCurrentStatus 0))
				(= restoreX (gEgo x:))
				(= restoreY (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/palm')
				(Print 79 0) ; "A dead tree is conveniently located just out of your reach on the other side of the chasm."
				(Print 79 1) ; "One of its branches hangs out over the chasm."
			)
			(if (Said '/fern,leaf,bush')
				(Print 79 2) ; "It's a member of the fern family and one of the first true trees. Its species is over 300-million years old. Since most of the jokes in this game come from the same era, it seems appropriate."
			)
			(if (Said '/airline')
				(Print 79 3) ; "There's a lot of air traffic here, for a remote, tropical island."
			)
			(if (Said '[/airport,canyon,hill,path,canyon,boulder]')
				(Print 79 4) ; "A terribly deep chasm extends around the tongue of rock upon which you are standing. If you didn't know better, you'd think a guy could get hurt around here!"
				(Print 79 5) ; "In the distance you see the island's volcano, ringed with a glacier, not at the top as you'd expect, but near the bottom of some vertical cliffs."
			)
		)
		(if (Said '/branch')
			(Print 79 6) ; "You can't reach it from here, but it looks sturdy."
		)
		(if (Said 'hop')
			(Print 79 7) ; "There's no way you could make it across that chasm standing way back here!"
			(Print 79 8 #at -1 152) ; "(Heh, heh, heh.)"
		)
		(if (Said 'fill/bag/beach')
			(Print 79 9) ; "A good idea, but unnecessary here."
		)
		(if (or (Said 'afix/landscape/bag') (Said 'afix/bag/landscape'))
			(Print 79 9) ; "A good idea, but unnecessary here."
		)
		(if (Said 'apply,throw/landscape')
			(cond
				((not (gEgo has: 29)) ; Vine
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(self changeState: 8)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(aChief setMotion: MoveTo 127 134 self)
			)
			(2
				(aChief loop: 0)
				(= seconds 3)
			)
			(3
				(Print 79 10 #at -1 152) ; "(The old boy's got some sense of balance!)"
				(aMouth posn: (+ (aChief x:) -1) (+ (aChief y:) -26))
				(= seconds 3)
			)
			(4
				(Print 79 11) ; "Here we are, son," says Chief Kenawauwau, "this is the secret of my people; the way to our sacred volcano; right across this chasm!"
				(= seconds 3)
			)
			(5
				(Print 79 12 #at -1 152) ; "(Some secret?! Any fool could see that!)"
				(Print 79 13) ; "Kenawauwau continues, "Of course, any fool could see that; what's important is: you must cross this chasm, climb the recent icy glacier, walk the treacherous paths, and penetrate the impenetrable fortress of the evil Dr. Nonookee!""
				(Print 79 14) ; "By the way, did I mention that my daughter is a virgin?"
				(gGame changeScore: 25)
				(= seconds 3)
			)
			(6
				(Print 79 15) ; "Ok, catch you later!" he says, "I must go lead the village's afternoon aerobics class!"
				(Print (Format @gString 79 16 gTritePhrase)) ; "%s"
				(aMouth dispose:)
				(aChief setMotion: MoveTo 270 234 self)
			)
			(7
				(aChief dispose:)
				(NormalEgo)
				(++ gIslandStatus)
			)
			(8
				(HandsOff)
				(gEgo view: 179 loop: 0 cel: 0 setCycle: End self)
			)
			(9
				(if (& (gEgo onControl: 1) $0008)
					(self changeState: 11)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(10
				(NormalEgo 3)
			)
			(11
				(= gCurrentStatus 1)
				(gEgo
					loop: 1
					cel: 0
					posn: 174 56
					setPri: 10
					illegalBits: 0
					ignoreControl: 2 4
					cycleSpeed: 1
					put: 29 -1 ; Vine
				)
				(aLimb setCycle: End self)
			)
			(12
				(gEgo setCycle: End self)
			)
			(13
				(Print 79 17 #at -1 20 #draw) ; "You made it!"
				(gGame changeScore: 11)
				(= seconds 3)
			)
			(14
				(gEgo
					setLoop: 2
					cel: 0
					posn: 171 106
					setPri: 6
					setCycle: End self
				)
				(aLimb setPri: 8 setMotion: MoveTo (aLimb x:) 234 self)
			)
			(15
				(gEgo view: 100 setLoop: 2 cycleSpeed: 0 setCycle: Walk)
			)
			(16
				(Print 79 18 #draw) ; "You set forth on your mission to explore the unknown mountain before you, knowing full well that you will never be able to return this way again!"
				(Print 79 19) ; "What lies before you?"
				(Print 79 20) ; "Will you be able to climb the icy glacier?"
				(Print 79 21) ; "Will you find the evil Doctor's mountaintop fortress?"
				(Print 79 22) ; "Will you destroy the evil Dr. Nonookee?"
				(Print 79 23) ; "Will you return to your beloved Kalalua?"
				(Print 79 24) ; "Will you find love?"
				(Print 79 25) ; "Will you find happiness?"
				(Print 79 26 #at -1 152) ; "(Will you stop asking all these questions and get on with the game?!)"
				(gEgo setLoop: 3 setMotion: MoveTo 171 104 self)
			)
			(17
				(gEgo setPri: 2 setMotion: MoveTo 171 140 self)
			)
			(18
				(gCurRoom newRoom: 80)
			)
			(19
				(HandsOff)
				(Print 79 27 #at -1 20 #dispose) ; "Oh, shhhhhhhh..."
				(= gCurrentStatus 12)
				(theSound play:)
				(gEgo
					view: 103
					illegalBits: 0
					ignoreActors:
					posn: (gEgo x:) (- (gEgo y:) 15)
					cel: 0
					setStep: 1 15
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 200) self
				)
			)
			(20
				(cls)
				(= gCurrentStatus 1000)
				(Print 79 28) ; "Treacherous little first step, isn't it?"
				(= gCurrentStatus 1001)
				(if (== gDebugging 1)
					(NormalEgo)
					(gEgo posn: restoreX restoreY)
					(self changeState: 10)
				)
			)
		)
	)
)

