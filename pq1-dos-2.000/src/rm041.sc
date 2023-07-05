;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm041 0
	tawneeT 1
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
	local10 = 1
)

(instance rm041 of PQRoom
	(properties
		noun 1
		picture 41
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(gEgo get: 2 0 5 1 9) ; Extender
			(= global224 {Wednesday, July 29, 1992})
		)
		(= global206 0)
		(= global207 914)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 32 83 36 89 30 96 0 86 0 125 35 107 126 121 154 135 101 168 0 135 0 189 163 189 114 171 126 153 174 141 211 141 250 153 308 181 294 189 319 189 319 168 244 141 239 144 172 123 176 120 160 116 157 115 0 65 0 79 4 75
					yourself:
				)
		)
		(hydrant init:)
		(yellowLines init:)
		(upperWindows init:)
		(sideWalk init:)
		(redCurb init:)
		(redAwning init:)
		(marketDoor init:)
		(marketSign init:)
		(otherDoors init:)
		(produce init:)
		(frankWindow init:)
		(tonySign init:)
		(frankBuilding init:)
		(stainedGlassWindows init:)
		(super init:)
		(patrolCar
			init:
			signal: (| (patrolCar signal:) $1000)
			ignoreActors: 1
			addToPic:
		)
		(gEgo
			init:
			view: 7
			setLoop: 4
			cel: 0
			setPri: 11
			posn: (+ (patrolCar x:) 9) (+ (patrolCar y:) 58)
			actions: egoUseRadio
			ignoreControl: -32768
		)
		(frontDoor init:)
		(backDoor
			init:
			setPri: 11
			posn: (+ (patrolCar x:) 15) (+ (patrolCar y:) 59) 37
			stopUpd:
		)
		(sirenLights
			init:
			posn: (+ (patrolCar x:) 19) (+ (patrolCar y:) 10)
			ignoreActors:
			setCycle: Fwd
		)
		(redLight
			init:
			posn: (+ (patrolCar x:) 48) (+ (patrolCar y:) 27)
			setCycle: Fwd
		)
		(blueLight
			init:
			posn: (+ (patrolCar x:) 52) (+ (patrolCar y:) 26)
			setCycle: Fwd
		)
		(sportsCar
			init:
			stopUpd:
			signal: (| (patrolCar signal:) $1000)
			ignoreActors: 1
			addToPic:
		)
		(helen
			init:
			posn: (+ (sportsCar x:) 10) (+ (sportsCar y:) 13)
			stopUpd:
			ignoreActors:
		)
		(self setScript: startUpRoom)
		(gNarrator x: 100 y: 70)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((gEgo inRect: 164 121 294 174)
				(gEgo setPri: 7)
			)
			(else
				(gEgo setPri: -1)
			)
		)
		(= local0 (GetDistance (gEgo x:) (gEgo y:) 71 111))
		(if (!= local3 local0)
			(if (> (= local2 (- 163 local0)) 100)
				(= local2 100)
			)
			(if (and local1 (< local2 50))
				(= local1 0)
				(= local2 0)
				(gLongSong stop:)
				(gLongSong2 play:)
			)
			(if (and (> local2 50) (not local1))
				(= local1 1)
				(gLongSong play: local2)
				(gLongSong2 stop:)
			)
			(gLongSong setVol: local2)
			(= local3 local0)
		)
		(super doit:)
	)

	(method (dispose)
		(gEgo put: 8 gCurRoom onMeCheck: 26505) ; Ticket
		(super dispose: &rest)
	)
)

(instance startUpRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 911 loop: 1 play:)
				(= seconds 4)
			)
			(1
				(= seconds 2)
				(gLongSong fade:)
			)
			(2
				(gLongSong2 number: 915 loop: -1 play:)
				(HandsOn)
				(gTheIconBar disable: 0)
			)
		)
	)
)

(instance tawneeT of Talker
	(properties
		x 220
		y 93
		view 1344
		priority 15
		signal 16400
		talkWidth 150
		textX -180
		textY -20
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 tawneeMouth &rest)
	)
)

(instance tawneeMouth of Prop
	(properties
		nsTop 32
		nsLeft 34
		view 1344
		loop 1
		priority 15
		signal 16400
	)
)

(instance egoUseRadio of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Extender
				(if local4
					(if local7
						(gMessager say: 22 11 4 1) ; "Apparently, dispatch has a better memory than you. Don't clutter the airwaves unless you've got new information for them."
					else
						(if local10
							(SetScore 145 1)
						)
						(= local7 1)
						(gEgo onMeCheck: 0)
						(gMessager say: 22 11 18 0) ; "Dispatch, this is 83-32. Run wants on plate number AWYLD1."
					)
				else
					(gMessager say: 22 11 15 1) ; "The license number of the vehicle might prove helpful."
				)
				(return 1)
			)
		)
		(return 0)
	)
)

