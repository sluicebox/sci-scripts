;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Rm9 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance gate of Act
	(properties
		y 158
		x 154
		view 109
		signal 8192
		illegalBits 0
		xStep 1
	)
)

(instance Rm9 of Rm
	(properties
		picture 9
	)

	(method (init)
		(Load rsVIEW 31)
		(Load rsVIEW 9)
		(Load rsVIEW 109)
		(Load rsSOUND 10)
		(Load rsSOUND 11)
		(Load rsSOUND 29)
		(Load rsSOUND 30)
		(Load rsSOUND 33)
		(super init:)
		(= global112 4)
		(= local2 1)
		(proc0_13 258)
		(gAddToPics doit:)
		(gEgo
			view:
				(cond
					((== global116 1) 9)
					((IsFlag 3) 3)
					(else 1)
				)
		)
		(if (== global116 1)
			(self setRegions: 113 115) ; horseReg, muleReg
		)
		(User blocks: 1)
		(gRmMusic number: (proc0_20 29) loop: 1 priority: 4)
		(gSFX number: 10 loop: -1 priority: 3)
		(switch gPrevRoomNum
			(103
				(gEgo loop: 3 posn: 170 185 init: setMotion: MoveTo 170 170)
				(if (IsFlag 20)
					(Load rsVIEW 405)
					(gMuleObj
						setLoop: 3
						setPri: -1
						ignoreActors: 0
						posn: 235 180
						init:
						setCycle: Walk
						looper: 0
						setScript: muleActions
					)
					(= local0 2)
				)
				(gate init: setPri: 4 addToPic:)
			)
			(else
				(gEgo setPri: 3 posn: 120 123 loop: 2 init: setCycle: Walk)
				(if (== global116 1)
					(Load rsVIEW 405)
					(gMuleObj
						setLoop: 2
						looper: 0
						setCycle: Walk
						setPri: 3
						init:
						posn: 140 130
						setScript: muleActions
					)
					(= local0 1)
				)
				(gate setPri: 14 init:)
				(if (== global116 1)
					(gate posn: 154 148 setScript: GateUp)
				else
					(gate addToPic:)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(User blocks: 0)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(super doit:)
		(cond
			((!= global116 1) 0)
			(
				(and
					(== local3 (gEgo x:))
					(== local4 (gEgo y:))
					(!= (gEgo view:) 31)
				)
				(if (== (gSFX state:) 3)
					(gSFX stop:)
				)
			)
			((and (== (gEgo view:) 31) (== (gSFX number:) 10))
				(gSFX number: 11 play:)
			)
			(
				(or
					(and (!= (gEgo view:) 31) (== (gSFX number:) 11))
					(!= (gSFX state:) 3)
				)
				(gSFX number: 10 play:)
			)
		)
		(= local3 (gEgo x:))
		(= local4 (gEgo y:))
		(cond
			((and (> (gEgo y:) 180) (!= (gEgo loop:) 3))
				(gSFX stop:)
				(gCurRoom newRoom: 103)
			)
			((& (gEgo onControl: 0) $0002)
				(gCurRoom newRoom: 8)
			)
		)
		(if
			(and
				(not (gate script:))
				(== global116 1)
				(== gPrevRoomNum 8)
				(or (not (IsFlag 8)) (not (IsFlag 7)))
				(> (gEgo y:) 150)
			)
			(gate setScript: GateDown)
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
				(and
					(!= global116 1)
					(or
						(Said 'get,look,(are<where)/charger,ass')
						(Said 'ask[/merlin]/charger,ass')
					)
				)
				(cond
					((not (IsFlag 3))
						(Print 9 0) ; "Your horse and mule are being prepared for the journey."
					)
					((== global115 8)
						(Print 9 1) ; "Your horse and mule await you in the courtyard."
					)
					(else
						(event claimed: 0)
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
					((Said '/sky,up')
						(Print 9 2) ; "The skies are clear and the weather holding good. A fine time to begin a journey."
					)
					((Said '/floor,dirt,cobblestones,down')
						(Print 9 3) ; "Amazingly enough, it is also paved with stone."
					)
					(
						(or
							(Said '/bridge')
							(Said '//bridge')
							(Said '<ahead')
							(OnButton event 38 136 310 182)
						)
						(Print 9 4) ; "Here your journey begins in earnest. Search your soul and be sure you are ready."
						(Print 9 5) ; "Once you leave Camelot, I will seal the castle with a powerful spell of protection. You will not be able to re-enter until you have the Grail."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
						)
						(Print 9 6) ; "This is the main gate of Camelot."
					)
					((or (Said '/camelot') (Said '//camelot'))
						(Print 9 7) ; "It stands tall, strong and proud. Yet if you fail, it will not endure."
					)
					((Said '/ceiling')
						(Print 9 8) ; "The top of the tunnel is also stone."
					)
					((or (Said '/tunnel,arch') (Said '//tunnel,arch'))
						(if (< (gEgo y:) 160)
							(Print 9 9) ; "It is fairly dark in here. There is not much to see."
						else
							(Print 9 10) ; "It leads to the courtyard and the main door to the castle."
						)
					)
					(
						(or
							(Said '/boulder')
							(Said '//boulder')
							(OnButton event 9 134 44 182)
						)
						(Print 9 11) ; "The boulders are part of the castle's foundation."
					)
					(
						(or
							(Said '/door,gate,gate')
							(Said '//door,gate,gate')
							(OnButton event 100 52 213 160)
						)
						(Print 9 12) ; "This heavy portcullis was built to withstand even a battering ram."
					)
					(
						(or
							(Said '/shield,design,plaque,dragon,lion,pendragon')
							(Said
								'//shield,design,plaque,dragon,lion,pendragon'
							)
							(OnButton event 144 6 176 39)
						)
						(Print 9 13) ; "You surely know your own symbol, Arthur, the red dragon of Pendragon."
					)
					(
						(or
							(Said '/wall,slab')
							(Said '//wall,slab')
							(OnButton event 9 8 310 148)
						)
						(Print 9 14) ; "The walls are massive and built of stone."
					)
					((or (Said '/chart') (Said '//chart'))
						(Print 9 15) ; "Travel on and the map will guide you."
					)
					((or (Said '/moat') (Said '//moat'))
						(Print 9 16) ; "There is no moat. Your protection is in the high walls and steep cliffs."
					)
					((or (Said '/drawbridge') (Said '//drawbridge'))
						(Print 9 17) ; "Camelot was designed without a drawbridge."
					)
					(
						(and
							(== global200 2)
							(or (Said '/gawain') (Said '//gawain'))
						)
						(Print 9 18) ; "He is safe within. Worry not."
					)
					(
						(and
							(IsFlag 65)
							(or (Said '/lancelot') (Said '//lancelot'))
						)
						(Print 9 18) ; "He is safe within. Worry not."
					)
				)
			)
			((Said 'jump')
				(Print 9 19) ; "And fall to your death? Ridiculous."
			)
			((Said 'climb<above/gate,door,gate')
				(Print 9 20) ; "That is quite impossible."
			)
			((and (== global116 1) (Said 'mount,(get<on)/charger'))
				(Print 9 21) ; "You already are on your horse."
			)
			((and (== global116 1) (Said 'dismount,(get<off)/charger'))
				(Print 9 22) ; "You don't need to get off your horse."
			)
			((Said 'open,lift/gate')
				(cond
					((== local2 0)
						(Print 9 23) ; "It IS open."
					)
					((== gPrevRoomNum 103)
						(Print 9 24) ; "You may not return, Arthur, until you have found the Grail...or died in trying. To turn aside or abandon your sacred mission means the certain death of all you hold dear."
					)
					((not (IsFlag 3))
						(switch local1
							(0
								(++ local1)
								(Print 9 25) ; "You can hardly begin a long and arduous journey in your court clothes."
							)
							(else
								(Print 9 26) ; "Do you think this is a fairytale where you can simply run off without preparation?"
							)
						)
					)
					(else
						(switch local1
							(0
								(++ local1)
								(Print 9 27) ; "Certainly. As soon as you have a horse under you, as common sense would require."
							)
							(else
								(Print 9 28) ; "This is no time for petulance or foolishness.  The lives of all your people hang in the balance."
							)
						)
					)
				)
			)
			((Said 'lower,close/gate,*')
				(if (== local2 1)
					(Print 9 29) ; "It IS lowered"
				else
					(Print 9 30) ; "It will be done. You need not worry."
				)
			)
			((Said 'cut,annihilate,annihilate/gate,*')
				(Print 9 31) ; "Excaliber is a powerful sword, but even it cannot break this portcullis."
			)
			((and (IsFlag 20) (Said 'pull,guide,get/ass'))
				(Print 9 32) ; "There is no need. It will follow."
			)
			((Said 'get/pack')
				(Print 9 33) ; "It is on the mule which follows you."
			)
			((Said 'get/food,water,clothes,blanket')
				(Print 9 34) ; "It is rather early for that. You have not even begun to travel."
			)
			((and (== global115 8) (Said 'fetch,get/charger,ass'))
				(Print 9 35) ; "If it is ready, it will be in the courtyard."
			)
			((Said '*/charger,ass')
				(Print 9 36) ; "What an utterly ridiculous idea."
			)
			((Said 'call,command,command,yell/guard')
				(Print 9 37) ; "They are at their posts where they belong."
				(Print 9 38) ; "This is your mission alone, Arthur. They cannot help you."
			)
		)
	)
)

(instance GateUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= global109 6)
				(= cycles 3)
			)
			(1
				(gRmMusic play:)
				(gate ignoreActors: 1 setMotion: MoveTo 154 80 self)
			)
			(2
				(gate stopUpd: setScript: 0)
				(gEgo setLoop: -1 setPri: -1)
				(gMuleObj setPri: -1)
				(= local2 0)
				(gRmMusic stop:)
				(= global109 0)
				(HandsOn)
			)
		)
	)
)

