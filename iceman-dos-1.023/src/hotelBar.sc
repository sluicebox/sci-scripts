;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n821)
(use n822)
(use n824)
(use n828)
(use ForwardCounter)
(use LoadMany)
(use n962)
(use Follow)
(use RFeature)
(use Sight)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	hotelBar 0
	lush 1
	proc11_2 2
	lSV 3
)

(synonyms
	(drink champagne)
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7
)

(procedure (proc11_2 param1)
	(gCast eachElementDo: #perform eCC param1)
)

(procedure (localproc_0 param1)
	(Random 0 (- param1 1))
)

(procedure (localproc_1 param1 param2 param3 param4 param5)
	(Print
		param1
		(switch argc
			(3
				(Random param2 param3)
			)
			(4
				(+ param2 (localproc_0 (/ (+ 1 (- param3 param2)) param4)))
			)
			(5
				(+ param2 (Random 0 (- param4 1)) (* param4 param5))
			)
			(else param2)
		)
	)
)

(instance hotelBar of Rm
	(properties
		picture 11
		west 10
		picAngle 70
	)

	(method (init)
		(ScriptID 962)
		(ScriptID 822)
		Follow
		ForwardCounter
		(Load rsSCRIPT 359)
		(Load rsSCRIPT 358)
		(LoadMany rsTEXT 611 612)
		(LoadMany rsVIEW 206 207 411 212 11 211 511 611 611 811)
		(LoadMany rsSOUND 2 6 8)
		(tahiti flags: (& (tahiti flags:) $ffef))
		(lAB init:)
		(bartender init:)
		(if (not (& (tahiti flags:) $0040))
			((= local2 (ScriptID 309 0)) init:) ; agent
			(if (& (tahiti flags:) $0004)
				(cV addToPic:)
				(aCup init:)
			)
		)
		(wife init:)
		(husband init:)
		(mAB init:)
		(lABTE init:)
		((Clone lABTE) loop: 9 x: 201 y: 108 init:)
		(sV init:)
		(gEgo illegalBits: 0 view: 206 init:)
		(if (== gPrevRoomNum 199) ; danceRm
			(local2
				view: 212
				setCycle: Walk
				xStep: 3
				yStep: 2
				illegalBits: 0
				posn: 140 157
				setScript: aSS
			)
			(gEgo posn: 126 152 loop: 0 xStep: 3 yStep: 2)
		else
			(if (not (& (tahiti flags:) $0040))
				(local2
					view: 211
					loop: 1
					setCel: 16
					setPri: 15
					ignoreActors: 1
					stopUpd:
					illegalBits: 0
					posn: 288 169 15
					setScript: aS 0 (& (tahiti flags:) $0004)
				)
			)
			(gEgo posn: 10 115)
		)
		(gEgo observeControl: -32768)
		(super init:)
		(gAddToPics
			add:
				pP
				tP
				cP
				lABAP
				mAB
				hCPV
				mFF
				mIBF
				pPV
				cPPV
				eChair
				((Clone cPPV) x: 200 y: 155 z: 23 priority: 11 yourself:)
				((Clone cPPV) x: 264 y: 155 priority: 15 yourself:)
			eachElementDo: #init
			doit:
		)
		(barSongScript start: (tahiti whichSong:))
		(self
			setRegions: 300 ; tahiti
			setScript: barSongScript
			setFeatures: wF lABF mirror
		)
		(proc824_0)
		(if (not (& (tahiti flags:) $0002))
			(lush init:)
			(lAV init:)
		else
			(lSV init:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(Print 11 0) ; "You'll have to find a seat."
			)
			((Said 'stand')
				(Print 11 1) ; "You're already standing."
			)
			((Said 'drink')
				(if (== (gEgo view:) 206)
					(Print 11 2) ; "Sit down and order a drink first."
				else
					(Print 11 3) ; "Order a drink first."
				)
			)
			((Said 'look[<at,around][/room]')
				(Print 11 4) ; "This is the hotel bar."
			)
			((Said 'dance')
				(Print 11 5) ; "You don't want to dance alone."
			)
			((Said 'open/door')
				(Print 11 6) ; "The door will open when you walk over to it."
			)
			((Said 'yes')
				(Print 11 7) ; "Yes what?"
			)
			((Said 'ask/woman/date')
				(Print 11 8) ; "Moving a little fast aren't we, Johnny?"
			)
			((Said 'buy,order')
				(proc0_34) ; "You're not close enough."
			)
		)
	)
)

(instance barSongScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tahiti whichSong: state)
				(barSong number: (proc0_5 6) play: self)
			)
			(1
				(tahiti whichSong: state)
				(barSong number: (proc0_5 2) play: self)
			)
			(2
				(tahiti whichSong: state)
				(barSong number: 8 play: self)
			)
			(3
				(tahiti whichSong: state)
				(self init:)
			)
		)
	)
)

