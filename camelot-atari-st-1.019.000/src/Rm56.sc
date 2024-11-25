;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use ione_156)
(use Mari)
(use mo)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm56 0
	openShutters 1
	closeShutters 2
)

(local
	local0
)

(instance mariLShutter of Prop
	(properties
		y 34
		x 140
		view 156
		priority 10
		signal 16400
	)
)

(instance mariRShutter of Prop
	(properties
		y 34
		x 114
		view 156
		loop 1
		priority 10
		signal 16400
	)
)

(instance moLeftLShutter of View
	(properties
		y 85
		x 57
		view 156
		loop 2
		cel 6
		priority 10
		signal 16
	)
)

(instance moRightLShutter of View
	(properties
		y 85
		x 103
		view 156
		loop 3
		cel 6
		priority 10
		signal 16
	)
)

(instance moLeftRShutter of View
	(properties
		y 84
		x 148
		view 156
		loop 2
		cel 6
		priority 10
		signal 16
	)
)

(instance moRightRShutter of View
	(properties
		y 84
		x 192
		view 156
		loop 3
		cel 6
		priority 10
		signal 16
	)
)

(instance moDoor of PV
	(properties
		y 133
		x 218
		view 256
	)
)

(instance Rm56 of Rm
	(properties
		picture 56
	)

	(method (init)
		(if (== global202 0)
			(= global101 0)
		)
		(super init:)
		(Load rsVIEW 156)
		(Load rsVIEW 256)
		(self setRegions: 152) ; Bazaar
		(if (== global202 2)
			(Load rsVIEW 348)
			(SetFlag 20)
			(self setRegions: 116) ; muleReg
		)
		(switch gPrevRoomNum
			(57
				(gEgo posn: (- 320 (gEgo x:)) 180 loop: 3)
			)
			(58
				(gEgo posn: 300 (gEgo y:))
			)
			(else
				(if (== global202 0)
					(gEgo posn: 20 150 loop: 0)
				else
					(gEgo posn: 20 160 loop: 0 setMotion: MoveTo 40 160)
				)
				(if (IsFlag 20)
					(gMuleObj posn: 20 175 setMotion: MoveTo 35 175)
				)
			)
		)
		(if (and (!= global202 0) (!= global202 3))
			((ScriptID 158 0) init:) ; mo
		)
		(mariLShutter init: setCel: 255 stopUpd:)
		(mariRShutter init: setCel: 255 stopUpd:)
		(gAddToPics add: moDoor)
		(cond
			((== global202 0)
				(Load rsSCRIPT 158)
				(gAddToPics doit:)
				(gCurRoom setScript: thiefRobs)
			)
			((and (IsFlag 134) (or (not (IsItemAt 11)) (IsItemAt 13))) ; mirror | golden_apple, veil
				((ScriptID 157 0) init:) ; Mari
			)
			((and (not (IsFlag 156)) (== global146 7))
				(= local0 1)
				((ScriptID 156) init:) ; ione
			)
		)
		(if (!= global202 0)
			(gAddToPics
				add:
					moLeftRShutter
					moRightRShutter
					moLeftLShutter
					moRightLShutter
			)
			(gAddToPics doit:)
		)
	)

	(method (notify)
		(cond
			((and (IsFlag 145) (gEgo inRect: 60 0 210 200))
				(proc157_1)
			)
			((!= global202 3)
				(if
					(and
						(not (thiefRobs script:))
						(gEgo inRect: 168 139 313 187)
					)
					(proc158_1)
				else
					(return 0)
				)
			)
			(local0
				(proc156_1)
			)
			(else
				(return -1)
			)
		)
		(return 1)
	)

	(method (newRoom newRoomNumber)
		(gEgo setScript: 0)
		(ClearFlag 145)
		(switch global202
			(0
				(= global202 1)
				(if
					(and
						(== (gCurRoom script:) thiefRobs)
						(thiefRobs script:)
						(<= (thiefRobs state:) 2)
					)
					((thiefRobs script:) dispose:)
				)
				(if (!= newRoomNumber 57)
					(ClearFlag 143)
				)
			)
			(2
				(= global202 1)
				(SetFlag 20)
				(gMuleObj cycleSpeed: 0)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 158)
		(DisposeScript 157)
		(DisposeScript 156)
		(DisposeScript 159)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((< (gEgo x:) 20)
				(if (IsFlag 223)
					(Print 56 0) ; "The guards remain and will not let you leave. Do not annoy them, Arthur. There are many more of them and they are all well armed."
					(gEgo setMotion: MoveTo (+ (gEgo x:) 4) (gEgo y:))
				else
					(gCurRoom newRoom: 54)
				)
			)
			((> (gEgo x:) 300)
				(gCurRoom newRoom: 58)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 57)
			)
		)
	)

	(method (handleEvent event)
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
			(
				(or
					(Said 'look,read/sign,lettering,design,arma')
					(Said 'ask[/merlin]/sign,lettering,design,arma')
					(OnButton event 162 14 208 35)
					(OnButton event 40 25 98 51)
					(OnButton event 105 42 143 52)
					(OnButton event 219 40 267 53)
				)
				(Print 56 1) ; "In Latin, the sign reads "Arma" meaning weaponry or armour. Mohammed is the name of the merchant."
				(Print 56 2) ; "The Islamic symbols above his name are the crescent moon and a scimitar. The rest is in Arabic."
			)
			((or (== (event type:) evMOUSEBUTTON) (Said 'look,ask,(are<where)>'))
				(cond
					((Said 'look<in/business')
						(Print 56 3) ; "It is difficult to see through the shutters."
					)
					((Said 'look<up[/mari,building,business]')
						(if (IsFlag 145)
							(Print 56 4) ; "My, quite a view."
						else
							(Print 56 5) ; "The second floor of this building has a window and a balcony."
						)
					)
					((Said 'look<across/street')
						(Print 56 6) ; "Across the street are more merchants."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
						)
						(cond
							((IsFlag 137)
								(Print 56 7) ; "The weapons shop is closed."
							)
							((and local0 (IsFlag 156))
								(Print 56 8) ; "There is nothing more to be gained here. Do as she instructs."
							)
							(local0
								(Print 56 9) ; "There is now a girl crying in front of Mohammed's shop. And see, her doves have escaped."
							)
							((and (IsFlag 145) (== global202 3))
								(Print 56 10) ; "Mohammed's shop may be closed, but it appears Mari is open for business."
							)
							((and (not (IsFlag 145)) (== global202 3))
								(Print 56 11) ; "The weapon merchant's shop is closed."
							)
							((== global202 2)
								(Print 56 12) ; "Your mule is being held safely by the weapons merchant. You are fortunate he is an honest man."
							)
							(else
								(Print 56 13) ; "The weapons merchant looks sympathetic. I suspect this is not the first time he has seen this thief in action."
							)
						)
					)
					(
						(or
							(Said '/business,goods,building')
							(Said '//business,goods,building')
						)
						(Print 56 7) ; "The weapons shop is closed."
					)
					(
						(or
							(Said '/dagger,scimitar')
							(Said '//dagger,scimitar')
							(OnButton event 162 14 208 35)
						)
						(Print 56 14) ; "The scimitar is a common Islamic emblem."
					)
					(
						(or
							(Said '/crescent,crescent')
							(Said '//crescent,crescent')
							(OnButton event 162 14 208 35)
						)
						(Print 56 15) ; "The crescent moon is a symbol of the Goddess."
					)
					((Said '<(in,through)/window,shutter')
						(Print 56 16) ; "It is dark inside and you can see nothing."
					)
					(
						(or
							(Said '/window,shutter')
							(Said '//window,shutter')
							(OnButton event 113 7 141 38)
							(OnButton event 55 85 102 113)
							(OnButton event 148 86 193 114)
						)
						(Print 56 17) ; "The windows downstairs are closed. One of the windows upstairs is closed."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 218 85 252 134)
						)
						(Print 56 18) ; "It is closed."
					)
					((or (Said '/balcony') (Said '//balcony'))
						(Print 56 19) ; "There is no way up to it from here."
					)
					((or (Said '/stair') (Said '//stair'))
						(Print 56 20) ; "There are no stairs."
					)
					(
						(or
							(Said '/boulder')
							(Said '//boulder')
							(OnButton event 261 127 294 140)
						)
						(Print 56 21) ; "Aye, they are rocks."
					)
					((Said '//con')
						(Print 56 22) ; "Watch for him if you like, but I doubt he will come near you again."
					)
				)
			)
			((Said 'look,talk/mohammed,merchant,guard,man')
				(Print 56 23) ; "He is gone, as you can see."
			)
			((Said 'throw/*<at/window,shutter,mari')
				(Print 56 24) ; "A dubious tactic at best."
			)
			((Said 'talk/mari')
				(Print 56 25) ; "First you must get her attention."
			)
			((or (Said 'call,yell[/mari]') (Said 'call,yell//mari'))
				(gEgo setScript: callMari)
			)
			((and (not (IsFlag 145)) (or (Said '/mari') (Said '//mari')))
				(Print 56 26) ; "She is not here."
			)
			((and (not local0) (or (Said '*/ione') (Said '//ione')))
				(Print 56 27) ; "She is gone."
			)
			((Said 'use,pick,lift,throw/boulder')
				(Print 56 28) ; "These rocks are too heavy for any practical use."
			)
			((Said 'open/door')
				(Print 56 29) ; "The door is locked."
			)
			((Said 'knock[/door]')
				(if (gEgo inRect: 203 132 266 154)
					(Print 56 30) ; "No one answers."
				else
					(NotClose) ; "Perhaps you should move closer."
				)
			)
			((Said 'buy/weapon,blade,shield,armor,dagger')
				(Print 56 31) ; "You would not need to, even if the weapons merchant were here."
			)
			((Said 'open,annihilate/shutter,window')
				(Print 56 32) ; "And be mistaken for a thief?! Do not be a fool. Besides, you could find nothing better than Excaliber, even in this shop."
			)
			((Said 'climb,go/awning,window,wall')
				(Print 56 33) ; "Totally impractical with all your gear, not to mention how it might excite the city guards."
			)
			((Said 'climb,go/balcony')
				(Print 56 19) ; "There is no way up to it from here."
			)
			(
				(or
					(Said 'talk/merlin')
					(Said 'ask/advice')
					(Said 'ask[/merlin]/advice')
				)
				(cond
					((IsFlag 20)
						(Print 56 34) ; "You should have paid more attention to the scroll in my room before you left Camelot."
					)
					((IsFlag 137)
						(Print 56 35) ; "Why do you waste time here?"
					)
					((gEgo has: 3) ; purse
						(Print 56 36) ; "Remember, you are dealing with Arab money now. A fals is a copper coin. 4 fals are worth a dirham which is silver. 4 dirhams equal a dinar, which is gold."
					)
					(else
						(event claimed: 0)
					)
				)
			)
		)
	)
)

