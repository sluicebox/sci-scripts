;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use ForwardCounter)
(use Follow)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm013 of Rm
	(properties
		picture 13
		style 0
		horizon 119
		north 6
		east 14
		south 20
		west 12
		picAngle 70
	)

	(method (init)
		(Load rsSOUND 17)
		(Load rsSOUND 43)
		(Load rsSOUND 44)
		(Load rsSOUND 41)
		(Load rsSOUND 36)
		(Load rsSOUND 24)
		(Load rsVIEW 69)
		(Load rsVIEW 47)
		(Load rsVIEW 126)
		(Load rsVIEW 133)
		(Load rsVIEW 39)
		(super init:)
		(= global207 0)
		(= global125 -1)
		(door init: stopUpd:)
		(switch gPrevRoomNum
			(6
				(cond
					((< (gEgo x:) 177)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 77) 65) 99) 1)
							y: 124
						)
					)
					((< (gEgo x:) 237)
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 176) 37) 60) 88)
							y: 124
						)
					)
					(else
						(gEgo
							x: (+ (/ (* (- (gEgo x:) 236) 60) 82) 258)
							y: 124
						)
					)
				)
			)
			(12
				(gEgo setPri: -1 posn: 17 174)
			)
			(14
				(gEgo y: (+ (/ (* (- (gEgo y:) 127) 68) 61) 120))
			)
			(20
				(gEgo y: 185)
			)
			(39
				(gEgo
					loop: 2
					x: (+ (/ (* (- (gEgo x:) 133) 19) 54) 169)
					y: 130
					edgeHit: 0
				)
				(self setScript: closeDoorScript)
			)
			(else
				(gEgo posn: 160 130)
			)
		)
		(gEgo init:)
		(proc0_10)
		(bell cycleSpeed: 1 setScript: bellScript init:)
		(if (> global131 1)
			(flag init:)
			(teeter init:)
		else
			(flag init: addToPic:)
			(teeter init: addToPic:)
		)
		(if (not [global675 13])
			(mary init:)
			(if (= local1 (proc0_11 47))
				(= [global675 13] 1)
				(proc0_18)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 6)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(mary setScript: rhymeScript)
			)
		else
			(= local6 1)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 16)
						(== local8 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 16) (== local8 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 16) (== local8 1))
					(rhymeScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local6 1))
					(cond
						((proc0_16 event 206 139 223 166)
							(LookAt mary)
							(mary setScript: talkScript)
						)
						((and (proc0_16 event 171 19 185 33) (!= local7 1))
							(bellScript changeState: 1)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (and (== (gEgo onControl: 1) 16384) (!= script openDoorScript))
			(self setScript: openDoorScript)
		)
		(super doit:)
		(if (> (gEgo distanceTo: mary) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 13])
				(not global108)
				(< (gEgo distanceTo: mary) 30)
			)
			(= global108 1)
			(LookAt mary)
			(mary setScript: talkScript)
		)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound stop:)
				(doorSound number: 17 loop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(gCurRoom newRoom: 39)
			)
		)
	)
)

