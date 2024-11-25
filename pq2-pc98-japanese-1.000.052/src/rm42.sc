;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use jet)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm42 0
)

(synonyms
	(masked japanesemask)
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
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
)

(procedure (localproc_0)
	((View new:)
		view: 84
		loop: 0
		cel: 3
		posn: 263 75
		ignoreActors:
		setPri: 1
		addToPic:
	)
	((View new:)
		view: 84
		loop: 1
		setCel: 255
		posn: 268 60
		ignoreActors:
		setPri: 2
		addToPic:
	)
	((= local9 (Prop new:))
		view: 82
		posn: 271 55
		loop: 8
		cel: 0
		setPri: 0
		ignoreActors:
		cycleSpeed: 2
		init:
		stopUpd:
	)
	((= local8 (Prop new:))
		view: 82
		posn: 51 191
		loop: 2
		cel: 0
		ignoreActors:
		setPri: 15
		init:
		stopUpd:
	)
	((= local7 (Prop new:))
		view: 82
		posn: 65 158
		loop: 5
		setCel: local6
		setPri: 10
		ignoreActors:
		init:
		stopUpd:
	)
	(if (== 0 (gEgo x:) (gEgo y:))
		(gEgo posn: 230 61)
	)
	(gEgo illegalBits: $8000 init:)
	(proc154_2)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(if (< (= temp0 (bombTimer seconds:)) 0)
		(= temp0 0)
	)
	(if (!= local11 temp0)
		(= local11 temp0)
		(= temp3 (mod temp0 10))
		(= temp2 (mod (/= temp0 10) 10))
		(if (not (= temp1 (mod (/= temp0 10) 10)))
			(= temp1 10)
			(if (not temp2)
				(= temp2 10)
			)
		)
		(local18 posn: 244 36 cel: temp1)
		(local19 posn: 254 36 cel: temp2)
		(local20 posn: 264 36 cel: temp3)
	)
)