(instance barSong of Sound
	(properties
		number 6
	)
)

(instance husband of Act
	(properties
		y 110
		x -20
		view 211
		loop 3
	)

	(method (init)
		(super init:)
		(if (& (tahiti flags:) $0001)
			(hS start: 5)
			(self view: 11 setLoop: 5 posn: 169 146 setCel: 16 setScript: hS)
		else
			(self setLoop: loop setPri: 9)
		)
		(= local4 84)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((IsOffScreen self))
			((Said 'look[<at][/man]')
				(Print 11 9) ; "You see a big Samoan man with a bad attitude."
			)
			((Said 'talk[/man]')
				(if (< local4 91)
					(= local4 0)
				)
				(Print 611 (+ local4 (Random 0 1)))
				(+= local4 2)
			)
		)
	)
)

(instance hS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(tahiti flags: (| (tahiti flags:) $0001))
				(client
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 126 120 self
				)
			)
			(2
				(if
					(and
						(< (gEgo distanceTo: wife) 50)
						(not (gEgo script:))
						(not (& (tahiti flags:) $0010))
						(not (agentHuffScript client:))
						(== (gCurRoom curPic:) 11)
					)
					(tahiti flags: (| (tahiti flags:) $0010))
					(client setScript: (ScriptID 358 0) 0 1) ; pS
				else
					(= cycles 1)
				)
			)
			(3
				(client illegalBits: 0 setMotion: MoveTo 169 146 self)
			)
			(4
				(client
					view: 11
					cel: 0
					setPri: 10
					setLoop: 5
					setCycle: End self
				)
			)
			(5
				(client stopUpd:)
				(proc11_2 1)
			)
			(6
				(if (not (& (tahiti flags:) $0010))
					(HandsOff)
					(client setCycle: Beg self)
				else
					(= start 5)
					(self init:)
				)
			)
			(7
				(client setScript: (ScriptID 358 0) 0 0) ; pS
				(tahiti flags: (| (tahiti flags:) $0010))
			)
		)
	)
)

(instance eChair of PV
	(properties
		y 171
		x 231
		z 1
		view 11
		loop 6
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((not (gCast contains: local2)))
			(else
				(local2 handleEvent: event)
			)
		)
	)
)

(instance aS of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((> (gEgo distanceTo: client) 55))
			((CantBeSeen client))
			((Said 'kiss,fuck,suck[/woman,boob,cunt,bitch,stacy]')
				(localproc_1 611 30 33)
				(local2 setScript: agentHuffScript)
			)
			(
				(or
					(Said 'buy,order/drink,(tai<mai)/woman,stacy')
					(Said 'buy,order/drink,(tai<mai)<woman,stacy')
				)
				(cond
					((& (tahiti flags:) $0800)
						(Print 11 10) ; ""I still have the one you bought me, thank you," the young lady replies."
					)
					((gEgo script:)
						(Print 11 11) ; "Wait a bit."
					)
					(else
						(tahiti flags: (| (tahiti flags:) $0800))
						(gEgo setScript: gADS)
					)
				)
			)
			((or (Said 'dance') (Said 'ask/woman,stacy/dance'))
				(gEgo setScript: wTDS self)
				(if (& (tahiti flags:) $0800)
					(aCup init:)
				)
			)
			((Said 'talk')
				(cond
					((not (& (tahiti flags:) $2000))
						(localproc_1 611 16 20)
						(tahiti flags: (| (tahiti flags:) $2000))
					)
					((& (tahiti flags:) $1000)
						(localproc_1 611 25 29)
					)
					(else
						(localproc_1 611 21 24)
					)
				)
			)
			(
				(and
					(or
						(> (gEgo distanceTo: eChair) 30)
						(> (gEgo y:) (eChair y:))
					)
					(< (gEgo y:) (wife y:))
				))
			((Said 'sit')
				(cond
					((not (& (tahiti flags:) $0800))
						(Print 11 12) ; ""Aren't you at least going to buy me a drink first," the beautiful young lady asks."
					)
					((not (& (tahiti flags:) $1000))
						(Print 11 13) ; "Just a little bold don't you think," she says, " And we haven't even danced yet!"
					)
					(else
						(gEgo setScript: eSitAS)
					)
				)
			)
		)
	)
)

