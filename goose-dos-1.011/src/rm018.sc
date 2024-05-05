;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm018 0
)

(local
	local0
	local1
)

(instance rm018 of Rm
	(properties
		picture 18
		style 0
		horizon 115
		north 11
		east 19
		south 25
		west 17
		vanishingY -99
	)

	(method (init)
		(Load rsSOUND 19)
		(Load rsVIEW 145)
		(Load rsVIEW 60)
		(Load rsVIEW 90)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(11
				(cond
					((and (> (gEgo x:) 130) (< (gEgo x:) 161))
						(gEgo posn: 130 117)
					)
					((and (> (gEgo x:) 160) (< (gEgo x:) 190))
						(gEgo posn: 190 117)
					)
					(else
						(gEgo y: (+ horizon 1))
					)
				)
			)
			(19
				(cond
					((> (gEgo y:) 165)
						(gEgo y: 185)
					)
					((> (gEgo y:) 148)
						(gEgo y: 148)
					)
				)
			)
			(17
				(cond
					((> (gEgo y:) 165)
						(gEgo y: 185)
					)
					((> (gEgo y:) 148)
						(gEgo y: 148)
					)
				)
			)
			(25
				(gEgo x: (+ (/ (* (- (gEgo x:) 77) 158) 83) 1))
			)
			(else
				(gEgo posn: 160 150)
			)
		)
		(gEgo init:)
		(proc0_10)
		(gAddToPics add: atpSign banburyKnight doit:)
		(if [global675 18]
			(horsey init:)
		)
		(if (and (not [global675 18]) (proc0_11 60))
			(= [global675 18] 1)
			(gGlobalMGSound loop: 0 stop:)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 7)
				)
				(2
					(gGame setSpeed: 8)
				)
			)
			(gCurRoom setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 10)
						(== local1 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 10) (== local1 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 10) (== local1 1))
					(rhymeScript cycles: 1)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= global209 1)
				(HandsOff)
				(if
					(and
						(< (gEgo y:) 118)
						(> (gEgo x:) 115)
						(< (gEgo x:) 203)
					)
					(gEgo
						setAvoider: Avoid
						setMotion:
							MoveTo
							(if (< (gEgo x:) 160) 105 else 215)
							120
							self
					)
				else
					(gEgo setAvoider: Avoid)
					(= cycles 1)
				)
			)
			(1
				(proc0_18)
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(if (< (gEgo x:) 160) 120 else 200)
						180
						self
				)
			)
			(2
				(proc0_17)
				(RedrawCast)
				(gEgo setLoop: 3 setScript: musicScript stopUpd:)
				(= seconds 1)
			)
			(3
				(horse init:)
			)
			(4
				(if (< global131 1)
					(= cycles 1)
				else
					0
				)
			)
			(5
				(horse setLoop: 2 setCycle: Fwd)
				(if (< global131 1)
					(= seconds global122)
				else
					0
				)
			)
			(6
				(horse setLoop: 1)
				(if (< global131 1)
					(= seconds global122)
				else
					0
				)
			)
			(7
				(horse setLoop: 0 setCycle: Walk setMotion: MoveTo 340 131 self)
			)
			(8
				(horse dispose:)
				(gEgo setPri: 12 setMotion: MoveTo 161 150 self)
			)
			(9
				(horsey init:)
				(gEgo setLoop: 2)
				(= seconds 1)
			)
			(10
				(gEgo
					setMotion: 0
					setAvoider: 0
					setCycle: Walk
					setLoop: -1
					setPri: -1
				)
				(= local0 0)
				(= global103 0)
			)
			(11
				(gGame setSpeed: global206)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(proc0_12)
				(rhymeBox dispose:)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 160 180)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local1 1)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(Display
					{Ride a cockhorse to Banbury Cross,}
					dsWIDTH
					320
					dsCOORD
					5
					5
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2
				(Display
					{To see a fine lady upon a white horse.}
					dsWIDTH
					320
					dsCOORD
					5
					17
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(if (> global131 0)
					(rhymeScript cue:)
				)
				(Display
					{Rings on her fingers,}
					dsWIDTH
					320
					dsCOORD
					5
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(if (> global131 0)
					(rhymeScript cue:)
				)
				(Display
					{______and bells on her toes,}
					dsWIDTH
					320
					dsCOORD
					115
					29
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(if (> global131 0)
					(rhymeScript cue:)
				)
				(Display
					{She shall have music wherever she goes.}
					dsWIDTH
					320
					dsCOORD
					5
					41
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 19
		priority 10
	)
)

(instance horse of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 90
			posn: -20 130
			setLoop: 0
			setCycle: Walk
			cycleSpeed: 0
			xStep: 3
			yStep: 2
			setMotion: MoveTo 160 160 rhymeScript
		)
	)
)

(instance horsey of View
	(properties)

	(method (init)
		(super init:)
		(self view: 60 setPri: 10 setLoop: 0 setCel: 0 posn: 159 121 stopUpd:)
	)
)

(instance banburyKnight of PV
	(properties
		y 115
		x 162
		view 145
		cel 1
		priority 10
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 15
			bottom: 65
			right: 305
			type: 4
			title: {Banbury Cross}
			back: 10
		)
	)
)

(instance atpSign of PV
	(properties
		y 138
		x 160
		view 145
		loop 4
		priority 10
		signal 16384
	)
)

