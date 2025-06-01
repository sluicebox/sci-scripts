;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use jet)
(use Interface)
(use Chase)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm40 0
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
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(repeat
		(breakif (!= (= temp0 (Random param1 param2)) local10))
	)
	(= local10 temp0)
	(return temp0)
)

(instance planeRumble of Sound
	(properties
		number 46
		loop 2
	)
)

(instance guard of Act
	(properties
		y 1063
		x 300
		view 31
		loop 1
		signal 16384
		illegalBits 0
	)
)

(instance pilotDoor of Prop
	(properties
		y 55
		x 271
		view 82
		loop 8
		signal 16400
		cycleSpeed 1
	)
)

(instance BlackWall of PV
	(properties
		y 191
		x 51
		view 82
		loop 2
		priority 15
		signal 16
	)
)

(instance rm40 of Rm
	(properties
		picture 40
		style 0
	)

	(method (dispose)
		(stage2Timer dispose: delete:)
		(super dispose:)
	)

	(method (init)
		(= gPerspective 70)
		(Load rsVIEW 0)
		(Load rsVIEW 82)
		(Load rsVIEW 26)
		(Load rsVIEW 31)
		(Load rsVIEW 20)
		(Load rsSOUND 46)
		(self setLocales: 154)
		(super init:)
		(gEgo view: 0 setStep: 3 2 posn: 336 82 loop: 1 illegalBits: 0 init:)
		((= global112 (Act new:))
			view: 20
			posn: 324 72
			ignoreActors:
			illegalBits: 0
			setCycle: Walk
			init:
		)
		((= global198 (Act new:))
			view: 26
			posn: 255 73
			loop: 1
			cel: 0
			setCycle: Walk
			illegalBits: 0
			init:
		)
		(guard setCycle: Walk init:)
		(pilotDoor init: stopUpd:)
		(gAddToPics add: BlackWall)
		(proc154_2)
		(= global201 0)
		(= global202 0)
		(= local6 0)
		(self setScript: initScript)
	)

	(method (doit)
		(if (and (& (gEgo onControl:) $4000) (not global106))
			(if (not local3)
				(= local3 1)
				(Print 40 0) ; "You can't turn back now."
			)
		else
			(= local3 0)
		)
		(cond
			((not (gEgo inRect: 50 156 92 162))
				(= local4 0)
			)
			((not local4)
				(Print 40 1) ; "The bathroom is occupied now."
				(= local4 1)
			)
		)
		(super doit:)
	)
)

(instance initScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 285 70 self)
				(global112 setMotion: MoveTo 280 62)
				(global198 loop: 0)
			)
			(1
				(proc154_1 40 2)
				(= seconds 2)
			)
			(2
				(global198 loop: 2)
				(HandsOn)
				(gEgo illegalBits: $8000)
				(global112 setMotion: MoveTo 233 60 self)
			)
			(3
				(global112 setMotion: MoveTo 224 57 self)
			)
			(4
				(global112
					view: 82
					setLoop: 4
					setCel: 0
					illegalBits: 0
					ignoreActors:
					setPri: 0
					posn: 200 68
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(5
				(gCurRoom setScript: StageOne)
			)
		)
	)
)