(instance agentHuffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc11_2 0)
				(local2
					setPri: (- (local2 priority:) 1)
					setLoop: 1
					setCycle: Beg self
				)
				(tahiti flags: (| (tahiti flags:) $0040))
				(cond
					((and (== (gEgo view:) 11) (== (gEgo loop:) 7))
						(gEgo setScript: eSFAS self 0)
					)
					((gEgo inRect: 248 129 293 167)
						(gEgo setMotion: MoveTo 248 157 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1)
			(2
				(HandsOff)
				(local2
					view: 212
					setCycle: Walk
					setLoop: -1
					z: 0
					setPri: 12
					setMotion: MoveTo (local2 x:) (- (local2 y:) 10) self
				)
			)
			(3
				(local2 setMotion: MoveTo 238 129 self setPri: -1)
			)
			(4
				(local2 setMotion: MoveTo 130 121 self)
			)
			(5
				(local2 setMotion: MoveTo 25 111 self)
			)
			(6
				(local2
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo -10 111 self
				)
			)
			(7
				(HandsOn)
				(proc11_2 1)
				(local2 dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> state 1)
			(gEgo
				heading:
					(GetAngle (gEgo x:) (gEgo y:) (local2 x:) (local2 y:))
			)
			((gEgo looper:) doit: gEgo (gEgo heading:))
		)
	)
)

(instance eSitAS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors:
					ignoreControl: -32768
					setMotion: MoveTo 241 160 self
				)
			)
			(1
				(gEgo setMotion: MoveTo (eChair x:) (- (eChair y:) 2) self)
			)
			(2
				(gEgo
					view: 11
					loop: 7
					posn: (eChair x:) (- (eChair y:) 1)
					heading: 90
					setCycle: End
				)
				(= seconds 10)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(Print 11 14) ; ""Would you like to come back to my place," the girl asks."
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'stand[<up]')
				(gEgo setScript: eSFAS)
			)
			((Said 'dance')
				(gEgo setScript: eSFAS 0 1)
			)
			((Said 'buy,order/drink[<woman,stacy][/woman,stacy]')
				(if (== (local2 view:) 9)
					(Print 11 15) ; ""I still have the one you bought me, thank you," the girl says."
				else
					(gEgo setScript: eSFAS 0 2)
				)
			)
			((== state 3)
				(cond
					((Said 'yes')
						(gEgo setScript: ePUAS)
					)
					((Said 'no')
						(Print 11 16) ; ""Well, all right then, maybe some other time," she says in a disappointed tone."
						(local2 setScript: agentHuffScript)
					)
					(else
						(Print 11 17) ; "Answer the question first."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance ePUAS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
				(proc11_2 0)
				(SetScore tahiti 413 64 7)
				(local2
					setPri: (- (local2 priority:) 1)
					setLoop: 1
					setCycle: Beg self
				)
			)
			(1
				(gEgo
					view: 206
					setLoop: -1
					setCycle: Walk
					ignoreActors: 0
					ignoreControl: -32768
					setMotion: MoveTo 260 150 self
				)
				(local2
					view: 212
					setCycle: Walk
					setLoop: -1
					z: 0
					setPri: 12
					ignoreActors: 1
					illegalBits: 0
				)
			)
			(2
				(gEgo setMotion: MoveTo 238 129 self)
				(local2 setMotion: Follow gEgo setPri: -1)
			)
			(3
				(gEgo setMotion: MoveTo 130 121 self)
			)
			(4
				(gEgo setMotion: MoveTo 25 111 self)
			)
			(5
				(gCurRoom newRoom: 13) ; beachHuts4
			)
		)
	)
)

(instance eSFAS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
			)
			(1
				(User canControl: 1)
				(gEgo
					view: 206
					loop: 0
					setLoop: -1
					setCycle: Walk
					ignoreActors: 0
					observeControl: -32768
					setScript:
						(switch register
							(0 0)
							(1 wTDS)
							(2 gADS)
						)
				)
			)
		)
	)
)

