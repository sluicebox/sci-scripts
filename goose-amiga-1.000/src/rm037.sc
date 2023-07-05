;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
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
	rm037 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 2]
	local8
	local9
	local10
)

(instance rm037 of Rm
	(properties
		picture 37
		style 0
		horizon 93
		south 4
		vanishingY 35
	)

	(method (init)
		(Load rsVIEW 80)
		(Load rsVIEW 43)
		(Load rsVIEW 132)
		(Load rsVIEW 52)
		(Load rsVIEW 53)
		(Load rsVIEW 36)
		(Load rsVIEW 133)
		(Load rsVIEW 37)
		(Load rsSOUND 35)
		(Load rsSOUND 3)
		(Load rsSOUND 41)
		(if (or (== global111 52) (== global111 53) (== global111 43))
			(self setScript: RoomScript)
		)
		(super init:)
		(= global207 1)
		(= global125 -1)
		(gEgo
			x: (+ (/ (* (- (gEgo x:) 137) 129) 48) 98)
			y: 185
			setScript: MusicScript
			init:
		)
		(proc0_10 48 120 164 250)
		(king init:)
		(soldier1 init:)
		(soldier2 init:)
		(lamp1 init: addToPic:)
		(lamp2 init: addToPic:)
		(table init:)
		(if global113
			(bowl init:)
		)
		(if [global675 37]
			(fiddler1 init:)
			(fiddler2 init:)
			(fiddler3 init:)
		)
		(HandsOn)
		(if (not [global675 37])
			(cond
				(global113
					(if (= local3 (proc0_11 43))
						(= global108 1)
						(= [global675 37] 1)
						(= global206 gSpeed)
						(= local0 1)
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
						(king setScript: fiddlersScript)
					)
				)
				((not (king script:))
					(cond
						(global112
							(if (proc0_11 53)
								(= global108 1)
								(= global113 1)
								(= local0 1)
								(king setScript: bowlScript)
							)
						)
						((proc0_11 52)
							(= global108 1)
							(= global112 1)
							(= local0 1)
							(king setScript: pipeScript)
						)
					)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local2 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (fiddlersScript state:) 16)
						(== local1 1)
						(== (event message:) KEY_RETURN)
					)
					(fiddlersScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (fiddlersScript state:) 16) (== local1 1))
					(fiddlersScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (fiddlersScript state:) 16) (== local1 1))
					(fiddlersScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local0 1) (< global200 3))
					(cond
						((proc0_16 event 147 53 171 89)
							(LookAt king)
							(king setScript: talkScript)
						)
						((proc0_16 event 83 76 95 119)
							(soldier1 setScript: SoldierScript)
						)
						((proc0_16 event 227 75 239 119)
							(soldier2 setScript: (Clone SoldierScript))
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(super doit:)
		(if (and (not local0) (> (gEgo distanceTo: king) 60))
			(= global108 0)
		)
		(if
			(and
				(not [global675 37])
				global112
				(== global111 53)
				(not global108)
				(< (gEgo distanceTo: king) 60)
			)
			(= global200 2)
			(= global108 1)
			(= global113 1)
			(= local0 1)
			(LookAt king)
			(king setScript: bowlScript)
		)
		(if
			(and
				(not [global675 37])
				(not global108)
				(< (gEgo distanceTo: king) 60)
			)
			(= global108 1)
			(LookAt king)
			(king setScript: talkScript)
		)
		(if (and (== (Random 0 30) 1) (== local10 9) (== global200 1))
			(self setScript: smokeScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= global103 1)
				(HandsOff)
				(king
					setLoop: 11
					setCycle: Fwd
					cycleSpeed: (if global131 1 else 0)
				)
				(itemBalloon init: setCel: 0 show:)
				(RedrawCast)
				(Display
					{Child,\nplease bring\nme my}
					dsWIDTH
					150
					dsCOORD
					1
					12
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(StrCpy
					@global270
					(cond
						(global113 {fiddlers three.})
						(global112 {bowl.})
						(else {pipe.})
					)
				)
				(Display @global270 dsWIDTH 150 dsCOORD 0 37 dsALIGN alCENTER dsFONT 0 dsCOLOR 0)
				(rhymeSound number: 41 loop: 1 play:)
				(= seconds global120)
			)
			(1
				(gEgo setAvoider: Avoid)
				(king setCel: 0 cycleSpeed: 0)
				(itemBalloon setCel: 1)
				(itemVisual init: show:)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(= global103 0)
				(HandsOn)
				(= local0 0)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance pipeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global103 1)
				(king setLoop: 2 setCel: 2)
				(smoke init:)
				(gEgo setMotion: MoveTo 159 110 self)
			)
			(1
				(proc0_18)
				(gEgo
					setMotion: 0
					setAvoider: 0
					setCycle: Walk
					setLoop: -1
					stopUpd:
				)
				(self setScript: smokeScript)
			)
			(2
				(self setScript: smokeScript)
			)
			(3
				(smokeScript dispose:)
				(king setCel: 0)
				(= seconds 2)
			)
			(4
				(= global200 1)
				(king setLoop: 2 setCel: 0)
				(proc0_12)
				(= cycles 1)
			)
			(5
				(king setScript: talkScript)
			)
		)
	)
)

