;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
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
	rm033 0
)

(local
	local0
	local1
	local2
)

(instance rm033 of Rm
	(properties
		picture 33
		style 0
		horizon 100
		east 34
		west 32
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 29)
		(Load rsSOUND 51)
		(Load rsSOUND 52)
		(Load rsVIEW 55)
		(Load rsVIEW 136)
		(Load rsVIEW 39)
		(Load rsVIEW 84)
		(Load rsVIEW 320)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(26
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 32) 79) 50))
			)
			(27
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 75) 60) 210))
			)
			(32
				(gEgo y: (+ (/ (* (- (gEgo y:) 101) 76) 87) 112))
			)
			(34
				(if (< (gEgo y:) 150)
					(gEgo
						x: 310
						y: (+ (/ (* (- (gEgo y:) 101) 26) 43) 118)
					)
				)
			)
			(else
				(gEgo posn: 160 125)
			)
		)
		(gEgo init:)
		(proc0_10)
		(jack init:)
		(if global131
			(smoke init:)
			(water setCycle: Fwd cycleSpeed: 3 init:)
		else
			(smoke init: addToPic:)
			(water init: addToPic:)
		)
		(if [global675 33]
			(candle init:)
			(= local1 1)
		)
		(if (and (not [global675 33]) (proc0_11 55))
			(= [global675 33] 1)
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
			(jack setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 18)
						(== local2 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 18) (== local2 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 18) (== local2 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local1 1)
						(proc0_16 event 217 110 229 146)
					)
					(LookAt jack)
					(jack setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) EDGE_TOP)
			(if (< (gEgo x:) 195)
				(gCurRoom newRoom: 26)
			else
				(if (== global111 46)
					(gGlobalMGSound fade:)
				)
				(gCurRoom newRoom: 27)
			)
		)
		(super doit:)
		(if (> (gEgo distanceTo: jack) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 33])
				(not global108)
				(< (gEgo distanceTo: jack) 30)
			)
			(= global108 1)
			(LookAt jack)
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
				(= local1 1)
				(HandsOff)
				(jack
					setLoop: 8
					cycleSpeed: (if global131 1 else 0)
					setCycle: Fwd
				)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{I can't\nfind my\ncandlestick\nanywhere!}
					dsWIDTH
					250
					dsCOORD
					45
					50
					dsALIGN
					alCENTER
					dsFONT
					global675
					dsCOLOR
					0
				)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show: setCycle: Fwd)
				(jack setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual stopUpd: hide:)
				(itemBalloon hide:)
				(jack
					setLoop: 7
					cycleSpeed: (if global131 4 else 1)
					setCycle: Fwd
				)
				(= global103 0)
				(= local1 0)
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
				(HandsOff)
				(jack stopUpd:)
				(if (== gPrevRoomNum 34)
					(gEgo
						illegalBits: 0
						ignoreActors:
						setAvoider: Avoid
						setPri: -1
						setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
					)
				else
					(= cycles (= state 1))
				)
			)
			(1
				(gEgo
					setPri: 8
					setAvoider: Avoid
					setMotion: MoveTo 210 126 self
				)
			)
			(2
				(gEgo setAvoider: Avoid setMotion: MoveTo 197 131 self)
			)
			(3
				(proc0_18)
				(candle init:)
				(gEgo setMotion: MoveTo 242 109 self)
			)
			(4
				(gEgo setAvoider: 0 setLoop: 2 stopUpd:)
				(rhymeBox init:)
				(rhymeBox open:)
				(gEgo setScript: MusicScript)
				(= cycles 5)
			)
			(5
				(jack
					ignoreControl: -1
					ignoreActors: 1
					cycleSpeed: (if global131 1 else 0)
					setLoop: 0
					setMotion: MoveTo 270 150 self
				)
			)
			(6
				(jack setLoop: 1 setCycle: 0)
				(= cycles 3)
			)
			(7
				(jack setCycle: Fwd setMotion: MoveTo 130 135 self)
			)
			(8
				(jack setLoop: 0 setCycle: 0)
				(= cycles 3)
			)
			(9
				(jack setCycle: Fwd setMotion: MoveTo 190 135 self)
			)
			(10
				(jack
					setPri: 15
					setLoop: 4
					setCel: 0
					setCycle: CT 3 1
					setMotion: MoveTo 210 115 self
				)
			)
			(11
				(jack setMotion: MoveTo 225 135 self)
			)
			(12
				(jack
					setPri: -1
					setCycle: CT (jack lastCel:) 1
					setMotion: MoveTo 235 135 self
				)
			)
			(13
				(ouch init:)
				(= seconds 4)
			)
			(14
				(ouch dispose:)
				(jack
					setStep: (if global131 2 else 4)
					setCycle: Fwd
					setLoop: 2
					setMotion: MoveTo 255 140 self
				)
			)
			(15
				(jack setLoop: 3 setMotion: MoveTo 225 150 self)
			)
			(16
				(jack setLoop: 2 setMotion: MoveTo 262 179 self)
			)
			(17
				(rhymeSound number: 51 play:)
				(jack setLoop: 5 setCycle: End setMotion: MoveTo 270 189 self)
			)
			(18
				(jack stopUpd:)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(19
				(gGlobalMGSound number: 1 priority: 5 loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gEgo setPri: -1)
				(gGame setSpeed: global206)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(proc0_14 150 140)
				else
					(NormalEgo)
					(HandsOn)
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
		number 29
		priority 10
	)
)

(instance jack of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 84
			posn: 223 136
			setLoop: 7
			setCel: 0
			setCycle: Fwd
			cycleSpeed: (if global131 4 else 1)
		)
		(if [global675 33]
			(self stopUpd:)
		)
	)
)

(instance candle of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 55
			posn: 208 135
			setCycle: Fwd
			cycleSpeed: (if global131 2 else 0)
		)
	)
)

(instance water of Prop
	(properties
		x 236
		y 197
		view 136
		loop 1
	)
)

(instance itemVisual of Prop
	(properties
		x 175
		y 81
		view 55
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			setPri: 15
			cycleSpeed: (if global131 1 else 0)
			setCycle: Fwd
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 posn: 170 105 setPri: 14 hide: stopUpd:)
	)
)

(instance ouch of View
	(properties
		x 204
		y 104
		view 84
	)

	(method (init)
		(super init:)
		(self posn: 204 104 setLoop: 9 setPri: 15 ignoreActors: 1)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 15
			left: 5
			bottom: 68
			right: 125
			type: 4
			title: {Jack Be Nimble}
			back: 10
		)
	)
)

(instance smoke of Prop
	(properties
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			view: 320
			setLoop: 1
			posn: 165 50
			cycleSpeed: (if global131 3 else 0)
			setPri: 1
			setCycle: Fwd
		)
	)
)

(instance MusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 29 loop: 1 play: self)
			)
			(1
				(Display {Jack be nimble,\n} dsWIDTH 150 dsCOORD 5 5 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(2
				(Display {Jack be quick,\n} dsWIDTH 150 dsCOORD 5 17 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(3
				(Display {Jack jump over} dsWIDTH 150 dsCOORD 5 29 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
				(Display {the candlestick.} dsWIDTH 150 dsCOORD 5 41 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(4
				(= seconds 2)
			)
			(5
				(rhymeSound number: 52 play:)
			)
		)
	)
)