(instance gADS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 11 18) ; "Oh," she says coyly, "I wouldn't mind sharing a bottle of champagne with you."
				(proc11_2 0)
				(HandsOff)
				(if (gEgo inRect: 206 150 246 168)
					(gEgo setMotion: MoveTo 257 152 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 271 129 self)
			)
			(2
				(Print 11 19) ; "Hey, bartender," you say," can I have a bottle of champagne and two glasses?"
				(QueScript bartender gCS self)
			)
			(3
				(gEgo view: 207 setLoop: 0 setMotion: MoveTo 271 165 self)
			)
			(4
				(Print 11 20) ; ""Oh, thank you," she breathes."
				(Print 11 21) ; "Would you pour me a glass please?"
				(gEgo cycleSpeed: 4 loop: 1 setCycle: End self)
			)
			(5
				(cV setPri: addToPic:)
				(tahiti flags: (| (tahiti flags:) $0004))
				(local2
					cycleSpeed: 3
					ignoreControl: -32768
					loop: 8
					setCycle: End self
				)
			)
			(6
				(gEgo loop: 2 setCycle: End self)
			)
			(7
				(local2 setCycle: Beg self)
			)
			(8
				(local2 loop: 9 setCel: 0 stopUpd:)
				(gEgo loop: 3 setCycle: End self)
			)
			(9
				(gEgo
					view: 206
					setLoop: -1
					loop: 2
					setCycle: Walk
					cycleSpeed: 0
					setScript: 0
				)
				(local2 cycleSpeed: 0)
				(HandsOn)
				(proc11_2 1)
			)
		)
	)
)

(instance gCS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Walk setLoop: 6 setMotion: MoveTo 207 60 self)
			)
			(1
				(client setLoop: 9 setMotion: MoveTo 278 90 self)
			)
			(2
				(gEgo cue:)
				(client setLoop: 0 setMotion: MoveTo 207 60 self setCycle: Walk)
			)
			(3
				(client setLoop: 5 setMotion: MoveTo 193 66 self)
			)
			(4
				(client setLoop: 1 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance aCup of View
	(properties
		y 152
		x 283
		view 11
		cel 4
		priority 15
		signal 16657
	)
)

(instance cV of View
	(properties
		y 152
		x 273
		view 11
		cel 5
		priority 15
		signal 16657
	)
)

(instance wTDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc11_2 0)
				(local2
					setLoop: 1
					ignoreActors:
					ignoreControl: -32768
					setPri: -1
					setCycle: Beg self
				)
			)
			(1
				(HandsOff)
				(if (== (gEgo view:) 11)
					(gEgo setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo
					view: 206
					setCycle: Walk
					setMotion: MoveTo 263 158 self
				)
				(local2
					view: 212
					setCycle: Walk
					setLoop: -1
					z: 0
					setMotion: MoveTo 267 158 self
				)
			)
			(3 0)
			(4
				(gEgo setMotion: MoveTo 151 158 self)
				(barSong client: 0 fade:)
				(local2
					ignoreActors:
					observeControl: -32768
					setMotion: Follow gEgo
				)
			)
			(5
				(gEgo setMotion: MoveTo 134 167 self)
				(tahiti flags: (| (tahiti flags:) $1000))
			)
			(6
				(gCurRoom newRoom: 199) ; danceRm
			)
		)
	)
)

(instance aSS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local2 ignoreActors: 1 setMotion: MoveTo 179 159 self)
			)
			(1
				(local2 setMotion: MoveTo 238 159 self)
			)
			(2
				(local2 ignoreControl: -32768 setMotion: MoveTo 288 154 self)
			)
			(3
				(local2
					view: 211
					setLoop: 1
					setCel: 0
					posn: 288 169 15
					setCycle: End self
				)
			)
			(4
				(local2
					setScript: aS
					observeControl: -32768
					setPri: 15
					stopUpd:
				)
				(proc11_2 1)
			)
		)
	)
)