(instance GateDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gRmMusic number: (proc0_20 30) loop: 1 play:)
				(= global109 6)
				(gEgo setMotion: MoveTo (gEgo x:) 200)
				(gate setPri: 4 setStep: 1 8 setMotion: MoveTo 154 128 self)
				(if (IsFlag 20)
					(gMuleObj setMotion: 0 setPri: 3)
				)
			)
			(1
				(gRmMusic number: (proc0_20 33) loop: 1 play:)
				(gEgo
					view: 109
					loop: (if (< (gEgo x:) 155) 1 else 2)
					cel: 0
					looper: 0
					setMotion: 0
					ignoreActors: 1
					illegalBits: 0
					setCycle: End self
				)
				(= global109 0)
			)
			(2
				(= seconds 1)
			)
			(3
				(gate setScript: 0)
				(cond
					((not (IsFlag 2))
						(EgoDead 9 39) ; "It is terribly unwise to start a sacred mission without the blessings of the gods."
					)
					((IsFlag 7)
						(EgoDead 9 40) ; "The Christ god does not like being ignored. His vengeance is swift and final."
					)
					((IsFlag 8)
						(EgoDead 9 41) ; "Alas, Mithras is a bad god to offend. Remember this, in your next life."
					)
					(else
						(EgoDead 9 42) ; "One does not get far when the gods are offended."
					)
				)
			)
		)
	)
)

(instance muleActions of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			(
				(and
					(gCast contains: gMuleObj)
					(!= local0 2)
					(> (gEgo y:) 160)
					(not (gate script:))
				)
				(gMuleObj setMotion: MoveTo 150 150)
				(= local0 2)
			)
			(
				(and
					(gCast contains: gMuleObj)
					(== local0 2)
					(< (gEgo y:) 160)
				)
				(gMuleObj setMotion: 0)
				(= local0 0)
			)
		)
	)
)