(instance patrolCar of View
	(properties
		x 176
		y 143
		noun 20
		view 103
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if local10
					(gCurRoom setScript: getOutOfCar)
				else
					(gCurRoom setScript: getInCar)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontDoor of Prop
	(properties
		noun 20
		view 103
		loop 2
		priority 12
		signal 4112
	)

	(method (init)
		(super init: &rest)
		(self posn: (- (patrolCar x:) 5) (+ (patrolCar y:) 67) 50 stopUpd:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 11) ; Extender
			(egoUseRadio doVerb: theVerb &rest)
		else
			(patrolCar doVerb: theVerb &rest)
		)
	)
)

(instance backDoor of Prop
	(properties
		noun 20
		view 103
		loop 3
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance sirenLights of Prop
	(properties
		noun 20
		view 103
		loop 4
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance blueLight of Prop
	(properties
		noun 20
		view 103
		loop 5
		cel 2
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance redLight of Prop
	(properties
		noun 20
		view 103
		loop 6
		cel 1
	)

	(method (doVerb)
		(patrolCar doVerb: &rest)
	)
)

(instance sportsCar of View
	(properties
		x 49
		y 130
		noun 5
		view 219
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 5 1 0 1) ; "What you wouldn't do for a car like THIS one. Right. On your salary, it'd take you a year just for the down payment."
				(= local4 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance talkToHelenFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 43)
				(= local5 1)
				(gMessager say: 18 2 12 0 self) ; "You open your mouth, and discover your throat has gone dry. You clear it in a manly way, and say;"
			)
			(1
				(helen cel: 0 setLoop: 2 setCycle: End self)
			)
			(2
				(gMessager say: 18 2 13 0 0) ; "She hands you her license, brushing your fingers with hers, and says;"
			)
			(3
				(helen cel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(helen cel: 0 setLoop: 0)
			)
		)
	)
)

(instance talkToHelenSecond of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(gMessager say: 18 2 4 0 self) ; "Please, Officer Bonds? I can't afford a ticket. I'll be lucky if I can make my rent this month."
			)
			(1
				(helen cel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance giveHelenTicket of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				local8
				(== (gLongSong prevSignal:) 5)
				(!= (gLongSong number:) 411)
			)
			(gLongSong number: 411 loop: -1 flags: -1 play: local2)
		)
	)

	(method (changeState newState &tmp [temp0 40])
		(switch (= state newState)
			(0
				(= local9 1)
				(if
					(= local8
						(Print
							addText: 18 19 18 1 ; "Are you going to give Tawnee a ticket or just a warning?"
							addButton: 0 19 52 0 0 10 30 41 ; "Warning"
							addButton: 1 19 50 0 0 90 30 41 ; "Ticket"
							init:
						)
					)
					(gMessager say: 19 4 19 0 self) ; "I'm sorry, Miss, but running stop signs is very dangerous. I'd like to let you off with a warning, but I can't."
					(SetScore 147 5)
				else
					(gMessager say: 19 4 6 0 self) ; "Well, ah, Miss, I'll just let you off with a warning this time. We all make mistakes now and then."
				)
			)
			(1
				(if local8
					(gEgo put: 8 gCurRoomNum) ; Ticket
					(gMessager say: 19 4 5 0) ; "As you write out the ticket a strange transformation comes over Tawnee. It's pretty scary. Just when you think her face couldn't get any redder, she starts to scream."
				)
			)
		)
	)
)