(instance lush of Act
	(properties
		y 98
		x 145
		z 15
		view 511
		loop 4
		signal 1
		illegalBits 0
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(< loop 7)
				(not (cOS client:))
				(< (cOS state:) 1)
				(gEgo inRect: 129 90 177 115)
				(== (gEgo view:) 206)
				local6
			)
			(proc822_0 self cOS)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk[/woman,woman,lisa]')
				(cond
					((> (lDS state:) 8)
						(Print 11 22) ; "She's in no shape to talk."
					)
					((== (gEgo view:) 206)
						(self cue:)
						(if (not (cOS client:))
							(proc822_0 self cOS)
						)
					)
					(else
						(localproc_1 611 52 55)
					)
				)
			)
			(
				(or
					(Said 'buy,order/drink,(tai<mai)/woman,lisa')
					(Said 'buy,order/drink,(tai<mai)<woman,lisa')
					(Said 'buy,order/tai<mai')
				)
				(++ local0)
				(cond
					((and (bartender script:) ((bartender script:) next:))
						(Print 11 23) ; "The bartender is busy right now."
					)
					((& (tahiti flags:) $0002)
						(Print 11 24) ; "Don't you think she's had enough?"
					)
					((> (gEgo distanceTo: self) 60)
						(proc0_34) ; "You're not close enough."
					)
					(else
						(QueScript bartender bDS 0 lush)
					)
				)
			)
			((> (lDS state:) 8))
			((Said 'look[<at][/woman,lisa]')
				(if (== (gEgo view:) 511)
					(localproc_1 611 50 51)
				else
					(localproc_1 611 48 49)
				)
			)
			((or (> (gEgo distanceTo: self) 60) (< x 10)))
			((Said 'ask,get/name[<woman]')
				(localproc_1 611 45 47)
			)
			((or (Said 'dance') (Said '/woman,woman,lisa'))
				(localproc_1 611 56 63)
			)
		)
	)
)

(instance cOS of Script
	(properties)

	(method (doit)
		(if (not (gEgo inRect: 129 90 177 115))
			(= start state)
			(self dispose:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 11 25) ; "Her face slightly flushed, the young blonde lady says..."
				(Print 11 26) ; "HI, big fella, sit and join me. I'm drinking Mai Tais."
				(= seconds 10)
			)
			(1
				(Print 11 27) ; "Oh, HI," she says, " Please sit down."
				(= seconds 10)
			)
			(2
				(Print 11 28) ; "Coyly she asks, "Would you like to join me? I'm having a Mai Tai.""
				(= seconds 10)
			)
			(3
				(self init:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'talk[/woman,lisa]')
				(self cue:)
			)
		)
	)
)

(instance lDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(++ register)
				(lush loop: 5 setCycle: End)
				(= seconds 2)
			)
			(1
				(lush setCycle: Beg)
				(= seconds 5)
			)
			(2
				(if (> register (Random 2 4))
					(= cycles 2)
				else
					(self init:)
				)
			)
			(3
				(lush setCycle: End self)
			)
			(4
				(lush loop: 6 cel: 0)
				(= seconds 5)
			)
			(5
				(lush loop: 5 setCycle: Beg self)
			)
			(6
				(lush loop: 6 setCycle: End self)
			)
			(7
				(if (or (== (bartender script:) bDS) (!= (gCurRoom curPic:) 11))
					(self init:)
				else
					(bB init:)
					(QueScript bartender bDS 0 lush)
				)
			)
			(8
				(++ local0)
				(bB dispose:)
				(lush loop: 5 setCycle: Beg)
				(Animate (gCast elements:) 0)
				(if
					(and
						(>= local0 4)
						(not (& (tahiti flags:) $0010))
						(== (gEgo view:) 511)
					)
					(tahiti flags: (| (tahiti flags:) $0010))
					(= cycles 2)
				else
					(= register 0)
					(self init: client)
				)
			)
			(9
				(if (>= local1 4)
					(gEgo setScript: eTDS)
				)
				(cOS dispose:)
				(tahiti flags: (| (tahiti flags:) $0002))
				(lush
					ignoreActors: 1
					illegalBits: 0
					posn: 145 106 0
					loop: 7
					setCycle: End self
				)
				(lAV dispose:)
			)
			(10
				(stars init: setCycle: ForwardCounter 20 self)
				((= local7 (ScriptID 359)) init:) ; iC
			)
			(11
				(stars dispose:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'help[/woman,lisa]')
				(if (and (>= local1 4) (OneOf state 9 10 11))
					(gEgo setScript: eTDS)
				else
					(Print 11 29) ; "At this point she is beyond your help."
				)
			)
			((or (Said '(get<up),stand[<up]') (Said 'exit/stool'))
				(cond
					((== (lush loop:) 7)
						(Print 11 30) ; "Keep your seat, the bartender has already called someone for this inebriated lady."
					)
					(local1
						(Print 11 31) ; "The lady says, "Buy us another round first, big boy.""
						(++ local0)
						(HandsOff)
						(QueScript bartender bDS 0 gEgo)
					)
					((== (gEgo view:) 206)
						(Print 11 32) ; "You are standing."
					)
					(else
						(gEgo setScript: eSStandS)
					)
				)
			)
			((Said 'look[<at][/woman,lisa]')
				(if (OneOf state 9 10 11)
					(Print 11 33) ; "You see a pathetically drunk young lady."
				else
					(Print 11 34) ; "You see a lady who seems more interested in drinking than talking."
				)
			)
		)
	)
)

