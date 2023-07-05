;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
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
	rm003 0
)

(local
	local0
	local1
	local2
)

(instance rm003 of Rm
	(properties
		picture 3
		style 0
		horizon 97
		east 4
		south 11
		west 2
	)

	(method (init)
		(Load rsSOUND 21)
		(Load rsSOUND 41)
		(Load rsVIEW 85)
		(Load rsVIEW 75)
		(Load rsVIEW 50)
		(Load rsVIEW 300)
		(Load rsVIEW 39)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(17
				(gEgo posn: 8 149)
			)
			(4
				(gEgo y: (+ (/ (* (- (gEgo y:) 126) 62) 63) 127))
			)
			(11
				(gEgo y: 187 x: (+ (/ (* (- (gEgo x:) 33) 38) 20) 278))
			)
			(2
				(gEgo posn: 8 149)
			)
			(10
				(gEgo posn: 4 164)
			)
			(else
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(flower stopUpd: init:)
		(if [global675 3]
			(tommyDone init:)
			(= local1 1)
		else
			(tommy init:)
		)
		(if
			(and
				(not [global675 3])
				(not (gEgo edgeHit:))
				(not (== (gEgo onControl: 1) 8192))
				(not (== (gEgo onControl: 1) 2048))
				(proc0_11 50)
			)
			(= [global675 3] 1)
			(gGlobalMGSound fade:)
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
			(tommy setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local2 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 16) (== local2 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 16) (== local2 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local1 1)
						(proc0_16 event 167 72 184 108)
					)
					(LookAt tommy)
					(tommy setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (== (gEgo onControl: 1) 2048)
			(gCurRoom newRoom: 9)
		)
		(super doit:)
		(if (> (gEgo distanceTo: tommy) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 3])
				(not (gEgo edgeHit:))
				(not (== (gEgo onControl: 1) 8192))
				(not (== (gEgo onControl: 1) 2048))
				(not global108)
				(< (gEgo distanceTo: tommy) 30)
			)
			(= global108 1)
			(LookAt tommy)
			(tommy setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local1 1)
				(HandsOff)
				(tommy setLoop: 4 cycleSpeed: 1 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{With a hi\nand a ho!\nWhere did my\nbreadknife\ngo?}
					dsWIDTH
					120
					dsCOORD
					70
					15
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
				(tommy setCel: 0)
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(= global103 0)
				(= local1 0)
				(tommy setLoop: 0 setCel: 0 cycleSpeed: 3)
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
				(= local1 1)
				(= global209 1)
				(HandsOff)
				(if (> (gEgo y:) 150)
					(gEgo setMotion: MoveTo 285 145 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setAvoider: Avoid setMotion: MoveTo 170 110 self)
			)
			(2
				(proc0_18)
				(knife init:)
				(gEgo setMotion: MoveTo 165 135 self)
			)
			(3
				(gEgo setAvoider: 0 setLoop: 3 stopUpd:)
				(= seconds 1)
			)
			(4
				(proc0_17)
				(man init:)
				(blueGirl init:)
				(pinkGirl init:)
				(= cycles 1)
			)
			(5
				(gEgo setScript: musicScript)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(6
				(man setLoop: 4 setCel: 0 stopUpd:)
				(blueGirl setLoop: 4 setCel: 1 stopUpd:)
				(pinkGirl setLoop: 3 setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(7
				(blueGirl setLoop: 4 setCel: 1 setMotion: MoveTo 208 107 self)
			)
			(8
				(bread init:)
				(blueGirl setLoop: 1 setCel: 0 setMotion: MoveTo 221 108 self)
			)
			(9
				(man setLoop: 5 setCycle: Fwd)
				(blueGirl setLoop: 6 setCycle: Fwd)
				(pinkGirl setLoop: 7 setCycle: Fwd)
				(tommy setLoop: 1 setCycle: End)
				(= seconds 2)
			)
			(10
				(blueGirl setLoop: 4 setCel: 1 setMotion: MoveTo 208 107)
				(pinkGirl setLoop: 3 setCel: 1 stopUpd:)
				(man setLoop: 4 setCel: 0 stopUpd:)
				(tommy setCycle: Beg)
				(= cycles 20)
			)
			(11
				(tommy setLoop: 5 setCycle: End self)
			)
			(12
				(knife dispose:)
				(bread dispose:)
				(= cycles 2)
			)
			(13
				(pinkGirl
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 155 110 self
				)
			)
			(14
				(pinkGirl setLoop: 8)
				(tommy setLoop: 2 setCel: 0 setCycle: End)
				(heart init: setCycle: End self)
			)
			(15
				(= cycles 5)
			)
			(16
				(pinkGirl ignoreActors: 0)
				(heart dispose:)
				(gEgo setCycle: Walk setMotion: 0 setLoop: -1)
				(= global103 0)
				(= local0 0)
			)
			(17
				(gGame setSpeed: global206)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 220 140)
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
			(= local2 1)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 21
		priority 10
	)
)

(instance tommy of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 85
			ignoreControl: -1
			posn: 178 96
			setLoop: 0
			setCel: 0
			cycleSpeed: 3
		)
	)
)

(instance tommyDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 85 posn: 178 96 setLoop: 2 setCel: 0 stopUpd:)
	)
)

(instance blueGirl of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 75
			ignoreHorizon: 1
			posn: 330 135
			setLoop: 1
			setCycle: Walk
			setMotion: MoveTo 221 108
		)
	)
)

(instance man of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 75
			ignoreHorizon: 1
			posn: 350 138
			setLoop: 0
			setCycle: Walk
			setMotion: MoveTo 201 122
		)
	)
)

(instance pinkGirl of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 75
			ignoreHorizon: 1
			posn: 335 132
			setLoop: 2
			setCycle: Walk
			setMotion: MoveTo 139 110 rhymeScript
		)
	)
)

(instance knife of View
	(properties)

	(method (init)
		(super init:)
		(self view: 50 posn: 167 99 setLoop: 0 setCel: 0 stopUpd:)
	)
)

(instance bread of View
	(properties)

	(method (init)
		(super init:)
		(self view: 85 posn: 184 100 setLoop: 3 setCel: 0 stopUpd:)
	)
)

(instance flower of View
	(properties
		x 236
		y 159
		view 300
		loop 1
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 50
			setLoop: 1
			setCel: 0
			posn: 130 45
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
		(self view: 39 posn: 130 75 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 17
			bottom: 65
			right: 303
			type: 4
			title: {Tommy Tucker}
			back: 2
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 21 loop: 1 play: self)
			)
			(1
				(tommy setLoop: 0 cycleSpeed: 3 setCycle: Fwd)
				(Display
					{Little Tommy Tucker sings for his supper.}
					dsWIDTH
					300
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
			(2)
			(3
				(Display
					{What shall he eat? White bread and butter.}
					dsWIDTH
					300
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
			(4)
			(5
				(Display
					{How shall he cut it without ever a knife?}
					dsWIDTH
					300
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
			(6
				(Display
					{How will he be married without ever a wife?}
					dsWIDTH
					300
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
			(7
				(= local2 1)
			)
		)
	)
)

(instance heart of Prop
	(properties
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			view: 75
			posn: 155 73
			setLoop: 9
			cycleSpeed: (if global131 1 else 0)
		)
	)
)