(instance StageOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 40)
			)
			(1
				(= seconds 5)
			)
			(2
				(proc154_1 40 3)
				(proc154_1 40 4)
				(if (not global202)
					(= seconds 20)
				else
					(self changeState: 20)
				)
			)
			(3
				(HandsOff)
				(if (& (gEgo onControl:) $1800)
					(self cue:)
				else
					(global198 setMotion: MoveTo 232 72 self)
				)
			)
			(4
				(global198 setMotion: Chase gEgo 20 self)
			)
			(5
				(= local2 1)
				(if global201
					(proc154_1 40 5 67 10 15 33 gSmallFont)
				else
					(proc154_1 40 6 67 10 15 33 gSmallFont)
				)
				(HandsOn)
				(if global201
					(User canControl: 0)
				)
				(global198 setMotion: MoveTo 232 72 self)
			)
			(6
				(global198 setMotion: MoveTo 270 70 self)
			)
			(7
				(global198 loop: 2 cel: 4)
				(= seconds 30)
			)
			(8
				(guard setScript: guardAction)
			)
			(20
				(= seconds 5)
			)
			(21
				(self changeState: 25)
			)
			(25
				(global198 setScript: stewardessActions)
				(stewardessActions changeState: 1)
				(= cycles 25)
			)
			(26
				(proc154_1 40 7)
				(if (>= global100 13)
					(= seconds 10)
				else
					(gCurRoom setScript: WildGooseChase)
				)
			)
			(27
				(proc154_1 40 8)
				(= seconds 10)
				(planeRumble play:)
			)
			(28
				(global198 setScript: stewardessActions)
				(stewardessActions changeState: 6)
				(= cycles 20)
			)
			(29
				(gCurRoom setScript: StageTwo)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look/pane')
						(proc154_1 40 9)
					)
					((Said 'sat')
						(cond
							(global201
								(event claimed: 0)
							)
							((not (gEgo inRect: 210 56 239 64))
								(proc154_1 40 10)
							)
							(else
								(if (and (== state 0) (> seconds 2))
									(= seconds 2)
								)
								(gEgo setScript: egoSit)
							)
						)
					)
					((Said 'talk/friend')
						(if global201
							(proc154_1 40 11)
						else
							(proc154_1 40 12)
						)
					)
					((Said 'open/door,japanesedoor')
						(if (& (gEgo onControl:) $2000)
							(Print 40 13) ; "The rest room is occupied."
						else
							(event claimed: 0)
						)
					)
					((Said 'knock,hit/door,japanesedoor')
						(if (& (gEgo onControl:) $2000)
							(proc154_1 40 14)
						else
							(proc0_7) ; "You're not close enough."
						)
					)
					((Said 'talk/attendant')
						(cond
							((> (gEgo distanceTo: global198) 25)
								(proc0_7) ; "You're not close enough."
							)
							(local1
								(proc154_1 40 15)
							)
							(global201
								(proc154_1 40 16)
							)
							(else
								(proc154_1 40 17)
							)
						)
					)
					(
						(Said
							'japaneseopen,unbuckle,japaneseopen,(get<off)/belt,belt'
						)
						(if global202
							(Print 40 18) ; "Wait until the plane has reached cruising altitude."
						else
							(event claimed: 0)
						)
					)
					((Said 'close,drop,japaneseput,wear,buckle/belt,belt')
						(if (and global201 (not global202))
							(= global202 1)
							(SetScore 1 163)
							(Print 40 19) ; "Ok."
							(if (< state 2)
								(self changeState: 1)
							else
								(self changeState: 20)
							)
						else
							(event claimed: 0)
						)
					)
					((Said 'meditate,nap')
						(if global201
							(Print 40 20) ; "Wait until the plane has taken off."
						else
							(Print 40 21) ; "It would be a good idea to sit down first."
						)
					)
				)
			)
		)
	)
)

(instance stewardessActions of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(global198 setMotion: MoveTo 268 60 self)
			)
			(2
				(pilotDoor startUpd: setCycle: End self)
			)
			(3
				(pilotDoor stopUpd:)
				(global198 setPri: 0 setMotion: MoveTo 280 50 self)
			)
			(4
				(pilotDoor startUpd: setCycle: Beg self)
				(global198 hide:)
			)
			(5
				(pilotDoor stopUpd:)
				(client setScript: 0)
			)
			(6
				(pilotDoor setCycle: End self)
			)
			(7
				(pilotDoor stopUpd:)
				(global198
					show:
					startUpd:
					setPri: 0
					setMotion: MoveTo 268 55 self
				)
			)
			(8
				(global198 setPri: -1)
				(pilotDoor setCycle: Beg self)
			)
			(9
				(pilotDoor stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance egoSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global201 1)
				(gEgo
					view: 82
					setLoop: 3
					setCel: 0
					ignoreActors:
					illegalBits: 0
					posn: 212 72
					cycleSpeed: 1
					setMotion: 0
					setPri: 3
					setCycle: End self
				)
			)
			(1
				(User canInput: 1)
				(gEgo setScript: 0)
			)
		)
	)
)

