;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Save)
(use Motion)
(use Actor)
(use System)

(public
	Rm20 0
)

(synonyms
	(lid top)
	(doug man)
)

(local
	local0
	local1
	local2
	local3
)

(instance monkWindow of SysWindow ; UNUSED
	(properties
		color 15
		back 6
		title {Monk}
	)
)

(instance wellCap of Prop
	(properties
		view 120
	)
)

(instance Rm20 of eRoom
	(properties
		picture 20
	)

	(method (dispose)
		(SetFlag 58)
		(DisposeScript 132)
		(DisposeScript 111)
		(DisposeScript 972)
		(DisposeScript 917)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (init)
		(self
			style:
				(switch gPrevRoomNum
					(18 5)
					(19 2)
					(21 3)
					(22 4)
					(else 8)
				)
		)
		(super init:)
		(self setRegions: 104) ; glastonburyTor
		(wellCap
			setLoop: 0
			setCel: (if (== global134 0) 0 else 5)
			ignoreActors: 1
			posn: 185 111
			setPri: 10
			init:
			stopUpd:
			setScript: wellScript
		)
		(if (and (== global201 gCurRoomNum) (not (IsFlag 48)) (not (IsFlag 49)))
			((gTObj tWindow:) brLeft: 50 brRight: 250 brBottom: 120)
			(if (<= gPrevRoomNum 19)
				(gMadMonk posn: 46 155)
				(= local1 1)
			else
				((gTObj tWindow:) brBottom: 290)
				(gMadMonk posn: 200 90)
				(= local1 2)
			)
		)
		(switch gPrevRoomNum
			(18
				(cond
					((IsFlag 55)
						(ClearFlag 55)
						(self enterRoom: 33 -5 33 45)
					)
					((IsFlag 56)
						(ClearFlag 56)
						(self enterRoom: 257 -5 257 57)
					)
					(else
						(self enterRoom: 139 -5 139 60)
					)
				)
			)
			(19
				(self enterRoom: 320 83 290 83)
			)
			(21
				(self enterRoom: 13 135 25 165)
			)
			(else
				(self enterRoom: 155 235 155 182)
			)
		)
		(gAddToPics doit:)
	)

	(method (notify)
		(gMadMonk setScript: runAway)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((and (< (gEgo x:) 30) (< 56 (gEgo y:) 140))
				(gEgo illegalBits: 0)
				(self leaveRoom: 21 13 135)
			)
			((> (gEgo x:) 310)
				(self leaveRoom: 19 320 (gEgo y:))
			)
			((< (gEgo x:) 10)
				(self leaveRoom: 21 -10 (gEgo y:))
			)
			((> (gEgo y:) 188)
				(self leaveRoom: (if (IsFlag 52) 17 else 22) (gEgo x:) 235)
			)
			((and (< (gEgo y:) 40) (< 72 (gEgo x:) 233))
				(gEgo illegalBits: 0)
				(self leaveRoom: 18 (gEgo x:) -5)
			)
			((< (gEgo y:) 20)
				(cond
					((< (gEgo x:) 72)
						(SetFlag 55)
					)
					((> (gEgo x:) 233)
						(SetFlag 56)
					)
				)
				(gEgo illegalBits: 0)
				(self leaveRoom: 18 (gEgo x:) -5)
			)
			(
				(or
					(and (== local1 1) (not local0) (< (gEgo x:) 95))
					(and (== local1 2) (not local0) (< (gEgo y:) 108))
				)
				(gMadMonk setScript: runAway)
			)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			((MouseClaimed wellCap event)
				(if (== global134 1)
					(Print 20 0) ; "You have opened the well."
				else
					(Print 20 1) ; "The well lid is iron, with a solid iron bar and a lock holding it in place."
				)
			)
			((OnButton event 143 111 225 159)
				(if (== global134 0)
					(Print 20 2) ; "It has the shape and look of a well, though covered with a heavy iron lid."
				else
					(Print 20 3) ; "The cold waters of the sacred well are dark and reveal nothing."
				)
			)
			((or (OnButton event 32 15 97 137) (OnButton event 222 7 268 148))
				(Print 20 4) ; "The ruins are nothing but bits of wall and fallen rock with only the Tor beneath them."
			)
			((and (== global201 gCurRoomNum) (Said 'draw/blade')) 0)
			((Said 'look,force,annihilate/lock')
				(Print 20 5) ; "It is fit into the iron bar and would therefore be impossible to break open by ordinary means."
			)
			((or (Said 'look/water') (Said 'look<in/spring'))
				(cond
					((== global134 0)
						(Print 20 6) ; "A good idea, though difficult to do unless you can remove the lid."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 7) ; "It would help to be on the other side of the well."
					)
					((not (gEgo inRect: 130 140 240 170))
						(Print 20 8) ; "It would help to be next to the well."
					)
					(else
						(Print 20 3) ; "The cold waters of the sacred well are dark and reveal nothing."
					)
				)
			)
			((Said 'cut,cut,cut/tree,thorn,branch')
				(Print 20 9) ; "Nay, if this is the thorn planted by Joseph of Arimathea, it would be tantamount to sacrilege."
			)
			((Said 'look<in/tree')
				(Print 20 10) ; "It is full of thorns."
			)
			((Said 'look<below/spring')
				(Print 20 11) ; "I cannot imagine how you would do that."
			)
			((Said 'look<below/tree')
				(Print 20 12) ; "Besides roots and shadow, there is not much to see."
			)
			((Said 'look<down')
				(if
					(or
						(gEgo inRect: 130 140 240 170)
						(gEgo inRect: 130 105 240 135)
					)
					(Print 20 13) ; "The sacred well is covered with a heavy lid and a solid iron bar in the shape of interlocked circles, held in place by a lock."
				else
					(event claimed: 0)
				)
			)
			(
				(or
					(Said 'reach,feel/spring,water')
					(Said 'search[/spring,water]')
					(Said 'drop/arm,hand/water,spring')
					(and
						(== global134 1)
						(or (Said 'find/grail') (Said 'look,search//grail'))
					)
				)
				(cond
					((== global134 0)
						(Print 20 14) ; "We can only assume there is water in this well until it is opened."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 15) ; "It would help to be on the other side the well."
					)
					((not (gEgo inRect: 130 140 240 170))
						(Print 20 8) ; "It would help to be next to the well."
					)
					(else
						(wellScript changeState: 12)
					)
				)
			)
			(
				(or
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said '/ruin')
							(Said '//ruin')
						)
						(cond
							((!= global201 gCurRoomNum)
								(Print 20 16) ; "The covered well is in this section of the ruins."
							)
							((IsFlag 49)
								(Print 20 17) ; "There is the well and thorn tree, as before."
							)
							(else
								(Print 20 18) ; "There is the cowled figure of a monk near a covered well."
							)
						)
					)
					(
						(or
							(Said '/arch')
							(Said '//arch')
							(OnButton event 9 31 31 125)
						)
						(Print 20 19) ; "The arch is all that remains of a doorway."
					)
					(
						(or
							(Said '/tree')
							(Said '//tree')
							(OnButton event 243 91 303 174)
						)
						(Print 20 20) ; "The one small tree is covered in thorns. The legend of Joseph of Arimathea has it that when he hid the Grail, he also stuck his staff into the ground and from that place a thorn tree grew."
					)
					((or (Said '/spring') (Said '//spring'))
						(if (== global134 0)
							(Print 20 21) ; "It is covered with a heavy iron lid."
						else
							(Print 20 22) ; "The well is filled with cold, dark water."
						)
					)
					((or (Said '/lid') (Said '//lid'))
						(if (== global134 1)
							(Print 20 23) ; "There is nothing more to be gained by looking at it now."
						else
							(Print 20 24) ; "It is held in place by a locked iron bar."
						)
					)
					(
						(or
							(Said '/bar,design,circle')
							(Said '//bar,design,circle')
						)
						(Print 20 25) ; "The iron bar forms a design of interlocking circles. Lovely, but too solid to break."
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'get,drink/water,drink')
				(cond
					((== global134 0)
						(Print 20 26) ; "You could, if the well were open."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 27) ; "The well opening is upon the other side."
					)
					((not (gEgo inRect: 130 140 240 170))
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(= local3 1)
						(wellScript changeState: 12)
					)
				)
			)
			((Said 'pick/lock,spring,lid')
				(Print 20 28) ; "You cannot pick this lock."
			)
			((Said 'climb,jump<(on,onto)/spring,lid,tree')
				(Print 20 29) ; "That is not a very useful idea."
			)
			(
				(or
					(Said 'dive,jump,climb,get<(in,in)/spring')
					(Said 'enter[<in,in]/spring')
				)
				(if (== global134 0)
					(Print 20 30) ; "Do your eyes fail you? The well is closed."
				else
					(Print 20 31) ; "This well is both ancient and sacred. A bit of decorum is called for."
					(Print 20 32) ; "One does not swim in sacred wells, and this one has been revered for centuries."
				)
			)
			((Said 'get>')
				(cond
					((Said '/thorn')
						(Print 20 33) ; "Beyond the pleasure of being stuck by them, I can see no purpose in that."
					)
					((Said '/spring')
						(Print 20 34) ; "I cannot imagine how one would do that."
					)
				)
			)
			((Said 'remove,move,open,lift/spring,lid,lock,bar')
				(cond
					((== global134 1)
						(Print 20 35) ; "Do your eyes fail you? It IS open."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 36) ; "The latch and lock are upon the other side."
					)
					((not (IsFlag 64))
						(Print 20 37) ; "To lift the lid, you must remove the bar. To remove the bar, you must open the lock. You will not open the lock by wishful thinking."
					)
					(else
						(wellScript changeState: 4)
					)
				)
			)
			((Said 'lock/spring,lid,lock,bar')
				(if (IsFlag 64)
					(Print 20 38) ; "Leave it open, Arthur, so that others who follow may drink from the sacred waters."
				else
					(Print 20 39) ; "It is already locked."
				)
			)
			((or (Said 'use/key') (Said 'unlock/spring,lid,lock,bar'))
				(cond
					((or (== global134 1) (IsFlag 64))
						(Print 20 40) ; "The well is already unlocked."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 36) ; "The latch and lock are upon the other side."
					)
					((not (gEgo inRect: 130 140 240 170))
						(NotClose) ; "Perhaps you should move closer."
					)
					((not (gEgo has: 6)) ; iron_key | broom | grail
						(Print 20 41) ; "You do not have the means."
					)
					(else
						(wellScript changeState: 1)
					)
				)
			)
			((Said 'replace,close/spring,lid,lock,bar')
				(cond
					((== global134 0)
						(Print 20 42) ; "Do your eyes fail you? It IS closed."
					)
					((gEgo inRect: 130 105 240 135)
						(Print 20 43) ; "The lid closes from the other side."
					)
					((not (gEgo inRect: 130 140 240 170))
						(NotClose) ; "Perhaps you should move closer."
					)
					(else
						(wellScript changeState: 9)
					)
				)
			)
			(
				(or
					(Said 'cut,force/spring,lock,lid')
					(Said 'use/blade/spring,lock,lid')
				)
				(if (== global134 0)
					(Print 20 44) ; "That would only damage Excaliber."
				else
					(Print 20 45) ; "What nonsense is this?"
				)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(gTObj actor: 0 talkCue: 0 endTalk:)
				(gMadMonk
					setLoop: 5
					setCycle: Walk
					setStep: 6 5
					illegalBits: 0
					ignoreActors: 1
				)
				(if (== local1 1)
					(gMadMonk setMotion: MoveTo -5 159 self)
					(= register 21)
				else
					(gMadMonk setMotion: MoveTo 52 2 self)
					(= register 18)
				)
			)
			(1
				(= global201 register)
				(gMadMonk setMotion: 0 setCycle: 0 dispose:)
			)
		)
	)
)

