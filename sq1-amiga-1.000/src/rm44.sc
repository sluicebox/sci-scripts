;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm44 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if local1
		(localproc_1)
	)
	(= local1 (Display &rest dsALIGN alCENTER dsWIDTH 160 dsCOORD 80 126 dsCOLOR global129 dsSAVEPIXELS))
)

(procedure (localproc_1)
	(Display 44 20 dsRESTOREPIXELS local1)
	(= local1 0)
)

(procedure (localproc_2 param1 param2 param3)
	(InRect
		(param1 nsLeft:)
		(param1 nsTop:)
		(param1 nsRight:)
		(param1 nsBottom:)
		param2
		param3
	)
)

(instance rm44 of Rm
	(properties
		lookStr {It's a "Slots-O-Death" slot machine. They play for keeps around here.}
		picture 44
	)

	(method (init &tmp [temp0 30])
		(LoadMany rsSOUND 621 619 620 625 627 628 629)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(if (< global106 4)
			(gLongSong stop:)
		)
		(super init:)
		(HandsOn)
		(ClearFlag 12)
		(tmp1 init: stopUpd:)
		(tmp2 init: stopUpd:)
		(tmp3 init: stopUpd:)
		(butn init:)
		(exitBtn init: stopUpd:)
		(coinSlot init:)
		(info init: cel: 1 stopUpd:)
		(pic1 cel: (& global174 $000f) init:)
		(pic2 cel: (& (>> global174 $0004) $000f) init:)
		(pic3 cel: (& (>> global174 $0008) $000f) init:)
		(gLongSong setVol: 70)
		(if global175
			(info cel: 1 stopUpd:)
			(localproc_0 (Format @temp0 44 0 global175 global165)) ; "You Bet $%u You Have $%u"
		else
			(info setCycle: Fwd)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(cond
			((coinSlot onMe:)
				(gGame setCursor:)
			)
			((butn)
				(gGame setCursor:)
			)
		)
		(= temp2 (User curEvent:))
		(= temp0 ((User curEvent:) x:))
		(= temp1 ((User curEvent:) y:))
		(if
			(and
				(gEgo has: 10) ; buckazoid
				(localproc_2 coinSlot temp0 temp1)
				(not local3)
			)
			(= local3 (gTheIconBar curIcon:))
			(= local4 (gTheIconBar curInvIcon:))
			(gTheIconBar at: 6 curIcon: (gTheIconBar at: 6) curInvIcon: (Inv at: 10)) ; buckazoid
			(gGame setCursor: ((gTheIconBar curInvIcon:) cursor:))
		)
		(if
			(and
				global175
				(localproc_2 butn temp0 temp1)
				(not local3)
				(!= (gTheIconBar curIcon:) (gTheIconBar at: 2))
			)
			(= local3 (gTheIconBar curIcon:))
			(= local4 (gTheIconBar curInvIcon:))
			(gTheIconBar at: 2 curIcon: (gTheIconBar at: 2))
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		)
		(if
			(and
				local3
				(or
					(and
						(not (gEgo has: 10)) ; buckazoid
						(localproc_2 coinSlot temp0 temp1)
					)
					(and
						(not (localproc_2 coinSlot temp0 temp1))
						(not (localproc_2 butn temp0 temp1))
					)
				)
			)
			(gTheIconBar curIcon: local3 curInvIcon: local4)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			(= local4 0)
			(= local3 0)
		)
		(temp2 dispose:)
	)

	(method (dispose)
		(= global174
			(+ (pic1 cel:) (<< (pic2 cel:) $0004) (<< (pic3 cel:) $0008))
		)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gLongSong setVol: 127)
		(gLongSong2 flags: 0)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(not (pic3 script:))
					(not (gCurRoom script:))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(gCurRoom newRoom: 43)
				(event claimed: 1)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
					(== (gTheIconBar curInvIcon:) (Inv at: 15)) ; Widget
					(== (event message:) JOY_DOWNRIGHT)
					(not (pic3 script:))
					(not (gCurRoom script:))
				)
				(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
				(SetFlag 12)
				(gCurRoom newRoom: 43)
				(event claimed: 1)
			)
		)
	)
)