(instance helen of Prop
	(properties
		noun 18
		view 375
	)

	(method (doVerb theVerb)
		(if local10
			(gMessager say: 20 0 17 1) ; "That would be more effective if you were out of your patrol car."
		else
			(switch theVerb
				(2 ; Talk
					(if local6
						(if local7
							(cond
								((== local5 0)
									(self setScript: talkToHelenFirst)
								)
								(local9
									(if local8
										(gMessager say: 18 2 7 1) ; "LEAVE ME ALONE!"
									else
										(gMessager say: 18 2 8 1) ; "Thanks again, Sonny-Bunny! Call me, okay?"
									)
								)
								(else
									(self setScript: talkToHelenSecond)
								)
							)
						else
							(gMessager say: 18 2 16 1) ; "The fact that she's an attractive young woman doesn't mean you should be any less cautious, nor should procedure be neglected. Too many before you have learned the ultimate lesson by becoming lax in these types of situations."
						)
					else
						(gMessager say: 18 2 1 0) ; "Don't you think you should look at the young lady before you talk to her?"
					)
				)
				(1 ; Look
					(= local6 1)
					(if (!= local5 0)
						(gMessager say: 18 1 11 1) ; "Your knees turn to water as the gorgeous young woman locks eyes with you. Her sweet, full lips curve into a smile that could turn icewater to steam."
					else
						(gMessager say: 18 1 10 0) ; "Your knees turn to water as the gorgeous young woman locks eyes with you. Her sweet, full lips curve into a smile that could turn icewater to steam. She lowers her eyelids, and whispers;"
					)
					(self cel: 0 setLoop: 0 setCycle: End)
				)
				(19 ; Ticket
					(if local5
						(if local9
							(gMessager say: 18 19 4 1) ; "You aren't going to change your mind about giving her a ticket, now are you?"
						else
							(self setScript: giveHelenTicket)
						)
					else
						(gMessager say: 18 19 3 1) ; "You start to give her a ticket, then decide that you want to enjoy her company for just another moment. Perhaps you should talk to her some more..."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance hydrant of Feature
	(properties
		noun 3
		onMeCheck 8192
	)
)

(instance yellowLines of Feature
	(properties
		noun 17
		onMeCheck 16384
	)
)

(instance upperWindows of Feature
	(properties
		noun 15
		onMeCheck 4
	)
)

(instance sideWalk of Feature
	(properties
		noun 16
		onMeCheck 8
	)
)

(instance redCurb of Feature
	(properties
		noun 4
		onMeCheck 2
	)
)

(instance redAwning of Feature
	(properties
		noun 2
		onMeCheck 16
	)
)

(instance marketDoor of Feature
	(properties
		noun 13
		onMeCheck 64
	)
)

(instance marketSign of Feature
	(properties
		noun 10
		onMeCheck 128
	)
)

(instance otherDoors of Feature
	(properties
		noun 14
		onMeCheck 32
	)
)

(instance produce of Feature
	(properties
		noun 11
		onMeCheck 4096
	)
)

(instance frankWindow of Feature
	(properties
		noun 8
		onMeCheck 256
	)
)

(instance tonySign of Feature
	(properties
		noun 12
		onMeCheck 2048
	)
)

(instance stainedGlassWindows of Feature
	(properties
		noun 23
		onMeCheck 512
	)
)

(instance frankBuilding of Feature
	(properties
		noun 7
		onMeCheck 1024
	)
)

(instance getOutOfCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(helen
					approachVerbs: 1 2 19 ; Look, Talk, Ticket
					approachX: (- (sportsCar x:) 3)
					approachY: (+ (sportsCar y:) 19)
				)
				(frontDoor setCycle: End self)
				(sfx number: 900 loop: 1 flags: -1 play:)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(NormalEgo)
				(gEgo posn: (+ (gEgo x:) 5) (- (gEgo y:) 4))
				(= cycles 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 5) (+ (gEgo y:) 5) self
				)
			)
			(4
				(gEgo setHeading: 315 self)
			)
			(5
				(frontDoor setCycle: Beg self)
			)
			(6
				(sfx number: 901 loop: 1 flags: -1 play:)
				(helen setCycle: ForwardCounter 1)
				(gEgo
					setMotion:
						MoveTo
						(- (patrolCar x:) 30)
						(+ (patrolCar y:) 45)
						self
				)
			)
			(7
				(gLongSong number: 410 loop: -1 flags: -1 play: local2)
				(gLongSong2 pause: 1)
				(gEgo onMeCheck: 26505)
				(= local10 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getInCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local8
					(gMessager say: 20 4 9 0 self) ; "That's right! Go on back to your sty, pig!"
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					setMotion:
						PolyPath
						(+ (patrolCar x:) 7)
						(+ (patrolCar y:) 46)
						self
				)
			)
			(2
				(gEgo
					setMotion:
						MoveTo
						(+ (patrolCar x:) 9)
						(+ (patrolCar y:) 58)
						self
				)
			)
			(3
				(sfx number: 900 loop: 1 flags: -1 play:)
				(frontDoor setCycle: End self)
			)
			(4
				(gEgo
					view: 7
					loop: 4
					setPri: 11
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(5
				(frontDoor setCycle: Beg self)
			)
			(6
				(sfx number: 901 loop: 1 flags: -1 play:)
				(gLongSong fade:)
				(gLongSong2 number: 0 stop:)
				(= global211 13)
				(= seconds 2)
			)
			(7
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance sfx of Sound
	(properties)
)