(instance wellScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 156 self)
			)
			(2
				(gEgo loop: 3)
				(= seconds 2)
			)
			(3
				(gEgo illegalBits: -32768)
				(Print 20 46) ; "The key turned easily and the lock is now open."
				(SetFlag 64)
				(HandsOn)
			)
			(4
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 154 self)
			)
			(5
				(gEgo view: 34 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(gEgo setCycle: Beg self)
				(wellCap setCycle: End)
				(= global134 1)
			)
			(7
				(gEgo
					view: 0
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 176 160 self
				)
			)
			(8
				(wellCap stopUpd:)
				(gEgo setLoop: -1 loop: 3 illegalBits: -32768)
				(HandsOn)
			)
			(9
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 154 self)
			)
			(10
				(wellCap setCycle: Beg self)
			)
			(11
				(wellCap stopUpd:)
				(gEgo illegalBits: -32768)
				(HandsOn)
				(= global134 0)
			)
			(12
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 176 153 self)
			)
			(13
				(gEgo view: 34 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(14
				(gEgo setLoop: 2 cycleSpeed: 1 setCycle: Fwd)
				((= local2 (Prop new:))
					view: 34
					setLoop: 3
					cel: 0
					setPri: 10
					posn: 184 125
					init:
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 4)
			)
			(15
				(local2 dispose:)
				(gEgo cycleSpeed: 0)
				(cond
					(local3
						(= local3 0)
						(Print 20 47) ; "From the shiver that just ran through you, I gather the water was ice-cold."
						(self changeState: 7)
					)
					((IsFlag 50)
						(Print 20 48) ; "Did I not say the Grail was not here? You have only a wet hand to show for your stubbornness."
						(self changeState: 7)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(16
				(gEgo setLoop: 4 setCel: 0 setCycle: End self)
			)
			(17
				(Print 20 49) ; "So THIS is the Mad Monk's treasure! A beautiful, glittering crystal heart. How cold it is to the touch!"
				(Print 20 50) ; "Alas, Arthur, this is the object of power that created the Spell of Circular Entrapment. The Grail is not here."
				(SetScore 0 0 5)
				(SetFlag 50)
				(gEgo get: 7) ; crystal_heart | charcoal | helm
				(SetFlag 52)
				(self changeState: 7)
			)
		)
	)
)

(instance flapArms of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMadMonk setCycle: End self)
			)
			(1
				(gMadMonk setCycle: Beg self)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