(instance initScript of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp [temp0 30])
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(if global175
					(info cel: 1 stopUpd:)
					(localproc_0 (Format @temp0 44 0 global175 global165)) ; "You Bet $%u You Have $%u"
				else
					(info setCycle: Fwd)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance spinPic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(client setMotion: MoveTo (client x:) 8 self)
					(register
						loop: 1
						cel: (+ (client cel:) 1)
						posn: (client x:) 96
						setMotion: MoveTo (client x:) 52
					)
				else
					(client stopUpd:)
					(self dispose:)
				)
			)
			(1
				(client cel: (register cel:) y: 52)
				(cond
					((register priority:) 0)
					((client priority:)
						(client setPri: (- (client priority:) 1))
					)
					((and (== local2 1) (== (client cel:) 0))
						(register loop: 3)
						(slotSound number: 621 loop: 1 play:)
						(= register 0)
					)
					(local2
						(if (== (client cel:) (- local2 1))
							(slotSound number: 621 loop: 1 play:)
							(register loop: 3)
							(= register 0)
						)
					)
					((Random 0 4)
						(slotSound number: 621 loop: 1 play:)
						(register loop: 3)
						(= register 0)
					)
				)
				(self init:)
			)
		)
	)
)

(instance spinDone of Script
	(properties)

	(method (changeState newState &tmp [temp0 30])
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= local0
					(cond
						((== (pic1 cel:) (pic2 cel:) (pic3 cel:))
							(switch (pic1 cel:)
								(0 1000)
								(2 5)
								(3 10)
								(1 20)
							)
						)
						((== 2 (pic1 cel:) (pic2 cel:)) 3)
						((== 2 (pic1 cel:)) 1)
						(else
							(switch (Random 0 6)
								(0
									(localproc_0 44 2) ; "Eat Sand"
								)
								(1
									(localproc_0 44 3) ; "No Way"
								)
								(2
									(localproc_0 44 4) ; "Not A Chance"
								)
								(3
									(localproc_0 44 5) ; "It's Hopeless"
								)
								(4
									(localproc_0 44 6) ; "Tough Luck"
								)
								(5
									(localproc_0 44 7) ; "Suck Methane"
								)
								(6
									(localproc_0 44 8) ; "So Sorry"
								)
							)
							0
						)
					)
				)
				(= cycles 3)
			)
			(2
				(gLongSong2
					number:
						(cond
							((== local0 1000) 626)
							((>= local0 5) 620)
							((< 0 local0 5) 619)
							(else 629)
						)
					loop: 1
					play: self
				)
			)
			(3
				(if (!= local0 1000)
					(+= global165 (* local0 global175))
					(if local0
						(if (not (gEgo has: 10)) ; buckazoid
							(gEgo get: 10) ; buckazoid
						)
						(localproc_0
							(Format @temp0 44 9 (* local0 global175) global165) ; "You Win $%u You Have $%u"
						)
						(if (> global165 300)
							(SetFlag 63)
							(Print 44 10) ; "You step back nervously as the over-heated slot machine begins to sputter and smoke."
							(gCurRoom newRoom: 43)
						)
					)
					(= global175 0)
					(= seconds 4)
				else
					(SetFlag 39)
					(localproc_0 44 11) ; "YOU LOSE, HOMEBOY!"
					(gCurRoom newRoom: 43)
				)
			)
			(4
				(localproc_1)
				(info cel: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance pic1 of Actor
	(properties
		x 95
		y 52
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		priority 10
		signal 18448
	)

	(method (cue)
		(tmp2 setPri: 0)
		(tmp1 loop: 3)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 44 12) ; "The pictures are protected by unbreakable windows."
			)
			(11 ; Taste
				(Print 44 13) ; "Very good! You got all that gunk off the glass. Licking the glass windows makes the pictures easier to see."
			)
			(12 ; Smell
				(Print 44 14) ; "A slight smell of ozone and charred meat permeates the machine."
			)
			(4 ; Inventory
				(switch invItem
					(15 ; Widget
						(if (or (pic3 script:) (gCurRoom script:))
							0
						else
							(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
							(SetFlag 12)
							(gCurRoom newRoom: 43)
						)
					)
					(10 ; buckazoid
						(Print 44 15) ; "You're supposed to put your money in the money slot."
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pic2 of Actor
	(properties
		x 160
		y 52
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		cel 3
		priority 10
		signal 18448
	)

	(method (cue)
		(tmp3 setPri: 0)
		(tmp2 loop: 3)
		(super cue: &rest)
	)

	(method (doVerb)
		(pic1 doVerb: &rest)
	)
)

(instance pic3 of Actor
	(properties
		x 223
		y 52
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		cel 2
		priority 10
		signal 18448
	)

	(method (cue)
		(gCurRoom setScript: spinDone)
		(tmp3 loop: 3)
		(gLongSong2 hold: 0)
		(super cue: &rest)
	)

	(method (doVerb)
		(pic1 doVerb: &rest)
	)
)

(instance tmp1 of Actor
	(properties
		x 95
		y 94
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		signal 18448
	)

	(method (doVerb)
		(pic1 doVerb: &rest)
	)
)

(instance tmp2 of Actor
	(properties
		x 160
		y 94
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		priority 10
		signal 18448
	)

	(method (doVerb)
		(pic1 doVerb: &rest)
	)
)

(instance tmp3 of Actor
	(properties
		x 223
		y 94
		description {pretty picture}
		lookStr {These are the slot machine's pretty pictures. Put some money in the slot, push the button, and watch them go 'round and 'round.}
		yStep 11
		view 144
		loop 1
		priority 10
		signal 18448
	)

	(method (doVerb)
		(pic1 doVerb: &rest)
	)
)

(instance coinSlot of Feature
	(properties
		nsTop 126
		nsLeft 50
		nsBottom 156
		nsRight 84
		description {buckazoid slot}
		lookStr {This is where you deposit buckazoids. You may deposit up to three buckazoids for each spin.}
	)

	(method (doVerb theVerb invItem &tmp [temp0 30])
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(cond
							((or (pic3 script:) (gCurRoom script:)) 0)
							((not global165)
								(Print 44 16) ; "Who are you trying to kid? You don't have any more buckazoids to gamble with. Hit the sand, pal."
							)
							((< global175 3)
								(gSoundEffects number: 625 loop: 1 play:)
								(if (not global175)
									(info setCycle: 0 cel: 1 stopUpd:)
								)
								(++ global175)
								(if (not (-- global165))
									(Print 44 17) ; "With shaking hands, you insert your last buckazoid into the "Slots-O-Death" machine."
									(gEgo put: 10) ; buckazoid
								)
								(localproc_0
									(Format @temp0 44 0 global175 global165) ; "You Bet $%u You Have $%u"
								)
							)
							(else
								(Print 44 18) ; "The "Slots-O-Death" machine will let you insert only three buckazoids per spin."
							)
						)
					)
					(15 ; Widget
						(if (or (pic3 script:) (gCurRoom script:))
							0
						else
							(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
							(SetFlag 12)
							(gCurRoom newRoom: 43)
						)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance butn of Feature
	(properties
		nsTop 125
		nsLeft 238
		nsBottom 155
		nsRight 272
		description {button}
		lookStr {Push this button to start the wheels spinning.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((or (pic3 script:) (gCurRoom script:)) 0)
					((not global175)
						(gCurRoom setScript: pleaseInsert)
					)
					((IsFlag 13)
						(= local0
							(switch (= local2 (Random 2 4))
								(2 5)
								(3 20)
								(4 10)
							)
						)
					)
					((not global165)
						(= local2 1)
					)
					((not (Random 0 6))
						(= local2 1)
					)
					(else
						(= local2 0)
					)
				)
				(if (and global175 (not (pic3 script:)) (not (gCurRoom script:)))
					(gSoundEffects number: 627 loop: 1 play:)
					(gLongSong2 number: 628 loop: 1 flags: 1 play: hold: 1)
					(pic1 setPri: 10 setScript: (Clone spinPic) pic1 tmp1)
					(pic2 setPri: 10 setScript: (Clone spinPic) pic2 tmp2)
					(pic3 setPri: 10 setScript: (Clone spinPic) pic3 tmp3)
					(tmp2 setPri: 1)
					(tmp3 setPri: 1)
				)
			)
			(4 ; Inventory
				(if (== invItem 15) ; Widget
					(if (or (pic3 script:) (gCurRoom script:))
						0
					else
						(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
						(SetFlag 12)
						(gCurRoom newRoom: 43)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pleaseInsert of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(info setCycle: 0 cel: 1)
				(localproc_0 44 19) ; "Insert a buckazoid  into the slot."
				(= seconds 3)
			)
			(1
				(localproc_1)
				(info setCycle: Fwd)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance info of Prop
	(properties
		x 166
		y 133
		description {information window}
		lookStr {This little window tells you how to win, how much you can win, and other useful information.}
		view 144
		cel 3
		priority 14
		signal 16
		cycleSpeed 150
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (== invItem 15) ; Widget
					(if (or (pic3 script:) (gCurRoom script:))
						0
					else
						(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
						(SetFlag 12)
						(gCurRoom newRoom: 43)
					)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance exitBtn of Prop
	(properties
		x 160
		y 186
		description {exit button}
		lookStr {This button takes you back to the bar.}
		view 244
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (== theVerb 4) (== invItem 15)) ; Inventory, Widget
				(if (or (pic3 script:) (gCurRoom script:))
					0
				else
					(Print 44 1) ; "You step back and place the widget on the slot machine. Let's see what this baby can do."
					(SetFlag 12)
					(gCurRoom newRoom: 43)
				)
			)
			((OneOf theVerb 3 11 1) ; Do, Taste, ???
				(if (or (pic3 script:) (gCurRoom script:))
					0
				else
					(self cel: 1)
					(Animate (gCast elements:) 0)
					(Animate (gCast elements:) 0)
					(Animate (gCast elements:) 0)
					(gCurRoom newRoom: 43)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance slotSound of Sound
	(properties)
)