(instance closeDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gGlobalMGSound stop:)
				(door setCycle: Beg self)
				(doorSound number: 43 loop: 1 play:)
			)
			(1
				(door stopUpd:)
				(doorSound number: 44 loop: 1 play: self)
			)
			(2
				(HandsOn)
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local6 1)
				(HandsOff)
				(mary setLoop: 5 cycleSpeed: 1 setCycle: Fwd)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{My lamb has\nwandered off!}
					dsWIDTH
					100
					dsCOORD
					115
					81
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(bellSound stop:)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(mary setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(mary setLoop: 0 cycleSpeed: 3 setCycle: Fwd)
				(= global103 0)
				(= local6 0)
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
				(= local6 1)
				(= global209 1)
				(HandsOff)
				(lamb init:)
				(gEgo setAvoider: Avoid)
				(= seconds 1)
			)
			(1
				(cond
					((and (> (gEgo x:) 250) (< (gEgo y:) 153))
						(gEgo setMotion: MoveTo 80 169)
						(lamb setMotion: MoveTo 300 155 self)
					)
					((and (< (gEgo x:) 250) (< (gEgo y:) 153))
						(gEgo setMotion: MoveTo 10 156)
						(lamb setMotion: MoveTo 8 154 self)
					)
					(else
						(gEgo setMotion: MoveTo 106 169)
						(= cycles 2)
					)
				)
				(if (> global131 1)
					(gEgo setScript: musicScript)
				)
			)
			(2
				(mary setLoop: 1 setCel: 0 cycleSpeed: 2 setCycle: End)
				(lamb
					setScript: egoScript
					setMotion: MoveTo (+ (mary x:) 9) (+ (mary y:) 7) self
				)
			)
			(3
				(lamb setLoop: 1 setCel: 0 stopUpd:)
				(door setCycle: End self)
			)
			(4
				(teacher init:)
			)
			(5
				(if (< global131 2)
					(gEgo setScript: musicScript)
				)
				(mary setLoop: 3 setCel: 3 posn: 210 159 stopUpd:)
				(if (< global131 2)
					(= cycles 2)
				)
			)
			(6
				(lamb
					setLoop: -1
					setCel: -1
					xStep: 1
					yStep: 1
					setCycle: Walk
					setMotion: Follow mary
				)
				(mary setLoop: 2 setCycle: Fwd setMotion: MoveTo 174 141 self)
			)
			(7
				(mary setLoop: 3 setCel: 4 stopUpd:)
				(lamb setCel: 0 setMotion: 0)
				(= cycles 20)
			)
			(8
				(if (< global131 2)
					(= cycles 1)
				)
			)
			(9
				(mary setLoop: 2 setCycle: Fwd setMotion: MoveTo 179 128 self)
			)
			(10
				(lamb
					setCel: -1
					setCycle: Walk
					ignoreControl: -1
					setMotion: Follow teacher
				)
				(mary setMotion: MoveTo 157 122)
				(teacher
					setLoop: 6
					setCycle: Fwd
					setMotion: MoveTo 179 128 self
				)
			)
			(11
				(mary hide:)
				(teacher setCycle: Fwd setMotion: MoveTo 157 122)
				(lamb setMotion: MoveTo 184 120 self)
			)
			(12
				(teacher dispose:)
				(door setCycle: Beg self)
			)
			(13
				(if (< global131 2)
					(= cycles 1)
				)
			)
			(14
				(lamb dispose:)
				(if (< global131 2)
					(= cycles 20)
				)
			)
			(15
				(gEgo
					setAvoider: 0
					setLoop: -1
					setCycle: Walk
					setCel: -1
					setPri: -1
				)
				(= local0 0)
				(= global103 0)
				(= seconds 3)
			)
			(16
				(gGame setSpeed: global206)
			)
			(17
				(gGlobalMGSound loop: -1)
				(if (== global208 0)
					(gGlobalMGSound play:)
				)
				(mary dispose:)
				(proc0_12)
				(rhymeBox dispose:)
				(flag show:)
				(bell setScript: bellScript show:)
				(if (== gScore gPossibleScore)
					(gEgo setAvoider: Avoid)
					(proc0_14 160 175)
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
			(= local8 1)
		)
	)
)