(procedure (localproc_2)
	(Print &rest #at -1 110 #font gSmallFont)
)

(instance explosionSound of Sound
	(properties
		number 30
		priority 10
	)
)

(instance bombTimer of Timer
	(properties)
)

(instance Bathroom of Feature
	(properties)

	(method (handleEvent event)
		(cond
			((or (event claimed:) (!= (event type:) evSAID))
				(return)
			)
			((not local1)
				(if (Said '/bracket,basin,garbage,crapper,bathroom')
					(proc0_7) ; "You're not close enough."
				else
					(return)
				)
			)
			((Said '/garbage,can[<garbage]>')
				(cond
					((Said 'look')
						(if (not local0)
							(proc154_1 42 0)
						else
							(proc154_1 42 1)
						)
					)
					((Said 'frisk')
						(if (not local0)
							(proc154_1 42 2)
						else
							(proc154_1 42 1)
						)
					)
					((Said 'get')
						(proc154_1 42 3)
					)
					((Said 'read')
						(proc154_1 42 4)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'flush,use/crapper,bathroom')
				(proc154_1 42 5)
			)
			((Said 'bath/hand,japanesehand')
				(proc154_1 42 6)
			)
			((Said 'turn/faucet,water')
				(proc154_1 42 7)
			)
			((Said 'open/bracket,cover')
				(cond
					((not local1)
						(proc154_1 42 8)
					)
					((== (gCurRoom script:) TowelDispenser)
						(event claimed: 0)
					)
					(else
						(= local3 1)
						(gCurRoom setScript: TowelDispenser)
					)
				)
			)
			((Said 'open/door,japanesedoor')
				(Print 42 9) ; "Just walk to it and it will open automatically."
			)
			((Said '(look,frisk)>')
				(cond
					((Said '/wall')
						(proc154_1 42 10)
					)
					((Said '/japanesemiller')
						(if (not local0)
							(proc154_1 42 11)
						else
							(proc154_1 42 12)
						)
					)
					((Said '/basin')
						(if (not local0)
							(proc154_1 42 13)
							(proc154_1 42 14)
						else
							(proc154_1 42 1)
						)
					)
					((Said '/crapper,bathroom')
						(if (not local0)
							(proc154_1 42 15)
						else
							(proc154_1 42 1)
						)
					)
					((Said '/bracket[<towel]')
						(if (!= (gCurRoom script:) 0)
							(proc154_1 42 16)
						else
							(= local3 local21)
							(gCurRoom setScript: TowelDispenser)
						)
					)
					((Said '/pane')
						(proc154_1 42 17)
					)
					((Said '[<at,around][/!*,chamber,bathroom]')
						(proc154_1 42 18)
					)
				)
			)
		)
	)
)

(instance rm42 of Rm
	(properties
		picture 40
		style 0
	)

	(method (init)
		(Load rsVIEW 0)
		(Load rsVIEW 82)
		(Load rsVIEW 84)
		(Load rsPIC 300)
		(super init:)
		(self setLocales: 154)
		(self setFeatures: Bathroom)
		(= local6 3)
		(localproc_0)
		(= global202 0)
		(= global201 0)
		(= local23 1)
		(= local24 0)
		(= local25 0)
		(= local26 0)
		(= local27 0)
		(HandsOn)
		(bombTimer setReal: doBlowUp 120)
	)

	(method (dispose)
		(bombTimer dispose: delete:)
		(Bathroom dispose:)
		(egoSearch dispose:)
		(brDoor dispose:)
		(TowelDispenser dispose:)
		(super dispose:)
	)

	(method (doit)
		(if (not (self script:))
			(cond
				((and (& (gEgo onControl:) $2000) (not local1))
					(gCurRoom setScript: brDoor)
					(brDoor changeState: 10)
				)
				((and (& (gEgo onControl:) $0400) local1)
					(gCurRoom setScript: brDoor)
					(brDoor changeState: 1)
				)
				((and local0 (not local1))
					(gCurRoom newRoom: 43)
				)
			)
		)
		(if (& (gEgo onControl:) $4000)
			(if (not local5)
				(= local5 1)
				(Print 42 19) ; "It would not be a good idea to try to exit the plane at 25,000 feet."
			)
		else
			(= local5 0)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			((gEgo inRect: 255 50 300 75)
				(= local2 1)
			)
			((& (gEgo onControl:) $1800)
				(= local2 2)
			)
			((and (>= (gEgo y:) 57) (<= (gEgo y:) 143))
				(= local2 3)
			)
			(else
				(= local2 0)
			)
		)
		(cond
			(
				(or
					(Said '/*<(hijacker,man)<unmasked')
					(Said '//(hijacker,man)<unmasked')
					(Said '/<unmasked')
				)
				(if (!= local2 1)
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(= local4 2)
				(event claimed: 0)
			)
			(
				(or
					(Said '/*<(hijacker,man)<masked')
					(Said '//(hijacker,man)<masked')
					(Said '/<masked')
				)
				(if (!= local2 1)
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(= local4 1)
				(event claimed: 0)
			)
			((Said '/body,hijacker')
				(if (and (!= local2 1) (!= local2 2))
					(proc0_7) ; "You're not close enough."
					(return)
				)
				(event claimed: 0)
			)
		)
		(cond
			((Said 'sat[/*]')
				(if (not local0)
					(proc154_1 42 20)
				else
					(proc154_1 42 5)
				)
			)
			((Said '/9mm>')
				(cond
					((!= local2 1)
						(event claimed: 1)
						(proc0_7) ; "You're not close enough."
					)
					((Said 'get')
						(proc154_1 42 21)
					)
					((Said 'look')
						(proc154_1 42 22)
					)
				)
			)
			((Said '/(bench,baggage)')
				(if (== local2 3)
					(proc154_1 42 23)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((Said '/compartment,bin,cabinet')
				(if (== local2 3)
					(proc154_1 42 24)
				else
					(proc0_7) ; "You're not close enough."
				)
			)
			((and (== local2 3) (Said '/passenger,man,woman>'))
				(cond
					((Said 'look')
						(proc154_1 42 25)
					)
					((Said 'talk')
						(switch (Random 0 2)
							(0
								(proc154_1 42 26)
							)
							(1
								(proc154_1 42 27)
							)
							(else
								(proc154_1 42 28)
							)
						)
					)
					(else
						(event claimed: 1)
						(proc154_1 42 29)
					)
				)
			)
			((Said '/passenger')
				(proc0_7) ; "You're not close enough."
			)
			((or (Said 'look/(hijacker,body,man)') (Said 'frisk/cloth'))
				(cond
					((and (!= local2 2) (!= local2 1))
						(proc0_7) ; "You're not close enough."
					)
					((== local4 2)
						(proc154_1 42 30)
					)
					(else
						(proc154_1 42 31)
					)
				)
			)
			((Said 'open/door,japanesedoor')
				(cond
					((& (gEgo onControl:) $4000)
						(proc154_1 42 19)
					)
					((or (== local2 2) (== local2 1))
						(proc154_1 42 32)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'check/(hijacker,body,man)')
				(if (!= local2 1)
					(proc0_7) ; "You're not close enough."
				else
					(proc154_1 42 33)
				)
			)
			((Said 'frisk[<around][/!*,area]')
				(proc154_1 42 34)
			)
			((Said '(frisk,look)>')
				(cond
					(
						(or
							(Said '/unmasked')
							(Said '/(body,hijacker,man)<unmasked')
						)
						(= local4 2)
						(proc154_1 42 35)
					)
					((or (Said '/masked') (Said '/(body,hijacker,man)<masked'))
						(= local4 1)
						(proc154_1 42 36)
					)
					((Said '/(man,body,hijacker)')
						(proc154_1 42 37)
					)
					((Said '/pocket,coat')
						(cond
							((!= local2 1)
								(proc0_7) ; "You're not close enough."
							)
							((== local4 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 38)
							)
							((gEgo has: 9) ; wire_clippers
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 39)
							)
							(else
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 40)
								(gEgo get: 9) ; wire_clippers
								(SetScore 3)
							)
						)
					)
					((Said '/shirt')
						(if (!= local2 1)
							(proc0_7) ; "You're not close enough."
						else
							(proc0_19 gEgo egoSearch)
							(if (== local4 1)
								(Print 42 41) ; "Looking through the shirt of the masked hijacker you find nothing."
							else
								(Print 42 42) ; "Looking through the shirt of the unmasked hijacker you find nothing."
							)
						)
					)
					((Said '/jeans')
						(cond
							((!= local2 1)
								(proc0_7) ; "You're not close enough."
							)
							((== local4 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 43)
								(proc154_1 42 44)
								(proc154_1 42 45)
							)
							(else
								(proc0_19 gEgo egoSearch)
								(Print 42 46) ; "Looking through the pants of the masked hijacker you find nothing."
							)
						)
					)
					((Said '/turban')
						(cond
							((!= local2 1)
								(proc0_7) ; "You're not close enough."
							)
							((gEgo has: 33) ; bomb_instructions
								(= local4 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 47)
							)
							(else
								(= local4 2)
								(proc0_19 gEgo egoSearch)
								(proc154_1 42 48)
								(gEgo get: 33) ; bomb_instructions
								(SetScore 3)
							)
						)
					)
					((Said '/mask,masked')
						(if (!= local2 1)
							(proc0_7) ; "You're not close enough."
						else
							(= local4 1)
							(proc154_1 42 49)
						)
					)
					((Said '/bomb')
						(proc154_1 42 50)
					)
				)
			)
			((Said '/unmasked')
				(if (= local2 1)
					(= local4 2)
					(proc154_1 42 51)
				else
					(Print 42 52) ; "What?"
				)
			)
			((Said '/masked')
				(if (= local2 1)
					(= local4 1)
					(proc154_1 42 53)
				else
					(Print 42 52) ; "What?"
				)
			)
		)
	)
)

(instance egoSearch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((and (== local4 2) (< (gEgo x:) 276))
						(gEgo illegalBits: 0 setMotion: MoveTo 276 61 self)
					)
					((and (== local4 1) (> (gEgo x:) 282))
						(gEgo illegalBits: 0 setMotion: MoveTo 282 65 self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo
					view: 84
					setCel: 0
					cycleSpeed: 4
					setCycle: CT 7 1 self
					setLoop:
						(cond
							((== local4 2) 6)
							((>= (gEgo y:) 59) 7)
							((<= (gEgo x:) 270) 6)
							(else 5)
						)
				)
			)
			(2
				(gEgo setCel: 4 setCycle: CT 7 1 self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo
					view: 0
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 0
					illegalBits: $8000
				)
				(client setScript: 0)
			)
		)
	)
)

(instance brDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(gEgo setMotion: 0)
				(local7 setCycle: End self)
			)
			(2
				(gEgo setPri: -1 setMotion: MoveTo 69 155 self)
			)
			(3
				(local7 stopUpd:)
				(local8 posn: 51 191)
				(RedrawCast)
				(local8 stopUpd:)
				(gEgo setMotion: MoveTo 82 155 self)
			)
			(4
				(HandsOn)
				(gEgo loop: 0 setMotion: 0)
				(= local1 0)
				(gCurRoom setScript: 0)
			)
			(10
				(HandsOff)
				(local8 posn: 100 1000)
				(local7 startUpd:)
				(gEgo
					ignoreActors:
					posn: 69 155
					illegalBits: 0
					setMotion: MoveTo 55 162 self
				)
			)
			(11
				(local7 setCycle: Beg self)
			)
			(12
				(HandsOn)
				(local7 stopUpd:)
				(gEgo setPri: 13 ignoreActors: 0 illegalBits: $8000)
				(= local1 1)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance TowelDispenser of Script
	(properties)

	(method (doit)
		(if (== local10 1)
			(= local10 0)
			(HandsOff)
			(gContinuousMusic stop:)
			(gCurRoom setScript: doBoomScript)
		)
		(if (== local23 6)
			(localproc_2 42 54) ; "The timer stops. The bomb is disarmed!"
			(bombTimer seconds: -1)
			(gContinuousMusic stop:)
			(local18 posn: 244 36 cel: 10)
			(local19 posn: 254 36 cel: 10)
			(local20 posn: 264 36 cel: 10)
			(= local23 7)
			(= local0 1)
		)
		(if (and local21 (>= (bombTimer seconds:) 0))
			(localproc_1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(gCurRoom picture: 24)
				(gCurRoom drawPic: (gCurRoom picture:) style: 6)
				(HandsOff)
				(User canInput: 1)
				((= local13 (Prop new:))
					view: 250
					loop: 3
					cel: local24
					posn: 128 91
					setPri: 4
					init:
				)
				((= local14 (Prop new:))
					view: 250
					loop: 4
					cel: local25
					posn: 120 96
					setPri: 4
					init:
				)
				((= local15 (Prop new:))
					view: 250
					loop: 5
					cel: local26
					posn: 119 92
					setPri: 4
					init:
				)
				((= local16 (Prop new:))
					view: 250
					loop: 6
					cel: local27
					posn: 120 88
					setPri: 4
					init:
				)
				((= local22 (View new:))
					view: 250
					loop: 2
					cel: 0
					posn: 166 97
					setPri: 2
					init:
					stopUpd:
				)
				((= local12 (Prop new:))
					view: 250
					loop: 0
					cel: 0
					posn: 154 103
					setPri: 15
					init:
					stopUpd:
				)
				((= local18 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local19 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local20 (Prop new:))
					view: 250
					loop: 8
					cel: 0
					posn: 240 1000
					setPri: 15
					init:
				)
				((= local17 (View new:))
					view: 250
					loop: 7
					cel: 0
					posn: 235 1000
					setPri: 15
					init:
				)
				(if local3
					(self cue:)
				)
			)
			(1
				(local12 loop: 1 posn: 155 103)
				(local17 posn: 235 40)
				(localproc_1)
				(SetScore 2 99)
				(= local21 1)
			)
			(10
				(local12 setLoop: 0 posn: 154 103)
				(= seconds 2)
			)
			(11
				(= local21 0)
				(gCast eachElementDo: #dispose eachElementDo: #delete)
				(= local6 0)
				(localproc_0)
				(gCurRoom picture: 40)
				(gCurRoom drawPic: (gCurRoom picture:) style: 0)
				(proc154_2)
				(local8 posn: 50 1000)
				(gEgo posn: 46 165)
				(local7 stopUpd:)
				(local9 stopUpd:)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said '(get,move,japaneseopen)/bomb')
						(cond
							((not local21)
								(proc0_10) ; "You can't do that now."
							)
							((> local23 5)
								(localproc_2 42 55) ; "You don't need the disarmed bomb."
							)
							(else
								(localproc_2 42 56) ; "Ok."
								(localproc_2 42 57) ; "As you take the bomb..."
								(= local10 1)
							)
						)
					)
					((Said 'disarm')
						(cond
							((not local21)
								(proc0_10) ; "You can't do that now."
							)
							((> local23 5)
								(localproc_2 42 58) ; "The bomb is already disarmed."
							)
							(else
								(localproc_2 42 59) ; "How do you propose to do that?"
							)
						)
					)
					((Said 'look>')
						(cond
							((Said '/cable')
								(if (not local21)
									(proc0_10) ; "You can't do that now."
								else
									(localproc_2 42 60) ; "There is a blue, white, yellow, and purple wire attached to the bomb."
								)
							)
							((Said '/cable>')
								(cond
									((not local21)
										(proc0_10) ; "You can't do that now."
									)
									((Said '/!*')
										(localproc_2 42 61) ; "There are four wires: a blue, white, yellow, and purple one."
									)
									((Said '/blue,(cable<blue)')
										(if (== local24 1)
											(localproc_2 42 62) ; "The blue wire is cut."
										else
											(localproc_2 42 63) ; "The blue wire is connected."
										)
									)
									(
										(Said
											'/japanesecastle,(cable<japanesecastle)'
										)
										(if (== local25 1)
											(localproc_2 42 64) ; "The white wire is cut."
										else
											(localproc_2 42 65) ; "The white wire is connected."
										)
									)
									((Said '/yellow,(cable<yellow)')
										(if (== local26 1)
											(localproc_2 42 66) ; "The yellow wire is cut."
										else
											(localproc_2 42 67) ; "The yellow wire is connected."
										)
									)
									((Said '/purple,(cable<purple)')
										(if (== local27 1)
											(localproc_2 42 68) ; "The purple wire is cut."
										else
											(localproc_2 42 69) ; "The purple wire is connected."
										)
									)
									(else
										(localproc_2 42 70) ; "Please specify either the blue, white, yellow, or purple wire."
									)
								)
							)
							((Said '/timer,(device[<timing])')
								(cond
									((not local21)
										(localproc_2 42 71) ; "You don't see a timing device here."
									)
									((> local23 5)
										(localproc_2 42 72) ; "The device is off."
									)
									(else
										(localproc_2 42 73) ; "The timing device quickly ticks down."
									)
								)
							)
							((Said '/bomb')
								(if local21
									(localproc_2 42 74) ; "The bomb has four wires and a timing device."
								else
									(localproc_2 42 75) ; "You don't see a bomb?"
								)
							)
							((Said '/bracket')
								(if local21
									(localproc_2 42 76) ; "In the towel dispenser is a bomb!"
								else
									(localproc_2 42 77) ; "You look at the paper towel dispenser, but you see nothing out of the ordinary."
								)
							)
							((Said '/dynamite')
								(localproc_2 42 78) ; "It looks like it could easily blow up this plane!"
							)
							((Said '[<at,around][/(!*,chamber,bathroom)]')
								(self changeState: 10)
							)
						)
					)
					(
						(or
							(Said 'exit,exit,japaneseclimbdown')
							(Said 'look/chamber')
						)
						(self changeState: 10)
					)
					((Said 'open[/bracket,cover]')
						(if (not local21)
							(self changeState: 1)
						else
							(localproc_2 42 79) ; "It's already open."
						)
					)
					((Said 'close[/bracket,cover]')
						(if local21
							(= local21 0)
							(self changeState: 10)
						else
							(localproc_2 42 80) ; "It is not yet open."
						)
					)
					((or (Said 'get/towel') (Said 'use/bracket'))
						(localproc_2 42 81) ; "The towels seem to be stuck."
					)
					((Said 'pull,bite/cable,cable')
						(localproc_2 42 82) ; "That would not be a good idea."
					)
					((Said '(cut,wear,clip,disconnect,wear)/>')
						(cond
							((not (gEgo has: 9)) ; wire_clippers
								(localproc_2 42 83) ; "You'll need something to cut the wires apart."
								(event claimed: 1)
							)
							((> local23 5)
								(localproc_2 42 84) ; "Leave the bomb alone...it is disarmed."
								(event claimed: 1)
							)
							((not local21)
								(localproc_2 42 85) ; "You can't do that now."
								(event claimed: 1)
							)
							((Said '/blue,(cable<blue)')
								(if (== local24 1)
									(localproc_2 42 86) ; "It already is."
								else
									(localproc_2 42 87) ; "Snip."
									(local13 cel: 1)
									(= local24 1)
									(switch local23
										(2
											(SetScore 3)
											(if (== local27 1)
												(++ local23)
											)
										)
										(else
											(= local10 1)
										)
									)
								)
							)
							((Said '/japanesecastle,(cable<japanesecastle)')
								(if (== local25 1)
									(localproc_2 42 86) ; "It already is."
								else
									(localproc_2 42 87) ; "Snip."
									(local14 cel: 1)
									(= local25 1)
									(if (!= local23 4)
										(= local10 1)
									else
										(++ local23)
										(SetScore 3)
									)
								)
							)
							((Said '/yellow,(cable<yellow)')
								(if (== local26 1)
									(localproc_2 42 86) ; "It already is."
								else
									(localproc_2 42 87) ; "Snip."
									(local15 cel: 1)
									(= local26 1)
									(switch local23
										(1
											(++ local23)
											(SetScore 3)
										)
										(5
											(++ local23)
											(SetScore 3)
										)
										(else
											(= local10 1)
										)
									)
								)
							)
							((Said '/purple,(cable<purple)')
								(if (== local27 1)
									(localproc_2 42 86) ; "It already is."
								else
									(localproc_2 42 87) ; "Snip."
									(local16 cel: 1)
									(= local27 1)
									(if (!= local23 2)
										(= local10 1)
									else
										(SetScore 3)
										(if (== local24 1)
											(++ local23)
										)
									)
								)
							)
							(else
								(event claimed: 1)
								(localproc_2 42 70) ; "Please specify either the blue, white, yellow, or purple wire."
							)
						)
					)
					((Said 'attach,(drop,japaneseput<together)/>')
						(cond
							((not local21)
								(event claimed: 1)
								(Print 42 85) ; "You can't do that now."
							)
							((> local23 5)
								(localproc_2 42 84) ; "Leave the bomb alone...it is disarmed."
								(event claimed: 1)
							)
							((Said '/blue,(cable<blue)')
								(if (== local24 0)
									(localproc_2 42 88) ; "It is already connected."
								else
									(localproc_2 42 89) ; "You put the blue wire together."
									(local13 cel: 0)
									(= local10 1)
								)
							)
							((Said '/japanesecastle,(cable<japanesecastle)')
								(if (== local25 0)
									(localproc_2 42 88) ; "It is already connected."
								else
									(localproc_2 42 90) ; "You put the white wire together."
									(local14 cel: 0)
									(= local10 1)
								)
							)
							((Said '/yellow,(cable<yellow)')
								(if (== local26 0)
									(localproc_2 42 88) ; "It is already connected."
								else
									(localproc_2 42 91) ; "You put the yellow wire together."
									(local15 cel: 0)
									(if (!= local23 3)
										(= local10 1)
									else
										(= local26 0)
										(++ local23)
										(SetScore 3)
									)
								)
							)
							((Said '/purple,(cable<purple)')
								(if (== local27 0)
									(localproc_2 42 88) ; "It is already connected."
								else
									(localproc_2 42 92) ; "You put the purple wire together."
									(local16 cel: 0)
									(= local10 1)
								)
							)
							(else
								(event claimed: 1)
								(localproc_2 42 70) ; "Please specify either the blue, white, yellow, or purple wire."
							)
						)
					)
				)
			)
		)
	)
)

(instance doBoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(explosionSound
					priority: (if (== (DoSound sndCHECK_DRIVER) 6) 1 else 10)
					play:
				)
				(SetMenu 513 112 0)
				(gCurRoom drawPic: 300 style: 7)
				(gCast eachElementDo: #hide)
				(RedrawCast)
				(ShakeScreen 10)
				(= seconds 3)
			)
			(1
				(EgoDead
					{You and 49 other people are now dead...because YOU screwed up!}
				)
			)
		)
	)
)

(instance doBlowUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom newRoom: 44)
			)
		)
	)
)

