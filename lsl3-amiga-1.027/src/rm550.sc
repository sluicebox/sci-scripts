;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm550 0
)

(local
	drowningLoop
	[string 55]
	[string2 22]
)

(instance rm550 of Rm
	(properties
		picture 550
		horizon 50
		south 540
	)

	(method (init)
		(Load rsVIEW 551)
		(Load rsVIEW 552)
		(Load rsVIEW 553)
		(Load rsSOUND 6)
		(super init:)
		(aLog setCycle: Fwd init:)
		(self setScript: RoomScript)
		(if gDebugging
			(= gEgoIsPatti 1)
			(= gNormalEgoView 803)
			((Inv at: 17) view: 31) ; Dress
			(= gEgoState 0)
		)
		(NormalEgo)
		(gEgo posn: 159 188 loop: 3 init: viewer: PattiViewer)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'fuck,board,(climb,lie,get<on)/log')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not (< (gEgo distanceTo: aLog) 25))
						(NotClose) ; "You're not close enough."
					)
					(else
						(self changeState: 4)
					)
				)
			)
			(
				(Said
					'nightstand,exit,(get<off),(climb,get<off,up),(get<up),(nightstand<up)'
				)
				(if (!= gEgoState 550)
					(Print 550 0) ; "How can you do that?"
				else
					(self changeState: 8)
				)
			)
			((Said 'weave')
				(Print 550 1) ; "That was Larry's bit, Patti!"
			)
			((Said '/island')
				(Print 550 2) ; "There it is! Right over there! Just across the channel!"
				(Print 550 3 #at -1 144) ; "(Why don't you try swimming over there? Hee, hee.)"
			)
			((Said 'hit,hit,grasp,grab/log')
				(cond
					((not (< (gEgo distanceTo: aLog) 25))
						(NotClose) ; "You're not close enough."
					)
					((== gEgoState 550)
						(Print 550 4) ; "Whee! Giddyup, old Log!"
					)
					(else
						(Print 550 5) ; "That is not the answer, but the log is the key to your success here."
					)
				)
			)
			((Said 'pull,pull,use/log')
				(cond
					((not (< (gEgo distanceTo: aLog) 25))
						(NotClose) ; "You're not close enough."
					)
					((== gEgoState 550)
						(Print 550 6) ; "A good idea, but difficult to do when you are sitting smack dab on top of your log!"
					)
					((!= (aLog x:) 77)
						(Print 550 7) ; "If you pull it any farther, you'll lose it in the current."
					)
					(else
						(self changeState: 1)
					)
				)
			)
			((Said 'drink')
				(Print 550 8) ; "You're not really that thirsty."
			)
			((or (Said 'board,exit,exit,(get<in)/water') (Said 'swim,wade'))
				(Print 550 9) ; "You'll have to get wet first."
			)
			((Said 'get>')
				(cond
					((Said '/log')
						(Print 550 10) ; "Yeah; just what you need: a big hunk of timber! You don't need to TAKE the log..."
					)
					((Said '/palm')
						(Print 550 11) ; "How can you reach them from here?"
					)
					((Said '/bush')
						(Print 550 12) ; "The plants will do you no good."
					)
				)
			)
			((Said 'look<in/bush')
				(Print 550 13) ; "Look! A small log rests in the weeds near the riverbank."
			)
			((Said 'look>')
				(cond
					((Said '/log')
						(cond
							((!= (aLog x:) 77)
								(Print 550 14) ; "You have dragged a log into the middle of the river. Now what are you going to do with it?"
							)
							((== (gEgo view:) gNormalEgoView)
								(Print 550 15) ; "Where? You see no log from your current location."
								(Print 550 16 #at -1 144) ; "(Here's one place where you may have to get your feet wet, Patti!)"
							)
							(else
								(Print 550 13) ; "Look! A small log rests in the weeds near the riverbank."
							)
						)
					)
					((Said '/bush')
						(Print 550 17) ; "Dutch rush grows in the shallow water at the edge of the stream."
					)
					((Said '/palm')
						(Print 550 18) ; "The only trees you can see from here are all the way across the river, and completely out of your reach."
					)
					((Said '[/area,water,creek]')
						(Print 550 19) ; "A roaring river rushes by. It looks too deep to wade across and too rapid to swim. How will you proceed from here?"
					)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Ok) ; "O.K."
				(gGame changeScore: 10)
				(HandsOff)
				(= gEgoState 551)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (aLog x:) 20) (+ (aLog y:) -14) self
				)
			)
			(2
				(aLog hide:)
				(gEgo
					cycleSpeed: 1
					moveSpeed: 1
					viewer: 0
					posn: (aLog x:) (aLog y:)
					view: 553
					setLoop: 0
					setCycle: Fwd
					setMotion: MoveTo 170 131 self
				)
			)
			(3
				(aLog posn: 170 131 show:)
				(gEgo
					viewer: PattiViewer
					posn: (+ (aLog x:) 20) (+ (aLog y:) -14)
				)
				(NormalEgo 2 551)
				(= gEgoState 0)
			)
			(4
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo (+ (aLog x:) 20) (+ (aLog y:) -14) self
				)
			)
			(5
				(aLog hide:)
				(gEgo
					viewer: 0
					cycleSpeed: 1
					posn: (aLog x:) (aLog y:)
					view: 553
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: 2 setCycle: Fwd)
				(= gEgoState 550)
				(if (!= (aLog x:) 77)
					(self changeState: 10)
				else
					(= seconds 7)
				)
				(Print 550 20) ; "You mount the gnarly log."
				(if (>= gFilthLevel 3)
					(Print 550 21 #at -1 144) ; "(...an experience not wholly unfamiliar to you!)"
				)
			)
			(7
				(Print 550 22) ; "Boy, is this fun! Sitting on a log, mired in the mud of the river bottom."
				(User canInput: 1)
			)
			(8
				(Ok) ; "O.K."
				(HandsOff)
				(gEgo setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(9
				(= gEgoState 0)
				(aLog show:)
				(NormalEgo 2 551)
				(gEgo
					viewer: PattiViewer
					posn: (+ (aLog x:) 20) (+ (aLog y:) -14)
				)
			)
			(10
				(gGame changeScore: 20)
				(gEgo
					cycleSpeed: 0
					setStep: 2 1
					setMotion: MoveTo 278 106 self
				)
				(= cycles 11)
			)
			(11
				(Print 550 23) ; "You did it!"
				(Print 550 24) ; "The current has caught your log and is taking you downstream... toward your Larry?"
			)
			(12
				(gEgo setLoop: 3 setMotion: MoveTo 348 73 self)
			)
			(13
				(Print 550 25) ; "Press F8 to bypass the next scene."
				(gCurRoom newRoom: 560)
			)
			(14
				(HandsOff)
				(= gEgoState 1003)
				(Print (Format @string 550 26 gExpletive) #at -1 10 #dispose) ; "%s"
				(= drowningLoop 0)
				(gEgo
					viewer: drowningViewer
					illegalBits: 0
					ignoreActors:
					view: 812
					setLoop: drowningLoop
					setCycle: Fwd
					setMotion:
						MoveTo
						(if (> (gEgo x:) 278)
							(gEgo x:)
						else
							278
						)
						106
						self
				)
				(gSoundFX number: 6 loop: -1 play:)
			)
			(15
				(cls)
				(= drowningLoop 2)
				(gEgo setMotion: MoveTo 348 73 self)
			)
			(16
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 816
					register: (Format @string 550 27) ; "Patti! Be more careful! There are treacherous undercurrents in this river."
					next: (Format @string2 550 28) ; "Head over heels but not in love!"
				)
			)
		)
	)
)

(instance aLog of Prop
	(properties
		y 155
		x 77
		yStep 12
		view 550
		cycleSpeed 2
	)
)

(instance PattiViewer of Code
	(properties)

	(method (doit)
		(gEgo brBottom: (+ (gEgo y:) 1))
		(gEgo brTop: (- (gEgo brBottom:) (gEgo yStep:)))
		(gEgo brLeft: (- (gEgo x:) 8))
		(gEgo brRight: (+ (gEgo x:) 8))
		(cond
			((& (gEgo onControl: 1) $0010)
				(RoomScript changeState: 14)
			)
			((& (gEgo onControl:) $0004)
				(gEgo view: gNormalEgoView setCycle: Walk)
			)
			((& (gEgo onControl: 1) $0002)
				(gEgo view: 552 setCycle: Walk)
			)
			((& (gEgo onControl: 1) $0008)
				((Inv at: 17) view: 32) ; Dress
				(gEgo view: 551 setCycle: Fwd)
			)
		)
	)
)

(instance drowningViewer of Code
	(properties)

	(method (doit)
		(if (Random 0 5)
			(gEgo setLoop: (+ drowningLoop (Random 0 1)))
		)
	)
)

