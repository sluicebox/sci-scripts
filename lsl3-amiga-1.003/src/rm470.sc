;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 470)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm470 0
)

(local
	destination
	lightCel
)

(instance rm470 of Rm
	(properties
		picture 470
	)

	(method (init)
		(if (gEgo has: 12) ; Penthouse_Key
			(Load rsVIEW 12)
		)
		(Load rsVIEW (+ 715 (* 100 gEgoIsPatti)))
		(Load rsSOUND 460)
		(super init:)
		(aBeamFront init:)
		(aBeamRear init:)
		(aDoor init:)
		(aFloor init:)
		(gAddToPics add: atpPanel doit:)
		(self setScript: RoomScript)
		(NormalEgo 3)
		(gEgo posn: 161 137 init:)
		(if (> gPrevRoomNum gCurRoomNum)
			(= lightCel 8)
		)
		(aLight setPri: 4 setCel: lightCel init: stopUpd:)
		(gMusic number: 32 loop: gBgMusicLoops play:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event &tmp [string 50])
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((or (Said 'use/key') (Said 'pull/button,carpet'))
				(Print 470 0) ; "You must pick a floor. Which floor?"
			)
			(
				(or
					(Said '/penthouse,9,9')
					(Said '//penthouse,9,9')
					(Said 'go,pull/penthouse,9,9')
				)
				(cond
					((not (gEgo has: 12)) ; Penthouse_Key
						(Print 470 1) ; "You attempt to pick the lock with your fingernail, but are unsuccessful!"
						(Print (Format @string 470 2 gEgoName) #at -1 144) ; "(You must have a room key to operate this elevator, %s.)"
					)
					(destination
						(Print 470 3) ; "Suffering from severe indecision, you push again!"
					)
					((> lightCel 7)
						(Print 470 4) ; "That's where you are!"
					)
					(else
						(if gEgoIsPatti
							(= destination 484)
						else
							(= destination 480)
						)
						(self changeState: 2)
					)
				)
			)
			(
				(or
					(Said '/carpet,1,area')
					(Said '//carpet,1,(carpet<first),area')
					(Said 'go,pull/carpet,1,area')
				)
				(cond
					((not (gEgo has: 12)) ; Penthouse_Key
						(Print 470 1) ; "You attempt to pick the lock with your fingernail, but are unsuccessful!"
						(Print (Format @string 470 2 gEgoName) #at -1 144) ; "(You must have a room key to operate this elevator, %s.)"
					)
					(destination
						(Print 470 3) ; "Suffering from severe indecision, you push again!"
					)
					((== lightCel 0)
						(Print 470 4) ; "That's where you are!"
					)
					(else
						(= destination 460)
						(self changeState: 2)
					)
				)
			)
			((Said 'up,down,open,close')
				(Print 470 5) ; "Press the floor number, please."
			)
			((Said 'pull,go')
				(Print 470 6) ; "You have no business travelling to any floor except one and nine."
			)
			((Said 'listen')
				(if gEgoIsPatti
					(Print 470 7) ; "Gawd, do you hate musical tripe!"
				else
					(Print 470 8) ; "Your favorite style of music is playing."
				)
			)
			((Said 'exit,go,exit,done,stop')
				(Ok) ; "O.K."
				(Print 470 9) ; "Wait until the door opens."
			)
			((and (gEgo has: 9) (Said '/keycard')) ; Spa_Keycard
				(Print 470 10) ; "The keycard would work better if you were in Fat City!"
			)
			((Said 'pick,hit,break/bolt')
				(Print 470 11) ; "The locks here will only respond to an official hotel room key."
			)
			((Said 'look>')
				(cond
					((Said '/burn')
						(Printf 470 12 (+ 1 (aLight cel:))) ; "The row of lights above the door indicate you are currently at floor %d."
					)
					((Said '/handle,button')
						(Print 470 13) ; "On the wall to the right of the doors is a panel with a keyhole beside a vertical column of buttons numbered from one to nine. "Could those indicate potential floor destinations?" you wonder."
					)
					((Said '/door')
						(Printf ; "The elevator's door is presently %s."
							470
							14
							(if (aDoor cel:) {open} else {closed})
						)
					)
					((Said '/(hole<key),bolt')
						(Print 470 15) ; "The keyhole is a hole into which you insert a key."
					)
					((Said '[/area,elevator]')
						(Print 470 16) ; "It's an elevator."
						(Print 470 17 #at -1 144) ; "(What did you expect?)"
					)
				)
			)
		)
	)

	(method (changeState newState &tmp destY)
		(switch (= state newState)
			(0
				(= seconds 12)
			)
			(1
				(Print 470 18) ; "Evidently, you don't want to change floors!"
				(self changeState: 13)
			)
			(2
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 179 130 self)
			)
			(3
				(gEgo
					cycleSpeed: 1
					view: (+ 715 (* 100 gEgoIsPatti))
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(4
				(if (not (TestFlag 63))
					(SetFlag 63) ; usedElevator
					(gGame changeScore: 4)
					(Print 470 19 #icon 12 0 0) ; "You insert Patti's penthouse key into the ninth floor penthouse access lock and turn it one-quarter turn to the right. Both you and the elevator begin to rise."
				)
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo 3)
				(= cycles 10)
				(if (== destination 460)
					(= state 8)
				)
			)
			(6
				(aLight setCel: (++ lightCel))
				(if (>= lightCel 9)
					(self changeState: 12)
				else
					(aBeamRear setMotion: MoveTo 159 260)
					(aBeamFront setMotion: MoveTo 160 260 self)
				)
			)
			(7
				(aBeamRear posn: 159 -16 setMotion: MoveTo 159 130)
				(aBeamFront posn: 160 -32 setMotion: MoveTo 160 80 self)
			)
			(8
				(aBeamRear posn: 159 48 setMotion: MoveTo 159 128)
				(aBeamFront setMotion: MoveTo 160 160 self)
				(= state 5)
			)
			(9
				(aLight setCel: (-- lightCel))
				(if (== lightCel 0)
					(self changeState: 12)
				else
					(aBeamRear setMotion: MoveTo 159 80)
					(aBeamFront setMotion: MoveTo 160 80 self)
				)
			)
			(10
				(aBeamRear posn: 159 104 setMotion: MoveTo 159 -32)
				(aBeamFront setMotion: MoveTo 160 -32 self)
			)
			(11
				(aBeamRear posn: 159 232 setMotion: MoveTo 159 128)
				(aBeamFront posn: 160 260 setMotion: MoveTo 160 160 self)
				(= state 8)
			)
			(12
				(aFloor setLoop: (if (== destination 460) 4 else 0) stopUpd:)
				(= seconds 3)
			)
			(13
				(HandsOff)
				(gSoundFX number: 460 loop: 1 play:)
				(aDoor setCycle: End self)
			)
			(14
				(aDoor stopUpd:)
				(gEgo illegalBits: 0 setMotion: MoveTo 160 128 self)
			)
			(15
				(gEgo setMotion: MoveTo 160 124 self)
			)
			(16
				(gMusic fade:)
				(if (not destination)
					(= destination gPrevRoomNum)
				)
				(gCurRoom newRoom: destination)
			)
		)
	)
)

(instance atpPanel of PV
	(properties
		y 110
		x 184
		view 470
		loop 1
		priority 5
	)
)

(instance aLight of Prop
	(properties
		y 62
		x 160
		view 460
		loop 2
	)
)

(instance aBeamFront of Act
	(properties
		y 156
		x 160
		view 470
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setPri: 15
			setLoop: (if (> gMachineSpeed 16) 3 else 5)
			setStep: 0 8
		)
	)
)

(instance aBeamRear of Act
	(properties
		y 125
		x 160
		view 470
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self
			ignoreHorizon:
			ignoreActors:
			illegalBits: 0
			setPri: 2
			setLoop: (if (> gMachineSpeed 39) 2 else 5)
			setStep: 0 8
		)
	)
)

(instance aDoor of Prop
	(properties
		y 125
		x 160
		view 460
		signal 16384
	)

	(method (init)
		(super init:)
		(self setCel: 0 species 6 stopUpd: ignoreActors:)
	)
)

(instance aFloor of Prop
	(properties
		y 125
		x 160
		view 470
		signal 16384
	)

	(method (init)
		(super init:)
		(self
			setPri: 5
			setLoop: (if (== gPrevRoomNum 460) 4 else 0) species
			stopUpd:
		)
	)
)