(instance bowlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= global103 1)
				(HandsOff)
				(king setCel: 2)
				(gEgo setMotion: MoveTo 159 110 self)
			)
			(1
				(proc0_18)
				(gEgo
					setMotion: 0
					setAvoider: 0
					setCycle: Walk
					setLoop: -1
					stopUpd:
				)
				(king setLoop: 10 setCel: 0)
				(= seconds 2)
			)
			(2
				(bowl init:)
				(self setScript: eatScript)
			)
			(3
				(self setScript: eatScript)
			)
			(4
				(= global200 2)
				(king setLoop: 2 setCel: 0)
				(proc0_12)
				(= global111 0)
				(= local0 0)
				(king setScript: talkScript)
			)
		)
	)
)

(instance fiddlersScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(= global103 1)
				(= global209 1)
				(HandsOff)
				(king setCel: 2)
				(fiddlers init:)
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 96 133 self
				)
			)
			(1
				(proc0_18)
			)
			(2
				(gEgo setLoop: 3)
				(rhymeSound number: 3 loop: 1 play:)
				(rhymeBox init:)
				(rhymeBox open:)
				(RedrawCast)
				(fiddlers view: 80 setLoop: 5 setCel: 0 setAvoider: 0 stopUpd:)
				(king setCel: 1)
				(= cycles 10)
			)
			(3
				(gEgo stopUpd:)
				(fiddlers dispose:)
				(fiddler1 init:)
				(fiddler2 init:)
				(fiddler3 init:)
				(pipe hide:)
				(king setLoop: 3 setCel: 1)
				(smoke init:)
			)
			(4
				(self setScript: smokeScript)
				(= seconds (* global122 2))
			)
			(5
				(if global131
					(self setScript: smokeScript)
				)
				(= seconds 2)
			)
			(6
				(self cue:)
			)
			(7
				(king setCel: 0)
				(pipe show:)
				(fiddler1 setCel: 1)
				(fiddler2 setCel: 1)
				(fiddler3 setCel: 1)
				(self setScript: eatScript)
				(if global131
					(= seconds (* global122 2))
				else
					(= seconds global122)
				)
			)
			(8
				(if global131
					(self setScript: eatScript)
				)
				(= seconds 2)
			)
			(9
				(self cue:)
				(= local9 2)
			)
			(10
				(king setCel: 0)
				(if global131
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(11
				(fiddler1 setLoop: 9 setCycle: Fwd)
				(fiddler2 setLoop: 8 setCycle: Fwd)
				(fiddler3 setLoop: 9 setCycle: Fwd)
				(self setScript: danceScript)
				(if global131
					(= seconds 4)
				else
					(= seconds 2)
				)
			)
			(12
				(if global131
					(soldier1 setLoop: 1 setCycle: Fwd setMotion: MoveTo 38 110)
					(soldier2
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo 284 110 self
					)
				else
					(soldier1 setLoop: 1 setCycle: Fwd setMotion: MoveTo 68 110)
					(soldier2
						setLoop: 0
						setCycle: Fwd
						setMotion: MoveTo 254 110 self
					)
				)
			)
			(13
				(soldier1 setLoop: 0 setCycle: Fwd setMotion: MoveTo 89 110)
				(soldier2
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 233 110 self
				)
			)
			(14
				(soldier1 setLoop: 2 setCel: 1 stopUpd:)
				(soldier2 setLoop: 2 setCel: 1 stopUpd:)
				(if global131
					(= seconds 4)
				else
					(= cycles 5)
				)
			)
			(15
				(= local8 1)
			)
			(16
				(= global200 3)
				(danceScript dispose:)
				(RedrawCast)
				(king setLoop: 2 setCel: 0 stopUpd:)
				(gEgo setMotion: 0 setCycle: Walk setLoop: -1)
				(= local2 0)
				(= global103 0)
				(gGame setSpeed: global206)
			)
			(17
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(HandsOff)
					(gEgo setAvoider: Avoid)
					(gEgo setMotion: MoveTo 164 250)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
					(gEgo setAvoider: 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			((== (rhymeSound prevSignal:) -1)
				(rhymeSound prevSignal: 0)
				(fiddler1 setLoop: 7 setCel: 1 setCycle: Beg)
				(fiddler2 setLoop: 6 setCel: 1 setCycle: Beg)
				(fiddler3 setLoop: 7 setCel: 1 setCycle: Beg)
				(= local1 1)
			)
			((== (rhymeSound prevSignal:) 10)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 1)
			)
			((== (rhymeSound prevSignal:) 20)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 2)
			)
			((== (rhymeSound prevSignal:) 30)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 3)
			)
			((== (rhymeSound prevSignal:) 40)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 4)
			)
			((== (rhymeSound prevSignal:) 50)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 5)
			)
			((== (rhymeSound prevSignal:) 60)
				(rhymeSound prevSignal: 0)
				(MusicScript changeState: 6)
			)
		)
	)
)

