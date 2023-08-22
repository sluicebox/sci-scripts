;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
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
	rm005 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm005 of Rm
	(properties
		picture 5
		style 0
		horizon 85
		south 11
		west 4
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 15)
		(Load rsSOUND 48)
		(Load rsVIEW 400)
		(Load rsVIEW 70)
		(Load rsVIEW 59)
		(Load rsVIEW 39)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(4
				(gEgo y: (+ (/ (* (- (gEgo y:) 127) 64) 62) 125))
			)
			(11
				(gEgo y: 187 x: (+ (/ (* (- (gEgo x:) 264) 40) 17) 3))
			)
			(6
				(= global125 6)
				(gEgo setPri: 6 posn: 299 127)
			)
			(12
				(= global125 6)
				(gEgo setPri: 6 posn: 316 161)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(if [global675 5]
			(humptyDone init:)
			(ladder init:)
			(= local3 2)
		else
			(humpty init:)
		)
		(if (not [global675 5])
			(gGlobalMGSound number: 1 priority: 5 loop: -1 stop:)
		)
		(if
			(and
				(not [global675 5])
				(not (== (gEgo onControl: 1) 8192))
				(not (== (gEgo onControl: 1) 2048))
				(proc0_11 59)
			)
			(= [global675 5] 1)
			(= local3 3)
			(= global206 gSpeed)
			(switch global131
				(0
					(gGame setSpeed: 4)
				)
				(1
					(gGame setSpeed: 7)
				)
				(2
					(gGame setSpeed: 10)
				)
			)
			(humpty setScript: rhymeScript)
		)
		(= local1 (Random 0 4))
		(if (and (not (proc0_11 59)) (or (== 0 local1) (== 3 local1)))
			(bird init: setScript: birdScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local2 0)
						(== local4 1)
						(== (event message:) KEY_RETURN)
					)
					(= local2 1)
					(rhymeScript cycles: 2)
				)
			)
			($0040 ; direction
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local2 0)
						(== local4 1)
					)
					(= local2 1)
					(rhymeScript cycles: 2)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local2 0)
						(== local4 1)
					)
					(= local2 1)
					(rhymeScript cycles: 2)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local3 2)
						(proc0_16 event 123 83 147 111)
					)
					(LookAt humpty)
					(humpty setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo onControl: 1) 2048)
				(gCurRoom newRoom: 12)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (== global111 48)
					(gGlobalMGSound loop: -1)
					(if (== global208 0)
						(gGlobalMGSound play:)
					)
				)
				(gCurRoom newRoom: 6)
			)
		)
		(super doit:)
		(if (> (gEgo distanceTo: humpty) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 5])
				(not (== (gEgo onControl: 1) 8192))
				(not (== (gEgo onControl: 1) 2048))
				(not global108)
				(< (gEgo distanceTo: humpty) 30)
			)
			(= global108 1)
			(LookAt humpty)
			(humpty setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local3 2)
				(HandsOff)
				(humpty setLoop: 6 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{I want to\nsit up there,\nbut I need\na ladder.}
					dsWIDTH
					80
					dsCOORD
					160
					21
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(humpty setCel: 1 stopUpd:)
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(= seconds 2)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(humpty setLoop: 0 setCel: -1 setCycle: Fwd)
				(= global103 0)
				(= local3 1)
				(humpty setScript: JumpScript)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local4 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local3 2)
				(= global209 1)
				(HandsOff)
				(if (> (gEgo y:) 150)
					(gEgo setMotion: MoveTo 25 145 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					setAvoider: Avoid
					setPri: 10
					setMotion: MoveTo 130 105 self
				)
			)
			(2
				(proc0_18)
				(ladder init:)
				(humpty setLoop: 1 setCel: 2 posn: 128 100)
				(gEgo setMotion: MoveTo 210 125 self)
			)
			(3
				(proc0_17)
				(= cycles 5)
			)
			(4
				(humpty setLoop: 2 posn: 118 100)
				(gEgo setAvoider: 0 setPri: -1 setLoop: 3 stopUpd:)
				(rhymeBox init:)
				(rhymeBox open:)
				(= seconds 1)
			)
			(5
				(horse init:)
				(wheels init:)
				(humpty
					setLoop: 2
					setCycle: Fwd
					cycleSpeed: (if global131 1 else 0)
					setStep: 4 4
					setMotion: MoveTo 118 75 self
				)
			)
			(6
				(self setScript: MusicScript)
				(humpty setLoop: 1 setCel: 3 posn: 130 75 stopUpd:)
			)
			(7
				(humpty
					setCel: 4
					setStep: (if global131 2 else 4) (if global131 2 else 4)
				)
				(= cycles 1)
			)
			(8
				(humpty setMotion: MoveTo 130 102 self)
			)
			(9
				(= cycles 1)
			)
			(10
				(humpty setCycle: End)
			)
			(11
				(horse setMotion: MoveTo 80 123 self)
			)
			(12
				(humpty stopUpd:)
				(wheels dispose:)
				(= seconds global122)
			)
			(13
				(horse setLoop: 4 cycleSpeed: 0 setCycle: End self)
			)
			(14
				(= seconds 2)
			)
			(15
				(horse setLoop: 7 setMotion: MoveTo -25 150 self)
				(gEgo setAvoider: 0 setCycle: Walk setMotion: 0 setLoop: -1)
				(= local0 0)
				(= global103 0)
				(= cycles 0)
			)
			(16
				(gGame setSpeed: global206)
			)
			(17
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(itemVisual dispose:)
				(itemBalloon dispose:)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 140 130)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)
)