(instance guardAction of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local2 0)
				(guard posn: 300 75)
				(if (& (gEgo onControl:) $1800)
					(guard setMotion: MoveTo 290 75 self)
				else
					(guard setMotion: MoveTo 259 75 self)
				)
			)
			(1
				(if (& (gEgo onControl:) $1800)
					(self cue:)
				else
					(guard setMotion: MoveTo 232 72 self)
				)
			)
			(2
				(guard setMotion: Chase gEgo 20 self)
			)
			(3
				(Print 40 22) ; "Because you are not complying with the regulations, therefore causing the flight to be delayed, you are being removed from the plane."
				(gEgo illegalBits: 0 ignoreActors: 1)
				(cond
					(global201
						(gEgo setCycle: Beg self)
					)
					((& (gEgo onControl:) $1800)
						(self changeState: 6)
					)
					(else
						(self cue:)
					)
				)
			)
			(4
				(if global201
					(gEgo
						view: 0
						posn: 229 59
						loop: 0
						cel: 0
						cycleSpeed: 0
						setPri: -1
					)
				)
				(gEgo setCycle: Walk setMotion: MoveTo 247 63 self)
				(guard setMotion: Follow gEgo 10)
			)
			(5
				(gEgo setMotion: MoveTo 259 53 self)
				(guard setMotion: Follow gEgo 10)
			)
			(6
				(gEgo setMotion: MoveTo 320 82 self)
				(guard setMotion: Follow gEgo 10)
			)
			(7
				(gEgo dispose:)
				(guard dispose:)
				(EgoDead 40 23) ; "Sonny, you really must learn not to be such a nuisance. It's not that hard to find your seat and fasten your seatbelt!"
			)
		)
	)
)