(instance closeShutters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(global184 setLoop: 0 setCel: 0 posn: 127 35 setPri: 11)
				(mariLShutter cel: 0 setCycle: CT 1 1 self)
				(mariRShutter cel: 0 setCycle: CT 1 1)
			)
			(1
				(mariLShutter cel: 2)
				(mariRShutter cel: 2)
				(global184 cel: 1)
				(= cycles 2)
			)
			(2
				(global184 setPri: 3)
				(mariLShutter cel: 3)
				(mariRShutter cel: 3)
				(= cycles 2)
			)
			(3
				(global184 cel: 2)
				(mariLShutter setCycle: End self)
				(mariRShutter setCycle: End)
			)
			(4
				(ClearFlag 145)
				(global184 stopUpd:)
				(mariLShutter stopUpd:)
				(mariRShutter stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance openShutters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 145)
				(global184
					setLoop: 0
					setCel: 255
					posn: 127 35
					setPri: 3
					setCycle: CT 2 -1 self
				)
				(mariLShutter setCel: 255 setCycle: CT 3 -1 self)
				(mariRShutter setCel: 255 setCycle: CT 3 -1 self)
			)
			(1
				(mariLShutter setCel: 2)
				(mariRShutter setCel: 2)
				(global184 cel: 1 setPri: 11)
				(= cycles 2)
			)
			(2
				(mariLShutter setCel: 1)
				(mariRShutter setCel: 1)
				(global184 cel: 0 setPri: 11)
				(= cycles 2)
			)
			(3
				(global184 setLoop: 1 setCel: 0 setPri: 10)
				(client setScript: 0)
			)
		)
	)
)

