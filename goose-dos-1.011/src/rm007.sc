;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use ForwardCounter)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm007 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance rm007 of Rm
	(properties
		picture 7
		style 0
		horizon 85
		south 14
		west 6
	)

	(method (init)
		(Load rsSOUND 41)
		(Load rsSOUND 18)
		(Load rsVIEW 86)
		(Load rsVIEW 87)
		(Load rsVIEW 122)
		(Load rsVIEW 48)
		(Load rsVIEW 39)
		(super init:)
		(= global125 -1)
		(switch gPrevRoomNum
			(6
				(gEgo y: (+ (/ (* (- (gEgo y:) 131) 77) 59) 113))
			)
			(14
				(gEgo x: (+ (/ (* (- (gEgo x:) 1) 10) 14) 1))
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
		(cat init:)
		(cow init:)
		(moon init:)
		(music init: hide:)
		(cond
			([global675 7]
				(fiddle init: addToPic:)
				(dog init: addToPic:)
				(cat init: addToPic:)
				(= local5 1)
			)
			((== global111 48)
				(dog init:)
			)
		)
		(if (and (not [global675 7]) (proc0_11 48))
			(= [global675 7] 1)
			(cow setScript: 0)
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
			(cat setScript: rhymeScript)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 8)
						(== local6 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 8) (== local6 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 8) (== local6 1))
					(rhymeScript cycles: 1)
				)
				(if
					(and
						(& temp0 emSHIFT)
						(!= local5 1)
						(proc0_16 event 103 111 122 144)
					)
					(LookAt cat)
					(cat setScript: talkScript)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: cat) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 7])
				(not global108)
				(< (gEgo distanceTo: cat) 30)
			)
			(= global108 1)
			(LookAt cat)
			(cat setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local5 1)
				(HandsOff)
				(cat
					setLoop: 3
					cycleSpeed: (if global131 3 else 0)
					setCycle: End self
				)
			)
			(1
				(cat setCycle: Beg self)
			)
			(2
				(cat view: 87 setLoop: 3 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Diddle\ndee dee!\nBring a\nfiddle\nfor me!}
					dsWIDTH
					80
					dsCOORD
					20
					42
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
			(3
				(cat setCel: 0 stopUpd:)
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(= seconds global121)
			)
			(4
				(itemVisual hide:)
				(itemBalloon hide:)
				(= global103 0)
				(= local5 0)
				(cat
					view: 86
					setLoop: 9
					cycleSpeed: (if global131 4 else 1)
					setCycle: Fwd
				)
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
				(= local5 1)
				(= global209 1)
				(HandsOff)
				(if (> global131 0)
					(cow xStep: 4 yStep: 3)
				else
					(cow xStep: 8 yStep: 6)
				)
				(gEgo setMotion: MoveTo (- (cat x:) 5) (+ (cat y:) 10) self)
			)
			(1
				(proc0_18)
				(fiddle init:)
				(gEgo setMotion: MoveTo 10 (cat y:) self)
			)
			(2
				(gEgo setLoop: 0 stopUpd:)
				(= seconds 1)
			)
			(3
				(fiddle dispose:)
				(gEgo setScript: musicScript)
				(cat setLoop: 4 setCycle: Fwd)
				(self setScript: notesScript)
				(music show:)
			)
			(4
				(if (> global131 0)
					(dog setLoop: 2 setCycle: Fwd)
				else
					(dog setLoop: 2 setCycle: ForwardCounter 1)
				)
			)
			(5
				(if (< global131 1)
					(dog setCel: 0 stopUpd:)
				)
				(plate init:)
			)
			(6
				(= seconds 2)
				(self setScript: 0)
				(music hide:)
				(fiddle init:)
				(cat setLoop: 3 cel: 0 setCycle: End self)
			)
			(7
				(cat setCycle: Beg self)
			)
			(8
				(cat setCel: 0)
				(gEgo setAvoider: 0 setCycle: Walk setMotion: 0 setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(9
				(if global131
					(= seconds 4)
				else
					(= seconds 8)
				)
			)
			(10
				(gGame setSpeed: global206)
				(rhymeBox dispose:)
				(proc0_12)
				(cond
					((== gScore gPossibleScore)
						(gEgo setAvoider: Avoid)
						(proc0_14 140 170)
					)
					(global131
						(NormalEgo)
						(HandsOn)
						(= global209 0)
						(if (== global208 0)
							(gGlobalMGSound loop: -1 play:)
						)
					)
					(else
						(= seconds 3)
					)
				)
			)
			(11
				(NormalEgo)
				(HandsOn)
				(= global209 0)
				(if (== global208 0)
					(gGlobalMGSound loop: -1 play:)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local6 1)
		)
	)
)

(instance cowScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cow setLoop: 0 setCel: 1)
			)
			(1
				(cow setCel: 2 setMotion: MoveTo 217 50 self)
			)
			(2
				(moon setCel: 1)
				(cow setCel: 3 setMotion: MoveTo 181 38 self)
			)
			(3
				(cow setCel: 4 setMotion: MoveTo 146 59 self)
			)
			(4
				(cow setCel: 5 setMotion: MoveTo 124 78 self)
			)
			(5
				(cow setCel: 6 setMotion: MoveTo 116 81 self)
			)
			(6
				(cow setCel: 7)
				(= seconds 4)
			)
			(7
				(moon setCel: 0)
				(cow setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(8
				(self dispose:)
			)
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
				(cat cycleSpeed: (if global131 1 else 0))
				(= local1
					(Display
						{Hey diddle diddle!}
						dsWIDTH
						250
						dsCOORD
						5
						3
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(2
				(cow setScript: cowScript)
				(= local2
					(Display
						{_____The cat and the fiddle,}
						dsWIDTH
						250
						dsCOORD
						5
						13
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(3
				(cowScript cue:)
				(= local3
					(Display
						{The cow jumped over the moon;}
						dsWIDTH
						250
						dsCOORD
						5
						23
						dsALIGN
						alLEFT
						dsFONT
						0
						dsCOLOR
						0
						dsSAVEPIXELS
					)
				)
			)
			(4
				(rhymeScript cue:)
				(Display 7 0 dsRESTOREPIXELS local1)
				(Display 7 0 dsRESTOREPIXELS local2)
				(Display 7 0 dsRESTOREPIXELS local3)
				(Display
					{The little dog laughed}
					dsWIDTH
					250
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
				(Display
					{_____to see such sport,}
					dsWIDTH
					250
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
			(5
				(rhymeScript cue:)
				(Display
					{And the dish ran away with the spoon.}
					dsWIDTH
					280
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
			(6
				(rhymeScript cue:)
				(= cycles 1)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance notesScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(music loop: (Random 0 2) posn: 102 113 setCel: 0)
				(= cycles 2)
			)
			(1
				(music posn: 101 108 setCel: 1)
				(= cycles 2)
			)
			(2
				(music posn: 100 103 setCel: 2)
				(= cycles 2)
			)
			(3
				(music posn: 99 99 setCel: 3)
				(= cycles 2)
			)
			(4
				(music posn: 98 96 setCel: 4)
				(= cycles 2)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 18
		priority 10
	)
)

(instance dog of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 86
			ignoreControl: -1
			posn: 204 132
			setLoop: 1
			setCycle: Fwd
			cycleSpeed: 3
		)
	)
)

(instance plate of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 86
			ignoreControl: -1
			ignoreActors: 1
			posn: 290 139
			setLoop: 5
			setCycle: Fwd
			xStep: (if global131 4 else 8)
			setMotion: MoveTo -20 139
		)
	)
)

(instance fiddle of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 86
			setPri: (+ (cat priority:) 1)
			posn: 104 134
			setLoop: 6
			stopUpd:
		)
	)
)

(instance music of View
	(properties)

	(method (init)
		(super init:)
		(self view: 87 setLoop: 0 setPri: 15 stopUpd:)
	)
)

(instance moon of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 122 posn: 190 71 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 48
			setLoop: 1
			setCel: 0
			posn: 64 77
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
		(self view: 39 posn: 60 100 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 153
			left: 34
			bottom: 186
			right: 288
			type: 4
			title: {Hey Diddle Diddle}
			back: 6
		)
	)
)

(instance cow of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 86
			ignoreHorizon: 1
			ignoreControl: -1
			posn: 238 86
			setLoop: 7
			setCel: 0
			setScript: TheCowScript
		)
		(if [global675 7]
			(self posn: 116 81)
		)
	)
)

(instance TheCowScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cow setLoop: 7 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(cow setLoop: 8 cycleSpeed: 3 setCycle: Fwd)
				(= seconds (Random 3 6))
			)
			(2
				(cow setLoop: 7 setCel: 8 cycleSpeed: 1 setCycle: Beg self)
			)
			(3
				(cow setCel: (Random 0 4))
				(= state -1)
				(= seconds (Random 3 6))
			)
		)
	)
)

(instance cat of Act
	(properties)

	(method (init)
		(super init:)
		(self view: 86 posn: 112 134 setLoop: 9 cycleSpeed: 4 setCycle: Fwd)
	)
)

