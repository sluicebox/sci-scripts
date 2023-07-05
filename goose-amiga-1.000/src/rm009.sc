;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
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
	rm009 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm009 of Rm
	(properties
		picture 9
		style 0
		horizon 100
		north 2
		east 17
		south 16
		west 8
	)

	(method (init)
		(Load rsSOUND 6)
		(Load rsSOUND 30)
		(Load rsVIEW 68)
		(Load rsVIEW 121)
		(Load rsVIEW 42)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(3
				(gEgo posn: 295 104)
			)
			(2
				(gEgo posn: 295 104)
			)
			(10
				(gEgo posn: 295 104)
			)
			(17
				(gEgo posn: 298 178)
			)
			(8 0)
			(16
				(gEgo x: (+ (/ (* (- (gEgo x:) 0) 26) 31) 10) y: 181)
			)
			(else
				(gEgo posn: 160 125)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
		(gEgo init:)
		(proc0_10)
		(if [global675 9]
			(muffetDone init:)
		else
			(tuffet init: addToPic:)
		)
		(if (and (not [global675 9]) (= local1 (proc0_11 42)))
			(= [global675 9] 1)
			(gGlobalMGSound fade:)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 5)
				)
				(2
					(gGame setSpeed: 6)
				)
			)
			(muffet init:)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local3 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 16) (== local3 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 16) (== local3 1))
					(rhymeScript cycles: 1)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 8)
			(gCurRoom newRoom: 17)
		)
		(super doit:)
		(if local2
			(web
				posn: (- (spider x:) 2) (- (spider y:) 7)
				setPri: (- (spider priority:) 1)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global209 1)
				(= global103 1)
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: MoveTo 185 155)
				(= seconds 3)
			)
			(1
				(cond
					((< (muffet y:) 131)
						(muffet setMotion: MoveTo 150 135 self)
					)
					((> (muffet x:) 124)
						(muffet setMotion: MoveTo 125 148 self)
					)
					(else
						(muffet setMotion: MoveTo 118 148 self)
					)
				)
			)
			(2
				(if (> (muffet y:) 126)
					(muffet setMotion: MoveTo 125 148 self)
				else
					(= cycles 1)
				)
			)
			(3
				(proc0_18)
				(muffet setMotion: MoveTo 124 143 self)
			)
			(4
				(LookAt muffet)
				(gEgo setAvoider: 0 setScript: musicScript stopUpd:)
				(muffet view: 68 setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				(if (not global131)
					(= cycles 1)
				else
					0
				)
			)
			(5
				(web init:)
				(spider init: setMotion: MoveTo 102 100 self)
				(= local2 1)
			)
			(6
				(spider setMotion: MoveTo 102 133 self setPri: 10)
			)
			(7
				(spider setLoop: 5 cycleSpeed: 4)
				(= cycles 3)
			)
			(8
				(muffet
					setLoop: 2
					setCel: 0
					cycleSpeed: 0
					setCycle: CT 2 1 self
				)
			)
			(9
				(spider setLoop: 6)
				(= seconds 2)
			)
			(10
				(muffet setCel: 3)
			)
			(11
				(curd init: setCycle: End)
				(muffet setCel: 4)
				(if (not global131)
					(= cycles 6)
				else
					(= cycles 10)
				)
			)
			(12
				(curd addToPic:)
				(muffet
					setLoop: 0
					setCycle: Walk
					setStep: (if global131 4 else 6) (if global131 4 else 6)
					setMotion: MoveTo 340 142 self
				)
			)
			(13
				(spider setLoop: 4 setMotion: MoveTo 102 100 self)
			)
			(14
				(spider setLoop: 6 setMotion: MoveTo 102 70 self setPri: 8)
			)
			(15
				(= local2 0)
				(web dispose:)
				(spider dispose:)
				(gEgo setAvoider: 0 setCycle: Walk setMotion: 0 setLoop: -1)
				(= local0 0)
				(= global103 0)
				(= seconds 3)
			)
			(16)
			(17
				(gGame setSpeed: global206)
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(muffet dispose:)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 165 180)
				else
					(NormalEgo)
					(HandsOn)
					(gGame setSpeed: global206)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local3 1)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 30
		priority 10
	)
)

(instance muffet of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 42
			posn: (local1 x:) (local1 y:)
			yStep: 2
			xStep: 7
			setCycle: Walk
			cycleSpeed: 0
			ignoreActors: 0
			setAvoider: Avoid
			setScript: rhymeScript
		)
	)
)

(instance spider of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 68
			setLoop: 4
			ignoreHorizon: 1
			ignoreControl: -1
			posn: 102 80
			setCycle: Fwd
			cycleSpeed: 2
			setPri: 9
			setStep: 3 3
		)
	)
)

(instance muffetDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 68 setLoop: 2 setCel: 1 posn: 124 142 stopUpd:)
	)
)

(instance tuffet of View
	(properties)

	(method (init)
		(super init:)
		(self view: 121 setLoop: 0 setCel: 0 posn: 124 141 stopUpd:)
	)
)

(instance web of Prop
	(properties
		view 68
	)

	(method (init)
		(super init:)
		(self setLoop: 8)
	)
)

(instance curd of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 68 setLoop: 3 posn: 124 152)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 25
			bottom: 66
			right: 247
			type: 4
			title: {Little Miss Muffet}
			back: 11
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
					{Little Miss Muffet sat on a tuffet,}
					dsWIDTH
					300
					dsCOORD
					5
					3
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2)
			(3
				(Display
					{     Eating her curds and whey;}
					dsWIDTH
					300
					dsCOORD
					5
					13
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(if global131
					(rhymeScript changeState: 5)
				)
				(Display
					{     There came a big spider,}
					dsWIDTH
					300
					dsCOORD
					5
					23
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(Display
					{     And sat down beside her,}
					dsWIDTH
					300
					dsCOORD
					5
					33
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(6
				(Display
					{And frightened Miss Muffet away.}
					dsWIDTH
					300
					dsCOORD
					5
					43
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(7
				(rhymeScript changeState: 11)
				(rhymeSound number: 6 loop: 1 play: self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

