;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
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
	rm036 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm036 of Rm
	(properties
		picture 36
		style 0
		horizon 138
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 28)
		(Load rsSOUND 49)
		(Load rsVIEW 36)
		(Load rsVIEW 65)
		(Load rsVIEW 51)
		(Load rsVIEW 38)
		(super init:)
		(= global207 1)
		(HandsOn)
		(gEgo x: (+ (/ (* (- (gEgo x:) 87) 51) 20) 134) y: 187 init:)
		(proc0_10 99 156 161 250)
		(table init:)
		(chair1 init:)
		(chair2 init:)
		(plate1 init:)
		(plate2 init:)
		(if [global675 36]
			(jackDone init:)
			(wifeDone init:)
			(platter init:)
			(= local2 1)
		else
			(jack init:)
			(wife init:)
		)
		(if (and (not [global675 36]) (proc0_11 51))
			(= [global675 36] 1)
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
			(jack setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 11)
						(== local3 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 11) (== local3 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 11) (== local3 1))
					(rhymeScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local2 1))
					(cond
						((proc0_16 event 122 101 133 137)
							(jack setScript: talkScript)
						)
						((proc0_16 event 188 100 205 136)
							(jack setScript: talkScript)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo edgeHit:) 3)
			(gCurRoom newRoom: 10)
		)
		(if (> (gEgo distanceTo: jack) 41)
			(= global108 0)
		)
		(if
			(and
				(not [global675 36])
				(not global108)
				(< (gEgo distanceTo: jack) 41)
			)
			(= global108 1)
			(jack setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local2 1)
				(HandsOff)
				(jack setLoop: 7 setCycle: Fwd)
				(wife setLoop: 8 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display {We're so hungry!} dsWIDTH 80 dsCOORD 119 58 dsALIGN alCENTER dsFONT 0 dsCOLOR 0)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(jack setCel: 0)
				(wife setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual dispose:)
				(itemBalloon dispose:)
				(wife setLoop: 4)
				(jack setLoop: 2 setScript: PoundScript)
				(= global103 0)
				(= local2 0)
				(HandsOn)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local2 1)
				(= global209 1)
				(HandsOff)
				(gEgo setMotion: MoveTo 160 142 self)
			)
			(1
				(platter init:)
				(meat init:)
				(jack setLoop: 0 setCel: 4 stopUpd:)
				(wife setLoop: 0 setCel: 5 stopUpd:)
				(gEgo setMotion: MoveTo 190 170 self)
				(proc0_18)
			)
			(2
				(gEgo setLoop: 3 stopUpd:)
				(rhymeBox init:)
				(rhymeBox open:)
				(= seconds 1)
			)
			(3
				(jack setLoop: 3 setCycle: Fwd cycleSpeed: 4)
				(self setScript: MusicScript)
				(= cycles 20)
			)
			(4
				(meat setCel: 1)
				(jack setLoop: 0 setCel: 2 stopUpd:)
				(wife setLoop: 5 setCycle: Fwd cycleSpeed: 4)
				(= cycles 20)
			)
			(5
				(meat setCel: 2)
				(wife setLoop: 0 setCel: 3 stopUpd:)
				(= seconds global122)
			)
			(6
				(jack setLoop: 3 setCycle: Fwd cycleSpeed: 0)
				(wife setLoop: 5 setCycle: Fwd cycleSpeed: 0)
				(meat cycleSpeed: 5 setCycle: End self)
				(itemBalloon init: hide:)
			)
			(7
				(jack setLoop: 0 setCel: 2 stopUpd:)
				(wife setLoop: 0 setCel: 3 stopUpd:)
				(= cycles 20)
			)
			(8
				(RedrawCast)
				(cat init:)
			)
			(9
				(cat dispose:)
				(meat dispose:)
				(= cycles 12)
			)
			(10
				(jack setLoop: 0 setCel: 4 stopUpd:)
				(wife setLoop: 0 setCel: 5 stopUpd:)
				(= seconds 2)
			)
			(11
				(jack setLoop: 0 setCel: 2 stopUpd:)
				(wife setLoop: 0 setCel: 3 stopUpd:)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(12
				(gGame setSpeed: global206)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(HandsOff)
					(gEgo setAvoider: Avoid)
					(gEgo setMotion: MoveTo 161 250)
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
			(= local3 1)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 28
		priority 10
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 99 173 setPri: 10 ignoreActors: 1 stopUpd:)
	)
)

(instance platter of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setLoop: 0 setCel: 7 setPri: 9 posn: 160 113 stopUpd:)
	)
)

(instance plate1 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setLoop: 0 setCel: 6 setPri: 9 posn: 142 112 stopUpd:)
	)
)

(instance plate2 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setLoop: 0 setCel: 6 setPri: 9 posn: 183 111 stopUpd:)
	)
)

(instance chair1 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setLoop: 0 setCel: 0 posn: 122 128 setPri: 8 stopUpd:)
	)
)

(instance chair2 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setLoop: 0 setCel: 1 posn: 198 127 setPri: 8 stopUpd:)
	)
)

(instance cat of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			posn: 160 110
			setLoop: 6
			setCel: 0
			cycleSpeed: 5
			setPri: 10
			setCycle: End rhymeScript
		)
	)
)

(instance meat of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setPri: 12 posn: 157 111 setLoop: 1 stopUpd:)
	)
)

(instance jack of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 65
			setPri: 10
			posn: 132 114
			setLoop: 2
			setScript: PoundScript
		)
	)
)

(instance wife of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setPri: 10 posn: 193 113 setLoop: 4)
	)
)

(instance jackDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setPri: 10 posn: 132 114 setLoop: 0 setCel: 2 stopUpd:)
	)
)

(instance wifeDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 65 setPri: 10 posn: 193 113 setLoop: 0 setCel: 3 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 51
			setLoop: 1
			setCel: 0
			posn: 164 70
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
		(self
			view: 38
			setLoop: 0
			setCel: 0
			posn: 160 94
			setPri: 14
			hide:
			stopUpd:
		)
	)
)

(instance PoundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jack setCel: 0)
				(wife setCel: 0)
				(= cycles 2)
			)
			(1
				(jack setCel: 1)
				(wife setCel: 1)
				(poundSound play: self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance poundSound of Sound
	(properties
		number 49
	)
)

(instance MusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 28 loop: 1 play: self)
			)
			(1
				(Display
					{Jack Sprat could eat no fat,}
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
					{His wife could eat no lean;}
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
				(Display
					{And so, between them both,}
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
				(Display
					{They licked the platter clean.}
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
		)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 40
			bottom: 66
			right: 240
			type: 4
			title: {Jack Sprat}
			back: 11
		)
	)
)

