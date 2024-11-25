;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
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
	rm027 0
)

(local
	local0
	local1
	local2
	local3
)

(instance rm027 of Rm
	(properties
		picture 27
		style 0
		horizon 100
		north 20
		east 28
		west 26
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 47)
		(Load rsVIEW 73)
		(Load rsVIEW 46)
		(Load rsVIEW 133)
		(Load rsVIEW 39)
		(Load rsVIEW 37)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(20
				(if (< (gEgo x:) 121)
					(gEgo posn: 25 132)
				else
					(gEgo posn: 146 102)
				)
			)
			(26
				(if (< (gEgo y:) 175)
					(gEgo y: (+ (/ (* (- (gEgo y:) 121) 42) 18) 101))
				else
					(gEgo posn: 10 188)
				)
			)
			(28
				(gEgo y: (+ (/ (* (- (gEgo y:) 113) 71) 75) 117))
			)
			(33
				(gEgo x: (+ (/ (* (- (gEgo x:) 194) 60) 124) 1))
			)
			(34
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 85) 106) 62) y: 184)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(boy init:)
		(if (not [global675 27])
			(if (= local1 (proc0_11 46))
				(= [global675 27] 1)
				(gEgo illegalBits: 0 ignoreActors: 1)
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
				(boy setScript: rhymeScript)
			else
				(boy setScript: cryScript)
			)
		else
			(= local2 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 12)
						(== local3 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 12) (== local3 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 12) (== local3 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local2 1)
						(proc0_16 event 134 140 150 163)
					)
					(LookAt boy)
					(boy setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) EDGE_RIGHT)
				(if (and (== global208 0) (== local2 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 24)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(if (and (== global208 0) (== local2 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 16)
			)
			((== (gEgo edgeHit:) EDGE_LEFT)
				(if (and (== global208 0) (== local2 2))
					(gGlobalMGSound play:)
				)
				(gCurRoom newRoom: 22)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(if (and (== global208 0) (== local2 2))
					(gGlobalMGSound play:)
				)
				(if (< (gEgo x:) 241)
					(gCurRoom newRoom: 30)
				else
					(gCurRoom newRoom: 31)
				)
			)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 62)
				(gCurRoom newRoom: 33)
			else
				(gCurRoom newRoom: 34)
			)
		)
		(if (> (gEgo distanceTo: boy) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 27])
				(not global108)
				(< (gEgo distanceTo: boy) 30)
			)
			(= global108 1)
			(LookAt boy)
			(boy setScript: talkScript)
		)
		(super doit:)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crySound stop:)
				(= global103 1)
				(= local2 1)
				(HandsOff)
				(boy setLoop: 8 cycleSpeed: 1 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Oh, where\nhas my\nlittle\ndog gone?}
					dsWIDTH
					100
					dsCOORD
					39
					74
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
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(boy setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(boy
					setLoop: 6
					cycleSpeed: 3
					setCycle: Fwd
					setScript: cryScript
				)
				(= global103 0)
				(HandsOn)
				(= local2 0)
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
				(proc0_18)
				(cond
					((== gPrevRoomNum 26)
						(dog init: posn: 10 182 setMotion: MoveTo 32 182)
					)
					((== gPrevRoomNum 20)
						(dog init: posn: (local1 x:) (+ (local1 y:) 5))
					)
					(else
						(dog init: posn: (local1 x:) (local1 y:))
					)
				)
				(if (> (gEgo x:) 300)
					(gEgo setAvoider: Avoid setMotion: MoveTo 290 175 self)
				else
					(gEgo setAvoider: Avoid)
					(= cycles 1)
				)
			)
			(1
				(dog
					setMotion:
						MoveTo
						(if (< (gEgo x:) (boy x:)) 20 else 300)
						(boy y:)
						self
				)
				(gEgo setAvoider: Avoid setMotion: MoveTo 200 175 self)
			)
			(2)
			(3
				(gEgo
					setAvoider: 0
					setScript: musicScript
					setLoop: 1
					stopUpd:
				)
				(= seconds 1)
			)
			(4
				(if (< (boy x:) (dog x:))
					(boy setLoop: 1)
					(dog setLoop: 2)
				else
					(boy setLoop: 0)
					(dog setLoop: 3)
				)
				(boy setCel: 0)
				(dog view: 73 setCel: 0 setAvoider: 0)
				(= seconds global122)
			)
			(5
				(if (< (boy x:) (dog x:))
					(boy setLoop: 0)
				else
					(boy setLoop: 1)
				)
				(= seconds 1)
			)
			(6
				(boy setCel: 1)
				(= seconds 1)
			)
			(7
				(boy setCel: 2)
				(hereSpotBalloon init:)
				(RedrawCast)
				(hereSpot init:)
				(= seconds 3)
			)
			(8
				(hereSpot dispose:)
				(hereSpotBalloon dispose:)
				(if (< (boy x:) (dog x:))
					(dog
						setCycle: Fwd
						setMotion: MoveTo (+ (boy x:) 21) (boy y:) self
					)
					(boy setLoop: 0)
				else
					(dog
						setCycle: Fwd
						setMotion: MoveTo (- (boy x:) 21) (boy y:) self
					)
					(boy setLoop: 1)
				)
			)
			(9
				(boy setCel: 3)
				(dog posn: (dog x:) (+ (boy y:) 5) setCel: (dog lastCel:))
				(= cycles 3)
			)
			(10
				(dog dispose:)
				(boy setLoop: (+ (boy loop:) 4) setCycle: Fwd)
				(= seconds global122)
			)
			(11
				(= local0 0)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= seconds 2)
				(= global103 0)
			)
			(12
				(gGame setSpeed: global206)
			)
			(13
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(proc0_14 170 180)
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
					{Oh where, oh where has my}
					dsWIDTH
					250
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
				(Display
					{_____little dog gone?}
					dsWIDTH
					250
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
			(2
				(Display
					{Oh where, oh where can he be?}
					dsWIDTH
					250
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
			(3
				(Display
					{With his ears cut short,}
					dsWIDTH
					250
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
			(4
				(Display
					{_____And his tail cut long,}
					dsWIDTH
					250
					dsCOORD
					5
					53
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
					{Oh where, oh where can he be?}
					dsWIDTH
					250
					dsCOORD
					5
					65
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
		number 23
		priority 10
	)
)

(instance boy of Act
	(properties)

	(method (init)
		(super init:)
		(if [global675 27]
			(self view: 73 posn: 141 154 setLoop: 7 setCel: 2 stopUpd:)
		else
			(self view: 73 posn: 141 154 setLoop: 6 setCycle: Fwd cycleSpeed: 3)
		)
	)
)

(instance dog of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 46
			setLoop: -1
			setCel: (local1 cel:)
			setCycle: Walk
			cycleSpeed: 0
			illegalBits: $8000
			ignoreActors: 0
			setAvoider: Avoid
		)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self view: 133 setLoop: 5 posn: 91 109 setPri: 15 hide: stopUpd:)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 posn: 90 130 setPri: 14 hide: stopUpd:)
	)
)

(instance hereSpot of View
	(properties)

	(method (init)
		(super init:)
		(self view: 73 posn: 104 117 setLoop: 7 setCel: 0 setPri: 15 stopUpd:)
	)
)

(instance hereSpotBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 37 posn: 105 125 setLoop: 2 setCel: 0 setPri: 14 stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 15
			left: 5
			bottom: 92
			right: 206
			type: 4
			title: {Little Dog Gone}
			back: 3
		)
	)
)

(instance crySound of Sound
	(properties
		number 47
		priority 4
	)
)

(instance cryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 2)
				(gGlobalMGSound stop:)
				(crySound play: self)
			)
			(1
				(= local2 0)
				(= seconds 3)
			)
			(2
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
			)
		)
	)
)