(instance stars of Prop
	(properties
		y 96
		x 130
		view 611
		loop 1
	)
)

(instance bDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 5
					illegalBits: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(if (== register lush)
							(+ 15 (lush x:))
						else
							(gEgo x:)
						)
						(bartender y:)
						self
				)
			)
			(1
				(client setLoop: 1 setCycle: End self)
			)
			(2
				(client setLoop: 2 setCycle: Fwd)
				(= cycles 8)
			)
			(3
				(client setLoop: 3 setCycle: End self)
			)
			(4
				(client setLoop: 3 setCycle: Beg self)
			)
			(5
				(cond
					((== register gEgo)
						(++ local1)
						(gEgo setScript: eDS)
					)
					((!= (lush script:) lDS)
						(lush setScript: lDS)
					)
					(else
						(lush cue:)
					)
				)
				(client loop: 1 setCycle: End self)
			)
			(6
				(client setLoop: 6 setCycle: Walk setMotion: MoveTo 193 66 self)
			)
			(7
				(client setLoop: 1 cel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance eDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOn)
				(User canControl: 0)
				(if (>= local1 4)
					(gEgo setScript: eTDS)
				else
					(gEgo view: 511 cycleSpeed: 2 setLoop: 3 setCycle: End)
					(++ register)
					(= seconds 2)
				)
			)
			(1
				(gEgo setCycle: Beg)
				(= seconds (Random 5 10))
			)
			(2
				(if (< register 5)
					(self init:)
				)
			)
		)
	)

	(method (dispose)
		(gEgo cycleSpeed: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'drink')
				(if (>= register 5)
					(Print 11 35) ; "Your glass is empty."
				else
					(self init:)
				)
			)
		)
	)
)

(instance eTDS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 611 loop: 3 setCycle: End self)
			)
			(1
				(EgoDead 907 1 0 11 36) ; "Driving the porcelain sub, Johnny?"
			)
		)
	)
)

(instance bB of View
	(properties
		y 66
		x 162
		view 611
		loop 2
		priority 15
		signal 273
	)
)

(instance lAV of View
	(properties
		y 106
		x 145
		view 511
		loop 2
		cel 3
	)
)

(instance eSSS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc11_2 0)
				(HandsOff)
				(if (< (gEgo x:) (register x:))
					(gEgo
						ignoreControl: -32768
						ignoreActors:
						setMotion:
							MoveTo
							(- (register x:) 9)
							(+ (register y:) 3)
							self
					)
				else
					(gEgo
						ignoreControl: -32768
						setMotion:
							MoveTo
							(+ (register x:) 9)
							(+ (register y:) 3)
							self
					)
				)
			)
			(1
				(gEgo
					view: 511
					loop: (if (< (gEgo x:) (register x:)) 0 else 1)
					posn: (register x:) (register y:)
					heading: 0
					setCycle: End self
				)
			)
			(2
				(if (cOS client:)
					(cOS dispose:)
				)
				(= local6 0)
				(proc11_2 1)
				(HandsOn)
				(User canControl: 0)
			)
		)
	)
)

(instance eSStandS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc11_2 0)
				(gEgo loop: 0 setCycle: Beg self)
			)
			(1
				(register show:)
				(gEgo
					view: 206
					loop: 3
					heading: 0
					setLoop: -1
					posn: (- (gEgo x:) 9) (+ (gEgo y:) 3)
					setCycle: Walk
					observeControl: -32768
					ignoreActors: 0
					setScript: (and (>= local1 4) eTDS)
				)
				(if (IsObject local7)
					(HandsOff)
				else
					(User canControl: 1)
				)
				(proc11_2 1)
			)
		)
	)
)

