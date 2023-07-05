;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm250 0
)

(local
	onSteps
	seenMsg
	seenCasinoMsg
	seenNativesMsg
	sharpenCount
	[string 200]
)

(procedure (PrintPlot &tmp t)
	(Print @string #at 10 5 #width 290 #time (= t (PrintDelay @string)) #dispose)
	(return (+ 3 t))
)

(instance rm250 of Rm
	(properties
		picture 250
		south 260
	)

	(method (init)
		(if (and (gEgo has: 2) (== ((Inv at: 2) view:) 2)) ; Ginsu_Knife, Ginsu_Knife
			(Load rsVIEW 251)
			(Load rsVIEW 709)
			(Load rsVIEW 2)
			(Load rsSOUND 250)
		)
		(if (== gEgoState 4)
			(self style: 7)
		)
		(super init:)
		(self setScript: RoomScript)
		(if (not (TestFlag 22))
			(Load rsVIEW 53)
		)
		(if (and (TestFlag 22) (not (TestFlag 29)))
			(Load rsVIEW 252)
			(aCredit1 init:)
			(aCredit2 init:)
		)
		(if (> gMachineSpeed 16)
			(aFountain init:)
		)
		(cond
			((== gPrevRoomNum 305)
				(gEgo posn: 2 186)
				(= seenNativesMsg 1)
			)
			((== gPrevRoomNum 220)
				(gEgo posn: 2 122)
			)
			((== gPrevRoomNum 253)
				(gEgo posn: 317 125)
			)
			((== gPrevRoomNum 260)
				(gEgo posn: 154 187 loop: 3)
			)
			(else
				(= onSteps 1)
				(gEgo posn: 317 118 loop: 1)
			)
		)
		(NormalEgo)
		(if onSteps
			(gEgo setPri: 11 observeControl: 16384 init:)
		else
			(gEgo observeControl: 8192 init:)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (gEgo edgeHit:)
			(cond
				((& (gEgo onControl:) $0002)
					(gCurRoom newRoom: 305)
				)
				((& (gEgo onControl:) $0008)
					(gCurRoom newRoom: 220)
				)
				((& (gEgo onControl:) $0010)
					(if onSteps
						(gCurRoom newRoom: 400)
					else
						(gCurRoom newRoom: 253)
					)
				)
			)
		)
		(cond
			((== onSteps -1))
			((& (gEgo onControl:) $1000)
				(= onSteps 1)
			)
			((& (gEgo onControl:) $0800)
				(= onSteps 0)
			)
		)
		(if (== onSteps 1)
			(gEgo setPri: 11 observeControl: 16384 ignoreControl: 8192)
		)
		(if (== onSteps 0)
			(gEgo setPri: -1 ignoreControl: 16384 16 observeControl: 8192)
		)
		(if (and (& (gEgo onControl:) $0002) (or gEgoIsPatti (!= gEgoState 0)))
			(if (not seenNativesMsg)
				(= seenNativesMsg 1)
				(gEgo
					posn: (gEgo xLast:) (gEgo yLast:)
					setMotion: 0
					observeControl: 2
				)
				(if gEgoIsPatti
					(Print 250 0) ; "You have no business in "Natives, Inc.," Patti. There's nothing in there to help you find Larry!"
				else
					(Print 250 1) ; "You can't enter "Natives, Inc." dressed like that!"
				)
				(Animate (gCast elements:) 0)
			)
		else
			(= seenNativesMsg 0)
		)
		(if
			(and
				(& (gEgo onControl:) $0010)
				onSteps
				(!= gEgoState 11)
				(!= gEgoState 0)
			)
			(if (not seenCasinoMsg)
				(= seenCasinoMsg 1)
				(gEgo
					posn: (gEgo xLast:) (gEgo yLast:)
					setMotion: 0
					observeControl: 16
				)
				(Print 250 2) ; "You can't enter the casino dressed like that!"
				(Animate (gCast elements:) 0)
			)
		else
			(= seenCasinoMsg 0)
		)
		(if (& (gEgo onControl:) $0004)
			(if (not seenMsg)
				(= seenMsg 1)
				(ShakeScreen 1 ssLEFTRIGHT)
				(Print 250 3) ; "Ow!"
				(Print 250 4 #at -1 144) ; "(There must not be a path that way!)"
			)
		else
			(= seenMsg 0)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'caress,sharpen/ginsu>')
			(cond
				((not (gEgo has: 2)) ; Ginsu_Knife
					(DontHave) ; "You don't have it."
				)
				((== ((Inv at: 2) view:) 21) ; Ginsu_Knife
					(ItIs) ; "It is."
				)
				((Said '/[/!*]')
					(Print 250 5) ; "On what?"
				)
				((Said '//fountain,barstool,barstool')
					(Print 250 6) ; "The fountain's rough surface would only dull your knife."
				)
				((not (Said '//stair,carpet'))
					(Print 250 7) ; "That would never sharpen a fine ginsu knife."
				)
				((not onSteps)
					(Print 250 8) ; "Move closer to the steps."
				)
				((!= gEgoState 0)
					(NotNow) ; "Good idea. You might try that again later."
				)
				(else
					(self changeState: 6)
				)
			)
			(event claimed: 1)
		)
		(if (Said 'look>')
			(cond
				((Said '/palm,bush,carpet')
					(Print 250 9) ; "The landscaping of the casino blends nicely into the jungle beyond."
				)
				((Said '/cannibal,office')
					(if gEgoIsPatti
						(Print 250 10 gEgoName) ; "You have no need to go that way, %s."
					else
						(Print 250 11) ; "Down the pathway to the lower left is the headquarters of "Natives, Inc.""
					)
				)
				((Said '/water,cascade,fountain')
					(Print 250 12) ; "Isn't it beautiful?"
				)
				((Said '/stair,exit,carpet')
					(Print 250 13) ; "The steps leading into the casino are made of smooth concrete... as smooth as a sharpening stone."
				)
				((Said '[/area]')
					(Print 250 14) ; "You are outside the island's casino. Steps lead up into the lobby, while water splashes merrily down the fountain."
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (TestFlag 22))
					(= cycles 25)
				)
			)
			(1
				(Format @string 250 15) ; "Down this path lies your office. Say, what about that cute little redhead in accounting? You've always wanted a chance to balance her figures!"
				(= seconds (PrintPlot))
				(aCredit1 view: 53 posn: 0 156 setCycle: Fwd init:)
				(= seconds 13)
			)
			(2
				(Format @string 250 16) ; "It IS nearly time to start work. You'd better hurry, Larry! You're going to be late again and you know how much Chairman Kenneth hates tardiness."
				(= seconds (PrintPlot))
			)
			(3
				(Format @string 250 17) ; ""I hope this trouble with Kalalau doesn't influence my excellent working relationship with Chairman Kenneth," you think."
				(= seconds (PrintPlot))
			)
			(4
				(SetFlag 22)
				(Format @string 250 18) ; "Surely, it won't make any difference to Ken. My meteoric rise through the ranks of `Natives, Inc.' is because of my superior managerial abilities, not just because I married the boss' daughter!"
				(= seconds (PrintPlot))
			)
			(5
				(aCredit1 dispose:)
				(= seconds 0)
			)
			(6
				(Ok) ; "O.K."
				(HandsOff)
				(= onSteps -1)
				(gEgo illegalBits: 0 setMotion: MoveTo 278 134 self)
			)
			(7
				(gEgo
					view: 709
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(8
				(Print 250 19 #icon 2 0 0) ; "You rub your dull ginsu knife back and forth on the smooth concrete steps of the casino."
				(= sharpenCount 0)
				(= seconds 2)
				(= gOldGameSpeed (gGame setSpeed: 6))
			)
			(9
				(gSoundFX number: 250 loop: 1 play:)
				(gEgo view: 251 cel: 0 setCycle: End)
				(= cycles 7)
				(if (< (++ sharpenCount) 11)
					(-- state)
				)
			)
			(10
				((Inv at: 2) view: 21) ; Ginsu_Knife
				(Format ((Inv at: 2) name:) 250 20) ; "Sharp Knife", Ginsu_Knife
				(gSoundFX stop:)
				(gGame setSpeed: gOldGameSpeed changeScore: 50)
				(gEgo view: 709 loop: 0 setCel: 255 setCycle: Beg self)
			)
			(11
				(NormalEgo)
				(= onSteps 0)
				(Print 250 21) ; "Much to your surprise, it becomes razor sharp! Without thinking, you hastily shove it back in your pocket."
				(Print 250 22) ; "OW!"
			)
		)
	)
)

(instance aFountain of Prop
	(properties
		y 148
		x 194
		view 250
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self isExtra: 1 setCycle: Fwd setPri: 11)
	)
)

(instance aCredit1 of Prop
	(properties
		y 131
		x 288
		view 252
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors:)
	)
)

(instance aCredit2 of Prop
	(properties
		y 154
		x 288
		view 252
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreActors: setScript: CreditsScript)
	)
)

(instance CreditsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aCredit1 setCycle: End)
				(= cycles 13)
			)
			(2
				(aCredit2 setCycle: End)
				(= cycles 16)
			)
			(3
				(aCredit2 setCycle: Beg self)
			)
			(4
				(aCredit2 loop: 2 setCycle: End)
				(= cycles 16)
			)
			(5
				(aCredit2 setCycle: Beg self)
			)
			(6
				(aCredit2 loop: 3 setCycle: End)
				(= cycles 16)
			)
			(7
				(aCredit2 setCycle: Beg self)
			)
			(8
				(aCredit2 loop: 4 setCycle: End)
				(= cycles 16)
			)
			(9
				(SetFlag 29)
				(aCredit1 setCycle: Beg)
				(aCredit2 setCycle: Beg self)
			)
			(10
				(aCredit1 dispose:)
				(aCredit2 dispose:)
			)
		)
	)
)

