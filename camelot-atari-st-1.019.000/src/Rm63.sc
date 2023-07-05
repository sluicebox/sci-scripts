;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use Interface)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Rm63 0
)

(local
	local0
)

(procedure (localproc_0)
	(gTObj tWindow: fatimaWindow)
	(Talk &rest)
)

(instance fatimaWindow of SysWindow
	(properties
		color 15
		back 5
		title {Fatima}
		brTop 5
		brLeft 80
		brBottom 105
		brRight 200
	)
)

(instance fatimasDoor of Prop
	(properties
		y 124
		x 211
		view 163
		priority 7
		signal 16
	)
)

(instance leftBlock of Blk
	(properties
		left -5
		bottom 210
	)
)

(instance Rm63 of Rm
	(properties
		picture 63
	)

	(method (init)
		(super init:)
		(= global112 2)
		(self setRegions: 152) ; Bazaar
		(switch gPrevRoomNum
			(64
				(gEgo posn: 240 120 loop: 2 loop: 2)
			)
			(66
				(gEgo posn: (- 310 (gEgo x:)) 180 loop: 3)
			)
			(else
				(gEgo posn: 310 170 loop: 1)
			)
		)
		(gEgo observeBlocks: leftBlock)
		(fatimasDoor init: stopUpd:)
		(if (== gPrevRoomNum 64)
			(gEgo setScript: leaveFatimas)
		)
		(proc0_13 81)
		(gAddToPics doit:)
	)

	(method (notify)
		(return -1)
	)

	(method (doit)
		(super doit:)
		(cond
			(global80 0)
			((> (gEgo x:) 310)
				(gCurRoom newRoom: 62)
			)
			((> (gEgo y:) 180)
				(gCurRoom newRoom: 66)
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
					(== (event type:) evMOUSEBUTTON)
					(Said 'look,(are<where)>')
					(Said 'ask[/merlin]/*>')
				)
				(cond
					((Said 'look<up')
						(Print 63 0) ; "The building is but one floor with no other entrances."
					)
					(
						(or
							(Said 'look[<around][/!*][/!*]')
							(Said 'look/room,bazaar,street,jerusalem')
							(Said 'ask[/merlin]/room,bazaar,street,jerusalem')
							(Said '/room,house,street')
							(Said '//room,house,street')
						)
						(Print 63 1) ; "This house sits at the end of the street, abutting an ancient wall. There is but one door."
					)
					(
						(or
							(Said '/wall<ancient')
							(Said '//wall<ancient')
							(OnButton event 7 21 21 132)
						)
						(Print 63 2) ; "It is the remnant of some even older part of the city, as best I can tell."
					)
					(
						(or
							(Said '/window')
							(Said '//window')
							(OnButton event 33 16 65 53)
						)
						(Print 63 3) ; "It is of colored glass through which you can see nothing."
					)
					(
						(or
							(Said '/bush')
							(Said '//bush')
							(OnButton event 82 8 111 108)
							(OnButton event 20 75 174 109)
						)
						(Print 63 4) ; "They look like ordinary bushes of some Eastern variety."
					)
					((or (Said '/design') (Said '//design'))
						(Print 63 5) ; "Over the door are two symbols, a crescent moon and a star."
					)
					(
						(or
							(Said '/crescent,crescent,star')
							(Said '//crescent,crescent,star')
							(OnButton event 271 29 283 40)
							(OnButton event 199 31 211 40)
						)
						(Print 63 6) ; "The crescent and star are both symbols associated with the Goddess."
					)
					(
						(or
							(Said '/wall,brick')
							(Said '//wall,brick')
							(OnButton event 118 9 179 68)
						)
						(Print 63 7) ; "Bits of plaster have fallen away revealing bricks underneath, a common enough sight in Jerusalem."
					)
					(
						(or
							(Said '/tile')
							(Said '//tile')
							(OnButton event 180 13 191 110)
							(OnButton event 182 14 302 22)
							(OnButton event 292 13 302 111)
						)
						(Print 63 8) ; "The tiles are beautifully decorated, but of no consequence to you."
					)
					(
						(or
							(Said '/door')
							(Said '//door')
							(OnButton event 210 38 275 125)
						)
						(Print 63 9) ; "It is a heavy wooden door framed by beautifully glazed tiles."
					)
					((or (Said '/fatima') (Said '//fatima'))
						(Print 63 10) ; "She is nowhere in sight, if she is around here at all."
					)
				)
			)
			((Said 'talk/fatima')
				(Print 63 11) ; "I see no-one here with whom to speak."
			)
			((Said 'knock')
				(if (not local0)
					(gCurRoom setScript: knockOnDoor)
				else
					(Print 63 12) ; "It is already open."
				)
			)
			((Said 'fuck,fuck,shit')
				(Print 63 13) ; "Such poetic language will never get you through this door."
			)
			((Said 'open,unlock/door')
				(Print 63 14) ; "A powerful enchantment keeps this door shut. It will not open unless the owner is ready to open it."
			)
			((Said 'close/door')
				(Print 63 15) ; "Ahem...it IS closed."
			)
			((Said 'get/fatima')
				(Print 63 16) ; "First, you must confront her. Then we shall see what will be."
			)
			((Said 'annihilate/window')
				(Print 63 17) ; "You are alone in a hostile city. Do try to avoid rash and foolish actions."
			)
			((Said 'give,sell,bargain,buy/*')
				(Print 63 18) ; "There is no merchant here."
			)
			((Said 'climb/wall')
				(Print 63 19) ; "It is too high."
			)
			((not local0) 0)
			((Said 'talk/fatima')
				(localproc_0 63 20) ; "Enter. Then we shall speak."
			)
			((Said 'fuck,fuck,shit')
				(if (not global152)
					(localproc_0 63 21) ; "I will not tolerate such filth."
				else
					(localproc_0 63 22) ; "I warned you once. Now you will never step across my threshold."
				)
				(++ global152)
				(gCurRoom setScript: 0 setScript: closeDoor)
			)
			((Said 'call,yell')
				(localproc_0 63 23) ; "Enter, if you would speak with me."
			)
			((Said 'open/door')
				(Print 63 24) ; "What are you waiting for, Arthur? It is open."
			)
			((Said 'close,unlock/door')
				(Print 63 25) ; "There is no need. Fatima controls this door."
			)
			((or (Said 'ask[/fatima,woman]/*') (Said 'are<where/*'))
				(event claimed: 1)
				(localproc_0 63 20) ; "Enter. Then we shall speak."
			)
		)
	)
)