(instance teacherScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(teacher setCycle: Fwd setMotion: MoveTo 179 128 self)
			)
			(1
				(rhymeScript cue:)
				(teacher setCycle: Fwd setMotion: MoveTo 154 133 self)
			)
			(2
				(teacher setLoop: 3 setCel: 1 stopUpd:)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 106 169 egoScript)
			)
			(1
				(gEgo setLoop: 0 setCel: 0)
				(= cycles 2)
			)
			(2
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
				(flag hide:)
				(bell setScript: 0 hide:)
				(rhymeSound loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(= local2
					(Display
						{Mary had a little lamb,}
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
						dsSAVEPIXELS
					)
				)
			)
			(2)
			(3)
			(4)
			(5
				(= local3
					(Display
						{     its fleece as white as snow.}
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
						dsSAVEPIXELS
					)
				)
			)
			(6
				(if (> global131 1)
					(rhymeScript cue:)
				)
				(= local4
					(Display
						{And every where that Mary went,}
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
						dsSAVEPIXELS
					)
				)
			)
			(7)
			(8)
			(9)
			(10
				(= local5
					(Display
						{     the lamb was sure to go.}
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
						dsSAVEPIXELS
					)
				)
			)
			(11
				(if (> global131 1)
					(rhymeScript cue:)
				)
				(Display 13 0 dsRESTOREPIXELS local2)
				(Display 13 0 dsRESTOREPIXELS local3)
				(Display 13 0 dsRESTOREPIXELS local4)
				(Display 13 0 dsRESTOREPIXELS local5)
				(Display
					{It followed her to school one day,}
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
			)
			(12)
			(13)
			(14)
			(15
				(Display
					{     Which was against the rule.}
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
			(16
				(if (> global131 1)
					(rhymeScript cue:)
				)
				(haha init:)
				(Display
					{It made the children laugh and play}
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
			(17)
			(18)
			(19)
			(20
				(Display
					{     To see a lamb at school.}
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
			(21
				(haha hide:)
				(if (> global131 1)
					(rhymeScript cue:)
				else
					(= cycles 1)
				)
			)
			(22
				(self dispose:)
			)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 24
		priority 10
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

(instance bellSound of Sound
	(properties
		priority 7
	)
)

(instance mary of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 69
			ignoreControl: -1
			ignoreHorizon: 1
			xStep: 1
			yStep: 1
			posn: 216 157
			setLoop: 0
			setCycle: Fwd
			cycleSpeed: 3
		)
	)
)

(instance lamb of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 47
			posn: (local1 x:) (local1 y:)
			setLoop: -1
			setCycle: Walk
			setAvoider: Avoid
		)
	)
)

(instance teacher of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 69
			posn: 157 122
			setLoop: 7
			setCycle: Fwd
			xStep: 1
			yStep: 1
			cycleSpeed: (if (> global131 1) 2 else 0)
			illegalBits: 0
			setAvoider: Avoid
			setScript: teacherScript
		)
	)
)

(instance bell of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 126 posn: 179 23 setPri: 10 setLoop: 0 cycleSpeed: 3)
	)
)

(instance flag of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 126 posn: 76 22 setLoop: 4 setCycle: Fwd cycleSpeed: 1)
	)
)

(instance teeter of View
	(properties)

	(method (init)
		(super init:)
		(self view: 126 posn: 238 154 setLoop: 5 stopUpd:)
	)
)

(instance haha of View
	(properties)

	(method (init)
		(super init:)
		(self view: 69 posn: 281 134 setLoop: 4 setPri: 12 stopUpd:)
	)
)

(instance door of Prop
	(properties)

	(method (init)
		(super init:)
		(self
			view: 126
			setLoop: 1
			setCel: (if (== gPrevRoomNum 39) species else 0)
			cycleSpeed: 1
			ignoreActors: 1
			posn: 195 126
		)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self view: 133 setLoop: 6 posn: 166 109 setPri: 15 hide: stopUpd:)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self view: 39 posn: 165 130 setPri: 14 hide: stopUpd:)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 5
			bottom: 65
			right: 242
			type: 4
			title: {Mary Had a Little Lamb}
			back: 2
		)
	)
)

(instance bellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(bell setCycle: ForwardCounter 2 self)
				(= local7 1)
				(if (!= local6 1)
					(bellSound number: 36 loop: 1 play:)
				)
			)
			(2
				(= local7 0)
				(RedrawCast)
				(self init:)
			)
		)
	)
)

