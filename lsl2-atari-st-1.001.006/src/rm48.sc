;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use BassSetter)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm48 0
)

(local
	loopCount
	safeX
	safeY
	oldScore
	localBS
)

(procedure (TripDone)
	(theSound stop:)
	(cls)
	(+= gScore 1)
	(SL doit:)
	(Print 48 0 #at -1 20 #time 5 #draw) ; "That was close. You'd better be more careful!"
)

(instance theSound of Sound
	(properties
		number 13
	)
)

(instance rm48 of Rm
	(properties
		picture 48
		horizon 1
	)

	(method (init)
		(Load rsVIEW 156)
		(Load rsVIEW 157)
		(Load rsVIEW 158)
		(Load rsVIEW 159)
		(Load rsVIEW 151)
		(Load rsSOUND 13)
		(Load rsSOUND 14)
		(Load rsSOUND 15)
		(super init:)
		(theSound init:)
		(self setScript: rm48Script)
		(= oldScore gScore)
		(= gCurrentEgoView 151)
		(NormalEgo)
		(gEgo
			posn: 312 83
			setPri: 11
			setStep: 3 1
			loop: 1
			init:
			baseSetter: (= localBS (BassSetter new:))
		)
		(localBS radii: 6)
		(HandsOff)
	)
)

(instance rm48Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (& (gEgo onControl:) $1000) (== state 11))
				(self changeState: 12)
			)
			((and (& (gEgo onControl:) $0800) (== state 8))
				(self changeState: 9)
			)
			((and (& (gEgo onControl:) $0400) (== state 5))
				(self changeState: 6)
			)
			((and (& (gEgo onControl:) $0200) (== state 1))
				(self changeState: 2)
			)
			((and (& (gEgo onControl:) $0010) (== state 11))
				(self changeState: 25)
			)
			((and (& (gEgo onControl:) $0008) (== state 8))
				(self changeState: 21)
			)
			((and (& (gEgo onControl:) $0004) (== state 5))
				(self changeState: 18)
			)
			((and (& (gEgo onControl:) $0002) (== state 1))
				(self changeState: 15)
			)
			((or (== state 1) (== state 5) (== state 8) (== state 11))
				(= safeX (gEgo x:))
				(= safeY (gEgo y:))
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(if (Said '/me')
				(Print 48 1) ; "You've always been afraid of heights."
			)
			(if (Said 'dive,hop')
				(Print 48 2) ; "You die on the rocks below."
				(Print 48 3 #at -1 152) ; "(The idea is to NOT do that!)"
			)
			(if (Said '[/airport,hill,cliff]')
				(Print 48 4) ; "The cliffs drop precipitously off into the pounding surf directly below. Be careful, Larry: a fall from this height could be fatal!"
			)
		)
		(if
			(or
				(Said 'alter,wear,(drop<on)/bra,bra')
				(Said 'alter,drain,(get<off)/(bra<bathing),bikini,job')
				(Said 'get<dress')
			)
			(if (!= state 13)
				(Print 48 5) ; "Not now. Maybe later!"
			else
				(gGame changeScore: 6)
				(+= oldScore 6)
				(if (== gBraContents 6)
					(Print 48 6) ; "Ok. You transfer your money from the bikini top to your leisure suit, then toss the bikini far over the cliff. As you slip into your leisure suit you realize you were beginning to enjoy wearing women's clothing!"
				else
					((gInventory at: 18) moveTo: -1) ; Soap
					(Print 48 7) ; "Ok. You slip back into your leisure suit and toss the bikini and soap far over the cliff. Too bad, as you were beginning to enjoy wearing women's clothing!"
				)
				(Print 48 8 #at -1 152) ; "(At least you still have your beautiful, long blond hair!)"
				(= gCurrentEgoView 149)
				(= gBraContents 0)
				(gEgo view: gCurrentEgoView)
				((gInventory at: 15) moveTo: -1) ; Bikini_Top
				((gInventory at: 16) moveTo: -1) ; Bikini_Bottom
				(= cycles 5)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(User canControl: 1 canInput: 1)
				(Print 48 9) ; "Ohmigosh! How will a guy as clumsy as you are, ever manage to hike a trail as narrow as this?"
			)
			(2
				(HandsOff)
				(theSound dispose:)
				(gEgo
					illegalBits: 0
					setPri: 10
					setMotion: MoveTo 220 95 self
				)
			)
			(3
				(gEgo setPri: 9 setMotion: MoveTo 270 95 self)
			)
			(4
				(= gCurrentEgoView 157)
				(gEgo
					view: 157
					setPri: 9
					setStep: 2 1
					setMotion: MoveTo 203 106 self
				)
				(localBS radii: 5)
			)
			(5
				(User canControl: 1 canInput: 1)
				(gEgo illegalBits: -32768)
			)
			(6
				(HandsOff)
				(theSound dispose:)
				(gEgo
					illegalBits: 0
					setPri: 8
					setMotion: MoveTo (+ (gEgo x:) 44) (gEgo y:) self
				)
			)
			(7
				(= gCurrentEgoView 158)
				(gEgo
					view: 158
					setPri: 7
					setStep: 1 1
					posn: (gEgo x:) 99
					setMotion: MoveTo 132 99 self
				)
				(localBS radii: 4)
			)
			(8
				(User canControl: 1 canInput: 1)
				(gEgo illegalBits: -32768)
			)
			(9
				(HandsOff)
				(theSound dispose:)
				(gEgo
					illegalBits: 0
					setPri: 6
					setMotion: MoveTo (+ (gEgo x:) 12) (gEgo y:) self
				)
			)
			(10
				(= gCurrentEgoView 159)
				(gEgo
					view: 159
					setPri: 5
					posn: 99 123
					setMotion: MoveTo 65 123 self
				)
				(localBS radii: 3)
			)
			(11
				(User canControl: 1 canInput: 1)
				(gEgo illegalBits: -32768)
			)
			(12
				(HandsOff)
				(gEgo
					illegalBits: 0
					setPri: 4
					setMotion: MoveTo (+ (gEgo x:) 22) (gEgo y:) self
				)
			)
			(13
				(User canControl: 0 canInput: 1)
				(= gCurrentEgoView 151)
				(gEgo hide: view: 151 baseSetter: 0)
				(if localBS
					(localBS dispose:)
				)
				(Print 48 10) ; "Pausing a moment, you catch your breath before crossing the airport parking lot to the terminal building..."
				(Print 48 11) ; "...and your escape from that wonderful tropical resort!"
				(= cycles 50)
			)
			(14
				(= cycles 0)
				(Print 48 12) ; "Well rested, you stride boldly across the dirt parking lot to the front door of the main terminal building."
				(if (!= gScore oldScore)
					(= gScore oldScore)
					(SL doit:)
					(Print 48 13 #at -1 152) ; "(By the way, you didn't think you were going to keep all those free points, did you?)"
				)
				(gCurRoom newRoom: 50)
			)
			(15
				(HandsOff)
				(gEgo
					view: 156
					illegalBits: 0
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(Print 48 14 #at -1 20 #dispose #draw) ; "Larry! LOOK OUT!!"
			)
			(16
				(gEgo setCycle: Beg self)
			)
			(17
				(NormalEgo 1)
				(gEgo posn: safeX safeY setPri: 11 setStep: 3 1)
				(= state 1)
				(TripDone)
			)
			(18
				(HandsOff)
				(theSound number: 13 play:)
				(gEgo illegalBits: 0 setLoop: 4 cel: 0 setCycle: End self)
				(Print 48 14 #at -1 20 #dispose #draw) ; "Larry! LOOK OUT!!"
			)
			(19
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(20
				(NormalEgo 1)
				(gEgo posn: safeX safeY setPri: 9 setStep: 2 1)
				(= state 5)
				(TripDone)
			)
			(21
				(HandsOff)
				(gEgo illegalBits: 0 setLoop: 4 cel: 0 setCycle: End self)
				(theSound number: 14 play:)
				(Print 48 14 #at -1 20 #dispose #draw) ; "Larry! LOOK OUT!!"
			)
			(22
				(gEgo setLoop: 5 cel: 0 setCycle: Fwd)
				(= cycles 22)
			)
			(23
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(24
				(NormalEgo 1)
				(gEgo posn: safeX safeY setPri: 7 setStep: 1 1)
				(= state 8)
				(TripDone)
			)
			(25
				(HandsOff)
				(gEgo illegalBits: 0 setLoop: 4 cel: 0 setCycle: End self)
				(theSound number: 15 play:)
				(= loopCount 0)
				(Print 48 14 #at -1 20 #dispose #draw) ; "Larry! LOOK OUT!!"
			)
			(26
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
				(if (> 3 (++ loopCount))
					(-- state)
				)
			)
			(27
				(gEgo setLoop: 4 setCel: 255 setCycle: Beg self)
			)
			(28
				(NormalEgo 1)
				(gEgo posn: safeX safeY setPri: 5 setStep: 1 1)
				(= state 11)
				(TripDone)
			)
		)
	)
)