(instance callMari of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not local0)
					(gEgo illegalBits: 0 setMotion: MoveTo 130 155 self)
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo view: 68 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo view: 0 setLoop: -1 loop: 3 setCycle: Walk)
				(= seconds (Random 2 4))
			)
			(5
				(gEgo illegalBits: $8000)
				(HandsOn)
				(client setScript: 0)
				(cond
					((not (IsFlag 134))
						(Print 56 37) ; "No answer. Perhaps she is not home."
					)
					((or (IsFlag 137) (and (IsItemAt 11) (not (IsItemAt 13)))) ; mirror | golden_apple, veil
						(Print 56 38) ; "She does not answer."
					)
					(else
						(global184 setScript: openShutters)
					)
				)
			)
		)
	)
)

(instance thiefRobs of Script
	(properties)

	(method (init)
		(super init: &rest)
		(mariLShutter cel: 0)
		(mariRShutter cel: 0)
		(self setScript: (ScriptID 159)) ; bazaarMugging
	)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (== (self script:) 0) (== gCurRoomNum gNewRoomNum))
			(self changeState: 1)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(DisposeScript 159)
				(moRightRShutter init: stopUpd:)
				(moLeftRShutter init: stopUpd:)
				(moRightLShutter init: stopUpd:)
				(moLeftLShutter init: stopUpd:)
				((ScriptID 158) setLoop: 4 cel: 0 init:) ; mo
				(= seconds 10)
			)
			(2
				(ClearFlag 143)
				(client setScript: 0)
			)
		)
	)
)