(instance bartender of Act
	(properties
		y 66
		x 193
		view 411
		loop 1
	)

	(method (init)
		(super init:)
		(self ignoreControl: -32768 ignoreActors: stopUpd:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/bartender]')
				(Print 611 (+ 0 (Random 0 1) (if (Random 0 9) 2 else 0)))
			)
			(
				(or
					(Said
						'buy,order/((drink,beer,beer,cocktail[<!*]),(mai<tai))[/!*]'
					)
					(Said 'ask/bartender/drink,beer,beer,cocktail,(mai<tai)')
				)
				(if (== (gEgo view:) 206)
					(Print 11 37) ; "You'll have to find a stool first."
				else
					(HandsOff)
					(QueScript self bDS 0 gEgo)
				)
			)
			((Said 'ask,get/name[<bartender]')
				(Print 11 38) ; ""I don't socialize with the customers, sir," the bartender replies."
			)
			((Said 'talk/bartender')
				(localproc_1 611 4 8)
			)
			((or (Said 'pay/man,bartender') (Said 'pay/tab'))
				(localproc_1 611 9 10)
			)
		)
	)
)

(instance mFF of RPicView
	(properties
		y 179
		x 233
		view 11
		loop 9
		priority 15
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman]>')
				(cond
					((Said 'look[<at]')
						(Print 11 39) ; "A woman having a drink."
					)
					((> (gEgo distanceTo: self) 40))
					((Said 'talk')
						(Print 11 40) ; "She doesn't answer."
					)
				)
			)
		)
	)
)

(instance wife of Extra
	(properties
		y 160
		x 230
		z 10
		view 11
		loop 3
		priority 10
		signal 528
		cycleType 2
		hesitation 15
		minPause 55
		maxPause 200
		minCycles 1
		maxCycles 1
	)

	(method (handleEvent event)
		(wF handleEvent: event)
	)
)

(instance wF of RFeature
	(properties
		y 144
		x 232
		z 15
		heading 270
		nsTop 118
		nsLeft 227
		nsBottom 140
		nsRight 238
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman]>')
				(cond
					((Said 'look[<at]')
						(if (and (== (husband view:) 11) (== (husband loop:) 5))
							(localproc_1 611 66 67)
						else
							(localproc_1 611 64 65)
						)
					)
					((> (gEgo distanceTo: wife) 49))
					((Said 'talk')
						(localproc_1 611 68 70)
					)
					((or (Said 'dance') (Said 'ask/*/dance'))
						(localproc_1 611 71 76)
					)
					((Said 'kiss,fuck,suck')
						(localproc_1 611 77 79)
					)
					((Said 'buy,order[/woman]/drink')
						(Print 11 41) ; "I already have one, thank you."
					)
				)
			)
			((Said 'ask/woman,name/name[<woman]')
				(Print 11 42) ; "I'm sorry," she tells you, "But I don't divulge that information!"
			)
			((or (Said 'dance,ask[/woman][/dance]') (Said '/woman'))
				(localproc_1 611 71 76)
			)
		)
		(cond
			(
				(or
					(not (event claimed:))
					(!= (event type:) evSAID)
					(> (gEgo distanceTo: wife) 49)
					(& (tahiti flags:) $0010)
				)
				0
			)
			((not (husband script:))
				(husband setScript: hS)
			)
			((== (husband view:) 11)
				(hS cue:)
			)
		)
	)
)

(instance mIBF of RPicView
	(properties
		y 181
		x 176
		view 11
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man]>')
				(cond
					((Said 'look[<at]')
						(Print 11 43) ; "A man having a drink."
					)
					((> (gEgo distanceTo: self) 40))
					((Said 'talk')
						(localproc_1 611 95 107)
					)
				)
			)
		)
	)
)

(instance lABTE of Extra
	(properties
		y 120
		x 225
		view 511
		loop 8
		cycleType 2
		hesitation 15
		minPause 80
		maxPause 200
		minCycles 1
		maxCycles 1
	)

	(method (handleEvent event)
		(lABF handleEvent: event)
	)
)

(instance lABF of RFeature
	(properties
		y 98
		x 226
		heading 90
		nsTop 78
		nsLeft 218
		nsBottom 118
		nsRight 234
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man,local]')
				(Print 11 44) ; "A local having a drink."
			)
			((Said 'talk[/man,local]')
				(localproc_1 611 95 107)
			)
		)
	)
)

(instance pP of PV
	(properties
		y 54
		x 95
		view 11
	)
)

(instance tP of PV
	(properties
		y 155
		x 205
		view 11
		loop 1
	)
)