(instance WildGooseChase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(global198 setScript: stewardessActions)
				(stewardessActions changeState: 6)
				(= cycles 20)
			)
			(2
				(global198 setMotion: MoveTo 232 72 self)
			)
			(3
				(global198 loop: 1 cel: 0)
				(RedrawCast)
				(proc154_1 40 24)
				(= local0 1)
				(= seconds 8)
			)
			(4
				(= state 2)
				(self cue:)
			)
			(10
				(HandsOff)
				(= local0 0)
				(proc154_1 40 25)
				(= seconds 2)
			)
			(11
				(HandsOff)
				(proc154_1 40 26)
				(= seconds 2)
			)
			(12
				(proc154_1 40 27)
				(= seconds 2)
			)
			(13
				(self changeState: 19)
			)
			(18
				(HandsOff)
				(proc154_1 40 28)
				(= seconds 2)
			)
			(19
				(= local0 0)
				(= local1 1)
				(proc154_1 40 29)
				(= seconds 2)
			)
			(20
				(HandsOff)
				(proc154_1 40 30)
				(global198 setLoop: 3)
				(gEgo setCycle: Beg self)
				(global112 setCycle: Beg)
			)
			(21
				(gEgo
					view: 0
					setLoop: -1
					loop: 0
					posn: 229 59
					illegalBits: 0
					cycleSpeed: 0
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 259 59 self
				)
				(global112
					view: 20
					loop: 0
					cycleSpeed: 0
					posn: 223 57
					illegalBits: 0
					ignoreActors:
					setPri: -1
					setCycle: Walk
				)
				(= global201 0)
				(= global202 0)
			)
			(22
				(gEgo setMotion: MoveTo 289 65 self)
				(global112 setMotion: MoveTo 260 62)
			)
			(23
				(gEgo setMotion: MoveTo 330 82)
				(global112 setMotion: MoveTo 330 80 self)
			)
			(24
				(HandsOn)
				(= global168 1)
				(gCurRoom newRoom: 20)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'yes,ash')
						(if local0
							(WildGooseChase changeState: 18)
						else
							(event claimed: 0)
						)
					)
					((Said 'no')
						(if local0
							(WildGooseChase changeState: 10)
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

(instance stage2Timer of Timer
	(properties)
)

(instance StageTwo of Script
	(properties)

	(method (init)
		(proc154_1 40 31)
		(proc154_1 40 32)
		(proc154_1 40 33)
		(stage2Timer setCycle: endStageTwo 700)
		(= local8 5)
		(self changeState: 1)
	)

	(method (doit)
		(if (and local7 (< state 4))
			(= local7 0)
			(= cycles (= seconds 0))
			(= local8 5)
			(self changeState: 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local8 (localproc_0 0 4))
				(self cue:)
			)
			(1
				(switch local8
					(0
						(global198 setMotion: MoveTo 180 98 self)
					)
					(1
						(global198 setMotion: MoveTo 150 113 self)
					)
					(2
						(global198 setMotion: MoveTo 129 123 self)
					)
					(3
						(global198 setMotion: MoveTo 90 142 self)
					)
					(else
						(global198 setMotion: MoveTo 232 72 self)
					)
				)
			)
			(2
				(switch local8
					(4
						(global198 loop: 0)
					)
					(5
						(global198 loop: 1)
						(RedrawCast)
						(self changeState: 4)
					)
					(else
						(global198 loop: (Random 0 1))
					)
				)
				(= cycles 80)
			)
			(3
				(self changeState: 0)
			)
			(4
				(proc154_1 40 34)
				(= local9 0)
				(= cycles 120)
			)
			(5
				(proc154_1 40 35 67 40 40)
				(self changeState: 0)
			)
			(6
				(proc154_1 40 36)
				(self changeState: 0)
			)
			(7
				(= seconds 0)
				(= cycles 20)
			)
			(8
				(global198 setMotion: MoveTo 232 72 self)
			)
			(9
				(global198 setMotion: MoveTo 255 77 self)
			)
			(10
				(global198 loop: 2)
				(RedrawCast)
				(if (> local6 2)
					(= global197 1)
				else
					(= global197 0)
				)
				(gCurRoom newRoom: 41)
			)
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'yes,ash')
						(if (and (== state 4) (not local9))
							(proc154_1 40 34)
							(= local9 1)
						else
							(event claimed: 0)
						)
					)
					((Said 'no')
						(if (and (== state 4) (not local9))
							(proc154_1 40 37 67 30 30 33 gSmallFont)
							(= local9 1)
							(self changeState: 5)
						else
							(event claimed: 0)
						)
					)
					((Said 'stand,(get<up)')
						(if (!= state 4)
							(proc154_1 40 38)
						else
							(event claimed: 0)
						)
					)
					((Said 'call/attendant')
						(if (== state 4)
							(Print 40 39) ; "She's right here!"
						else
							(Print 40 19 #at 40 30 #font gSmallFont) ; "Ok."
							(= local7 1)
						)
					)
					((Said 'drink')
						(Print 40 40) ; "You don't have anything to drink."
					)
					((Said 'talk/attendant')
						(if (== state 4)
							(proc154_1 40 41)
						else
							(Print 40 42) ; "Call the stewardess if you would like to talk to her."
						)
					)
					((Said 'ask/number<phone')
						(if (!= state 4)
							(Print 40 43) ; "The stewardess is not close enough."
						else
							(proc154_1 40 44)
						)
					)
					((Said '/none')
						(if (== state 4)
							(proc154_1 40 45)
							(self changeState: 5)
						else
							(event claimed: 0)
						)
					)
					(
						(or
							(Said 'buy,ask,order,(get<!*)')
							(Said '/drink,chow,coffee,water,coca,beer,booze')
							(Said '//drink,chow,coffee,water,coca,beer,booze')
						)
						(event claimed: 0)
						(cond
							((!= state 4)
								(Print 40 46) ; "The stewardess is not taking your order."
								(event claimed: 1)
							)
							(
								(or
									(Said '/coca,(drink<soft)')
									(Said '//coca,(drink<soft)')
								)
								(if (>= global107 2)
									(-= global107 2)
									(proc154_1 40 47)
									(proc154_1 40 48)
									(self changeState: 6)
								else
									(Print 40 49) ; "You do not have enough money."
								)
							)
							((or (Said '/drink') (Said '//drink'))
								(proc154_1 40 34)
							)
							((or (Said '/chow') (Said '//chow'))
								(proc154_1 40 50)
							)
							((or (Said '/coffee') (Said '//coffee'))
								(proc154_1 40 51)
								(proc154_1 40 52)
								(self changeState: 6)
							)
							((or (Said '/water') (Said '//water'))
								(proc154_1 40 53)
								(proc154_1 40 54)
								(self changeState: 6)
							)
							((or (Said '/beer,booze') (Said '//beer,booze'))
								(if (>= global107 3)
									(++ local6)
									(-= global107 3)
									(proc154_1 40 55)
									(proc154_1 40 56)
									(proc154_1 40 57)
									(cond
										((== local6 3)
											(Print 40 58) ; "You are now under the influence of alcohol."
										)
										((== local6 2)
											(Print 40 59) ; "You begin to feel the effects of the drinks."
										)
									)
									(self changeState: 6)
								else
									(Print 40 49) ; "You do not have enough money."
								)
							)
							(else
								(Print 40 60) ; "That is not available on this flight."
								(event claimed: 1)
							)
						)
					)
					((Said 'use,go/bathroom,bathroom,(chamber<(bath,pause))')
						(Print 40 61) ; "You don't have to go to the bathroom now."
					)
					((Said 'pay/attendant')
						(Print 40 62) ; "What for?"
					)
				)
			)
		)
	)
)

(instance endStageTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (StageTwo state:) 4)
					(proc154_1 40 63 67 30 40)
				)
				(StageTwo changeState: 7)
			)
		)
	)
)