(instance leaveFatimas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fatimasDoor setCel: 255)
				(gEgo ignoreActors: setMotion: MoveTo 240 130 self)
			)
			(1
				(fatimasDoor cycleSpeed: 2 setCycle: Beg self)
				(gEgo setMotion: MoveTo 240 145)
			)
			(2
				(gEgo ignoreActors: 0)
				(fatimasDoor stopUpd:)
				(client setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance knockOnDoor of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((!= state 8) 0)
			((<= (gEgo y:) 126)
				(self changeState: 9)
			)
			((not (gEgo inRect: 180 100 320 160))
				(client setScript: 0 setScript: closeDoor)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND (proc0_20 83))
				(cond
					((gEgo inRect: 235 125 250 135)
						(self changeState: 2)
					)
					((gEgo inRect: 194 125 289 135)
						(= cycles 1)
					)
					(else
						(gEgo setMotion: MoveTo 241 136 self)
					)
				)
			)
			(1
				(gEgo setMotion: MoveTo 241 130 self)
			)
			(2
				(gEgo
					view: 62
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gSFX number: (proc0_20 83) loop: 1 play:)
				(gEgo loop: 0 setCel: 0 setCycle: End self)
			)
			(4
				(gSFX number: (proc0_20 83) loop: 1 play:)
				(gEgo setCel: 0 setCycle: End self)
			)
			(5
				(gEgo view: 0 cycleSpeed: 0 loop: 3 setCycle: Walk)
				(gSFX stop:)
				(cond
					((not (IsFlag 135))
						(Print 63 26) ; "There is no answer."
						(self changeState: 11)
					)
					((IsFlag 157)
						(Print 63 27) ; "Fatima has finished with you. She will not answer."
						(self changeState: 11)
					)
					((> global152 1)
						(Print 63 28) ; "You were warned. This door will never open for you again."
						(self changeState: 11)
					)
					(else
						(self changeState: 6)
					)
				)
			)
			(6
				(= local0 1)
				(fatimasDoor setCycle: End self)
			)
			(7
				(gTObj talkCue: self)
				(localproc_0 63 29) ; "Enter."
			)
			(8
				(HandsOn)
			)
			(9
				(HandsOff)
				(gEgo ignoreActors: setMotion: MoveTo 241 120 self)
			)
			(10
				(gRegMusic fade:)
				(gCurRoom newRoom: 64)
			)
			(11
				(gEgo view: 0 loop: 3 cycleSpeed: 0 setCycle: Walk)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fatimasDoor setCycle: Beg self)
			)
			(1
				(= local0 0)
				(if (gTObj tCount:)
					(gTObj endTalk:)
				)
				(fatimasDoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