(instance sV of View
	(properties
		y 106
		x 169
		heading 180
		view 11
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((> (gEgo distanceTo: self) 60))
			((Said 'sit')
				(if (== (gEgo view:) 206)
					(gEgo setScript: eSSS 0 self)
				else
					(Print 11 45) ; "You already are seated."
				)
			)
			((Said 'stand,(get<up)')
				(cond
					((== (gEgo view:) 206)
						(Print 11 46) ; "You already are standing."
					)
					((== (lush loop:) 7)
						(event claimed: 0)
					)
					((and local0 local1)
						(event claimed: 0)
						(eDS handleEvent: event)
					)
					(else
						(gEgo setScript: eSStandS 0 self)
					)
				)
			)
		)
	)
)

(instance lSV of View
	(properties
		y 106
		x 145
		heading 180
		view 11
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/stool]')
				(if (== (gEgo view:) 206)
					(Print 11 47) ; "An empty stool."
				else
					(Print 11 48) ; "A stool."
				)
			)
			((> (gEgo distanceTo: self) 60))
			((Said 'sit')
				(if (== (gEgo view:) 206)
					(gEgo setScript: eSSS 0 self)
				else
					(Print 11 45) ; "You already are seated."
				)
			)
			((Said 'stand')
				(if (== (gEgo view:) 206)
					(Print 11 46) ; "You already are standing."
				else
					(gEgo setScript: eSStandS 0 self)
				)
			)
		)
	)
)

(instance hCPV of PV
	(properties
		y 146
		x 169
		heading 90
		view 11
		loop 6
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((> (gEgo distanceTo: self) 40))
			((Said 'sit')
				(if (== (husband view:) 11)
					(localproc_1 611 92 94)
				else
					(localproc_1 611 80 83)
				)
			)
		)
	)
)

(instance cP of PV
	(properties
		y 167
		x 295
		view 211
		loop 2
	)
)

(instance lAB of Prop
	(properties
		y 98
		x 98
		z 15
		view 611
		signal 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/woman]')
				(Print 11 49) ; "A woman sitting at the bar."
			)
			((!= (gEgo view:) 206))
			((> (gEgo distanceTo: self) 40))
			(
				(and
					(< (gEgo x:) x)
					(or
						(Said '/woman,woman')
						(Said 'talk,dance[/woman,woman]')
						(Said 'buy,order/drink[<woman][/woman]')
					)
				)
				(self setCycle: End self)
			)
		)
	)

	(method (cue)
		(self cel: 0 stopUpd:)
	)
)

(instance lABAP of PV
	(properties
		y 106
		x 98
		view 511
		loop 2
	)
)

(instance mAB of RPicView
	(properties
		y 105
		x 121
		view 511
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/man]')
				(Print 11 50) ; "A man sitting at the bar."
			)
			((Said 'hit/man')
				(Print 11 51) ; "That's not a good idea."
			)
			((> (gEgo distanceTo: self) 40))
			((Said 'talk[/man]')
				(localproc_1 611 95 107)
			)
		)
	)
)

(instance pPV of RPicView
	(properties
		y 96
		x 45
		view 611
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/plant]')
				(Print 11 52) ; "You see a nice fern in the corner of the bar."
			)
		)
	)
)

(instance cPPV of RPicView
	(properties
		y 179
		x 206
		view 811
		loop 6
		priority 15
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flower,centerpiece]>')
				(cond
					((Said 'look[<at]')
						(Print 11 53) ; "A small vase with fresh plumaria blossoms is in the center of the table."
					)
					((> (gEgo distanceTo: self) 40))
					((Said 'smell')
						(Print 11 54) ; "The beautiful fragrance of plumaria fills the room."
					)
				)
			)
		)
	)
)

(instance mirror of RFeature
	(properties
		y 63
		x 260
		nsTop 46
		nsLeft 234
		nsBottom 81
		nsRight 287
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,in][/mirror]')
				(Print 11 55) ; "You look into the mirror and see your happy reflection smiling back at you."
			)
			((or (Said 'break/mirror') (Said 'throw/*/mirror'))
				(proc0_41) ; "That is not a good idea."
			)
		)
	)
)

(instance eCC of Code
	(properties)

	(method (doit param1 param2)
		(if (param1 isKindOf: Extra)
			(if param2
				(param1 startExtra:)
			else
				(param1 stopExtra:)
			)
		)
	)
)