(instance birdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
			)
			(1
				(bird
					setCycle: End self
					illegalBits: 0
					ignoreHorizon: 1
					cycleSpeed: (if global131 1 else 0)
				)
			)
			(2
				(bird
					setLoop: 3
					setCel: 0
					posn: 33 16
					setCycle: Fwd
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 335 1 self
				)
			)
			(3
				(bird stopUpd:)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bird of Act
	(properties
		y 24
		x 27
		view 400
		loop 2
	)
)

(instance rhymeSound of Sound
	(properties
		number 15
		priority 10
	)
)

(instance humpty of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 70
			setPri: 6
			ignoreControl: -1
			ignoreHorizon: 1
			posn: 135 100
			setLoop: 0
			yStep: 1
			cycleSpeed: (if global131 2 else 0)
			setScript: JumpScript
		)
	)
)

(instance horse of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 70
			setLoop: 4
			setCel: 0
			ignoreControl: -1
			ignoreHorizon: 1
			posn: -25 150
		)
	)
)

(instance wheels of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 70 setLoop: 5 setCycle: Fwd cycleSpeed: 0 ignoreActors: 1)
	)

	(method (doit)
		(super doit:)
		(self posn: (- (horse x:) 8) (horse y:))
	)
)

(instance humptyDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 70 setLoop: 3 setCel: 0 posn: 135 75 stopUpd:)
	)
)

(instance ladder of View
	(properties)

	(method (init)
		(super init:)
		(self view: 59 setLoop: 1 setCel: 0 posn: 123 93 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 59
			setLoop: 1
			setCel: 0
			posn: 200 50
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 setLoop: 1 posn: 197 75 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 9
			bottom: 60
			right: 312
			type: 4
			title: {Humpty Dumpty}
			back: 11
		)
	)
)

(instance MusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 15 loop: 1 play: self)
			)
			(1
				(Display
					{Humpty Dumpty sat on a wall,}
					dsWIDTH
					320
					dsCOORD
					5
					4
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
					{Humpty Dumpty had a great fall;}
					dsWIDTH
					320
					dsCOORD
					5
					15
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(rhymeScript changeState: 7)
			)
			(4
				(Display
					{All the King's horses, and all the King's men}
					dsWIDTH
					320
					dsCOORD
					5
					26
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(5
				(rhymeScript changeState: 11)
			)
			(6
				(Display
					{Cannot put Humpty Dumpty back together again.}
					dsWIDTH
					320
					dsCOORD
					5
					37
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(7 0)
		)
	)
)

(instance JumpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(humpty setCycle: End self)
				(if (!= local3 3)
					(rhymeSound number: 48 play:)
				)
			)
			(1
				(= state -1)
				(= cycles 2)
			)
		)
	)
)