(instance danceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(king setLoop: 0 setCycle: End self)
			)
			(1
				(king setLoop: 1 setCycle: Beg self)
			)
			(2
				(if local8
					(client cue:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance smokeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local10 10)
				(king setLoop: 3 setCel: 1)
				(= cycles 5)
			)
			(1
				(king setCel: 2)
				(smoke cel: 0 setCycle: End self)
			)
			(2
				(= cycles 2)
			)
			(3
				(= seconds 2)
				(client cue:)
			)
			(4
				(= local10 9)
			)
		)
	)
)

(instance eatScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(king setCel: 4)
				(= seconds 1)
			)
			(1
				(king setCel: 5)
				(= seconds 2)
			)
			(2
				(client cue:)
			)
		)
	)
)

(instance MusicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= local4
					(Display
						{Old King Cole was a merry old soul,}
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
			(2
				(= local5
					(Display
						{And a merry old soul was he;}
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
				(fiddlersScript changeState: 4)
			)
			(3
				(Display 37 0 dsRESTOREPIXELS local4)
				(Display 37 0 dsRESTOREPIXELS local5)
				(Display
					{He called for his pipe,}
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
			(4
				(Display
					{And he called for his bowl,}
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
			(5
				(Display
					{And he called for his fiddlers three!}
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
			(6 0)
		)
	)
)

(instance rhymeSound of Sound
	(properties
		number 3
		priority 10
	)
)

(instance king of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 80
			setPri: 10
			ignoreControl: -1
			ignoreHorizon: 1
			posn: 160 79
			setLoop: 2
			setCel: 0
			stopUpd:
		)
	)
)

(instance fiddlers of Actor
	(properties)

	(method (init)
		(super init:)
		(self
			view: 43
			posn: 164 186
			setAvoider: Avoid
			setCycle: Walk
			setMotion: MoveTo 226 133 fiddlersScript
		)
	)
)

(instance fiddler1 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 7 setCel: 0 posn: 212 133 stopUpd:)
	)
)

(instance fiddler2 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 6 setCel: 0 posn: 226 133 stopUpd:)
	)
)

(instance fiddler3 of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setLoop: 7 setCel: 0 posn: 240 133 stopUpd:)
	)
)

(instance fiddlersDone of View ; UNUSED
	(properties)

	(method (init)
		(super init:)
		(self view: 43 posn: (gEgo x:) (gEgo y:) stopUpd:)
	)
)

(instance soldier1 of Actor
	(properties)

	(method (init)
		(super init:)
		(self view: 132 setLoop: 2 setCel: 1 posn: 89 110 stopUpd:)
	)
)

(instance soldier2 of Actor
	(properties)

	(method (init)
		(super init:)
		(self view: 132 setLoop: 2 setCel: 1 posn: 233 110 stopUpd:)
	)
)

(instance smoke of Prop
	(properties)

	(method (init)
		(super init:)
		(self view: 80 setPri: 15 setLoop: 4 posn: 137 45 setCel: 255)
	)
)

(instance lamp1 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 132 setPri: 10 setLoop: 2 setCel: 0 posn: 79 30 stopUpd:)
	)
)

(instance lamp2 of View
	(properties)

	(method (init)
		(super init:)
		(self view: 132 setPri: 10 setLoop: 2 setCel: 0 posn: 244 30 stopUpd:)
	)
)

(instance pipe of View
	(properties)

	(method (init)
		(super init:)
		(self view: 52 setPri: 15 setLoop: 0 setCel: 0 posn: 137 70 stopUpd:)
	)
)

(instance bowl of View
	(properties)

	(method (init)
		(super init:)
		(self view: 53 setPri: 15 setLoop: 0 setCel: 0 posn: 185 69 stopUpd:)
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 48 137 setPri: 7 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view:
				(cond
					(global113 133)
					(global112 53)
					(else 52)
				)
			setLoop: (if global113 2 else 1)
			setCel: 0
			x:
				(cond
					(global113 72)
					(global112 74)
					(else 77)
				)
			y:
				(cond
					(global113 44)
					(global112 36)
					(else 40)
				)
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
			view: 37
			setLoop: 0
			setCel: 0
			posn: 86 53
			setPri: 14
			hide:
			stopUpd:
		)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 146
			left: 71
			bottom: 187
			right: 315
			type: 4
			title: {Old King Cole}
			back: 13
		)
	)
)

(instance SoldierScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 3 setCycle: End self)
			)
			(1
				(= cycles 5)
			)
			(2
				(client setCycle: Beg self)
			)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(fanFareSound play:)
			)
		)
	)
)

(instance fanFareSound of Sound
	(properties
		number 35
	)
)

