;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 332)
(include sci.sh)
(use Main)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Inventory)
(use Menu)
(use Actor)
(use System)

(public
	rm332 0
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
	[local9 2] = [{Mighty careless of you to walk right in front of that knife!  Or did the Chief Thief hit you on purpose?  Or did you just discover an obscure bug in the program???  Maybe you'll never really know. } {You can't believe the Chief Thief's reflexes as he instantly reacts to your intention to pull a fast one.  A dagger flies like lightning and.... }]
	[local11 2] = [{Trouble with sharp, pointy objects} {These guys are MEAN!}]
	[local13 7] = [250 40 75 30 25 100 35]
)

(procedure (localproc_0)
	(HighPrint 332 0) ; "This dark, seedy place is less than you expected of a Thieves' Guild."
	(HighPrint 332 1) ; "The man seated by the table greets you with a scowl; Crusher is his usual, amiable self; and you can't quite make out what lurks behind that massive door."
	(HighPrint 332 2) ; "You feel uneasy about the sinister mood here."
)

(procedure (localproc_1)
	(HighPrint 332 3) ; "I don't have time to talk to unlicensed scum. Pay your guild license fee, and then we can talk."
)

(procedure (localproc_2)
	(if local2
		(return 0)
	else
		(knifeScript changeState: 1)
		(return 1)
	)
)

(instance rm332 of Rm
	(properties
		picture 332
		style 5
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 99)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 332 338 509 503)
		(LoadMany rsSOUND (SoundFX 31) (SoundFX 29) (SoundFX 30))
		(super init:)
		(gMouseHandler add: self)
		(SolvePuzzle 638 5 2)
		(dagMusic number: (SoundFX 31) init:)
		(self setLocales: 801)
		(SL enable:)
		(NormalEgo)
		(= local3 100)
		(= local4 7)
		(= gPerspective 70)
		(gAddToPics add: board Boris eachElementDo: #init doit:)
		(chiefThief init:)
		(throwingArm init:)
		(chair init: setPri: 12 hide:)
		(crusher init: stopUpd:)
		(foot init: setScript: footScript)
		(knife
			ignoreActors:
			init:
			setPri: 13
			setLoop: 7
			setCycle: Fwd
			stopUpd:
			hide:
			setScript: knifeScript
		)
		(if (== gPrevRoomNum 340) ; dagNabIt
			(gEgo posn: 230 139 loop: 2 init:)
			(chiefThief setScript: chiefBored)
		else
			(self setScript: rm332EntranceScript)
		)
	)

	(method (doit)
		(cond
			(local2
				(if
					(<=
						(= local3
							(GetDistance
								(gEgo x:)
								(- (gEgo y:) 30)
								(knife x:)
								(knife y:)
								gPerspective
							)
						)
						local4
					)
					(gEgo setScript: deathScript)
				)
			)
			((and local7 (not local0) (== (knifeScript state:) 0))
				(= local0 1)
				(localproc_2)
			)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 60])
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'fight,hit,cut,kill[/*]')
					(Said 'throw/boulder,dagger')
					(Said 'cast')
				)
				(HandsOff)
				(= local7 1)
			)
			((Said 'help,rule')
				(proc341_0)
			)
			(
				(or
					(Said 'bet,dagnabit')
					(Said 'play/!*,game,dagnabit,dagger,dart')
				)
				(gCurRoom newRoom: 340) ; dagNabIt
			)
			((Said 'climb,done')
				(self setScript: leaveRoomScript)
			)
			((Said 'rest,nap')
				(HighPrint 332 4) ; "What do you think this is, your home? Crusher, deal with this deadbeat."
				(self setScript: throwEgoOut)
			)
			((Said 'open/door')
				(if (gEgo inRect: 150 115 205 125)
					(HighPrint 332 5) ; "The door is locked, and Boris won't let you in."
				else
					(event claimed: 0)
				)
			)
			((Said 'lockpick')
				(HighPrint 332 6) ; "Picking locks in the Thieves' Guild is a singularly stupid idea."
			)
			((Said 'talk>')
				(cond
					((Said '/man,people,thief')
						(cond
							((gEgo inRect: 75 113 140 140)
								(HighPrint 332 7) ; "Crusher ignores you."
							)
							((gEgo inRect: 150 115 205 125)
								(if (not (gEgo has: 25)) ; thief certificate
									(HighPrint 332 8) ; "A Thief's license will cost you 25 silvers. You will need a license to use any of our services."
								else
									(HighPrint 332 9) ; "Perhaps I could sell you a good lockpick for fifteen silvers, or a wonderful Acme Thief Tool Kit for one hundred silvers."
								)
							)
							(else
								(HighPrint 332 10) ; "I have no time for idle talk. Why don't you do something constructive like stealing Otto's yo-yo?"
							)
						)
					)
					((Said '/bouncer,goon,ogre')
						(HighPrint 332 7) ; "Crusher ignores you."
					)
					((Said '/boris,fence,cashier,item,creature')
						(cond
							((not (gEgo inRect: 150 115 205 125))
								(HighPrint 332 11) ; "I can't hear you. Please come a little closer to the window."
							)
							((not (gEgo has: 25)) ; thief certificate
								(HighPrint 332 8) ; "A Thief's license will cost you 25 silvers. You will need a license to use any of our services."
							)
							(else
								(HighPrint 332 9) ; "Perhaps I could sell you a good lockpick for fifteen silvers, or a wonderful Acme Thief Tool Kit for one hundred silvers."
							)
						)
					)
					((not (gEgo has: 25)) ; thief certificate
						(localproc_1)
					)
					((Said '/boss,master')
						(HighPrint 332 10) ; "I have no time for idle talk. Why don't you do something constructive like stealing Otto's yo-yo?"
					)
				)
			)
			(
				(or
					(MouseClaimed chiefThief event 3)
					(Said 'look/man,boss,master,thief')
				)
				(HighPrint 332 12) ; "From his expensive clothes to his carefully trimmed mustache, there is an air of sophistication to this villain."
			)
			((or (MouseClaimed crusher event 3) (Said 'look/bouncer,ogre,goon'))
				(HighPrint 332 13) ; "Crusher is his usual, amiable self (every bit the Goon)."
			)
			(
				(or
					(MouseClaimed onGrate event 3)
					(Said 'look/window,door,gate,grate')
				)
				(HighPrint 332 14) ; "The opening in the door is covered with a wire grate, but there is space below it where objects can be passed through. The mysterious-looking man on the other side is Boris, the cashier and fence for the Guild."
			)
			((or (MouseClaimed onLadder event 3) (Said 'look/ladder,step'))
				(HighPrint 332 15) ; "The ladder up to the tavern is very sturdy. It has to be to support Crusher's weight."
			)
			(
				(or
					(MouseClaimed onBoard event 3)
					(Said 'look/board,game,dagnabit,daggerboard')
				)
				(HighPrint 332 16) ; "It looks like an oversized, well-used dartboard."
				(if (> local6 5)
					(HighPrint 332 17) ; "There sure are a lot of daggers in the board. You wonder where the Chief Thief keeps them all."
				)
			)
			((Said 'look>')
				(cond
					((Said '/fence,boris,door')
						(HighPrint 332 18) ; "The shadowy figure behind the door is Boris, the cashier and fence for the Guild."
					)
					((or (Said '/floor') (Said '<down'))
						(HighPrint 332 19) ; "The floor is surprisingly clean, compared to that of the bar upstairs."
					)
					((Said '/wall,plaster')
						(HighPrint 332 20) ; "The plaster is chipping in several places."
					)
					((Said '/ceiling,roof,up,ale,spill,mark')
						(HighPrint 332 21) ; "You can tell where the bar is by the seep marks of spilled beer."
					)
					((Said '/dart,dagger')
						(HighPrint 332 22) ; "The daggers are nicely made, and apparently designed for throwing. Besides the Chief Thief's seemingly endless collection, there are two matched sets with differently-colored hilts for playing Dag-Nab-It."
					)
					((Said '[<at,around][/!*,room,building]')
						(localproc_0)
					)
				)
			)
			((MouseClaimed onMug event 3)
				(HighPrint 332 23) ; "Even thieves get thirsty."
			)
			((MouseClaimed gEgo event 3)
				(HighPrint 332 24) ; "You're probably wondering if there is any honor among thieves."
			)
			((Said 'get/dagger,dagger,target')
				(HighPrint 332 25) ; "Stealing from a dagger-throwing thief? That's a dangerous (and stupid) idea!"
			)
			((or (Said 'pay,join') (Said 'buy,get/certificate'))
				(cond
					((not (gEgo inRect: 150 115 205 125))
						(HighPrint 332 26) ; "Go up to the window, please."
					)
					((gEgo has: 25) ; thief certificate
						(HighPrint 332 27) ; "Don't bother. You've already paid, stupid."
					)
					((Purchase 25)
						(gEgo get: 25) ; thief certificate
						(HighPrint 332 28) ; "Welcome to the Thieves' Guild Union, Local 1313."
						(SolvePuzzle 639 3 2)
					)
					(else
						(HighPrint 332 29) ; "I'm sorry, but you don't seem to have enough silver for your license. Come back when you qualify."
						(event claimed: 1)
					)
				)
			)
			((Said 'buy,get>')
				(cond
					((not (gEgo inRect: 150 115 205 125))
						(HighPrint 332 26) ; "Go up to the window, please."
						(event claimed: 1)
					)
					((not (gEgo has: 25)) ; thief certificate
						(HighPrint 332 30) ; "Our very special items are reserved for our guild members. No scabs allowed."
						(event claimed: 1)
					)
					((Said '/lockpick')
						(if (Purchase 15)
							(HighPrint 332 31) ; "There you are."
							(gEgo get: 23) ; lockpick
							(= global189 10)
						else
							(HighPrint 332 32) ; "We only deal in cash here."
						)
					)
					((Said '/kit[<thief,implement]')
						(if (Purchase 100)
							(gEgo get: 24) ; thief kit
							(= global189 35)
							(SolvePuzzle 640 3 2)
							(HighPrint 332 31) ; "There you are."
						else
							(HighPrint 332 32) ; "We only deal in cash here."
						)
					)
					(else
						(event claimed: 1)
						(HighPrint 332 33) ; "We only sell lockpicks and Thief Toolkits here."
					)
				)
			)
			((Said 'fence,sell>')
				(= temp2 [gInvNum (= temp1 (SaidInv event))])
				(cond
					((not (gEgo inRect: 150 115 205 125))
						(HighPrint 332 26) ; "Go up to the window, please."
					)
					((not (gEgo has: 25)) ; thief certificate
						(HighPrint 332 34) ; "We buy only from our members."
					)
					((or (not temp2) (not temp1))
						(HighPrint 332 35) ; "You can't fence something you don't have."
					)
					((or (< temp1 13) (> temp1 19))
						(HighPrint 332 36) ; "We have no interest in those."
					)
					(else
						(= temp0 (* temp2 [local13 (- temp1 13)]))
						(= [gInvNum temp1] 0)
						(+= [gInvNum 1] temp0) ; silver
						(HighPrint 332 37) ; "Let's see now... deducting the Guild cut, and allowing for resale markup, that comes to..."
						(HighPrint (Format @temp3 332 38 temp0)) ; "%d silvers. Here you are."
						(HighPrint
							(Format @temp3 332 39 [gInvNum 2] [gInvNum 1]) ; "You now have %d gold and %d silver coins.", gold, silver
						)
						(SolvePuzzle 641 3 2)
					)
				)
			)
		)
	)
)

(instance chiefThief of Act
	(properties
		y 164
		x 233
		view 332
		loop 2
		priority 13
		illegalBits 0
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(if (Said 'ask>')
					(cond
						((not (gEgo has: 25)) ; thief certificate
							(event claimed: 1)
							(localproc_1)
						)
						((Said '/dagger,throw')
							(HighPrint 332 40) ; "A dagger is a thief's best friend, and throwing from a distance is the safest and best way to use it. If you think you are good enough, perhaps we could play a little game."
						)
						((Said '/board')
							(HighPrint 332 41) ; "We use the specially designed Dag-Nab-It board you can see there on the wall."
						)
						((Said '/game,dagnabit,practice,play,rule')
							(proc341_0)
						)
						((Said '/bet')
							(HighPrint 332 42) ; "We could start small, perhaps five silvers a game, perhaps even less. Of course, we can wager more if you think you can take me."
						)
						((Said '/thief,grab,stealing')
							(HighPrint 332 43) ; "There are only a few members of our Guild still around here. With the snow and the brigands keeping away the tourists, it's hard to earn a decent living."
						)
						((Said '/club,club,member')
							(HighPrint 332 44) ; "Where else but here can one mingle freely with others of our chosen profession, sharing tips and secrets? Where else can you safely fence stolen items?"
							(HighPrint 332 45) ; "Where else can you ask questions like these and not get thrown into jail or attacked? The Guild is truly your home away from home."
						)
						((Said '/fink')
							(HighPrint 332 46) ; "Those who do not pay their union dues are the lowest form of life."
						)
						((Said '/due,due,cost')
							(HighPrint 332 8) ; "A Thief's license will cost you 25 silvers. You will need a license to use any of our services."
						)
						((Said '/advice')
							(HighPrint 332 47) ; "My advice is, don't get caught."
						)
						((Said '/secret')
							(HighPrint 332 48) ; "Now that would be telling."
						)
						((Said '/fence,sale,loot,item')
							(HighPrint 332 49) ; "Just give your stolen items to Boris and you will be suitably recompensed. Or, in terms more suited to your apparent intellect, you get cash for your loot."
						)
						((Said '/boris')
							(HighPrint 332 50) ; "Boris is our accountant."
						)
						((Said '/bouncer,goon')
							(HighPrint 332 51) ; "Crusher is our personnel manager."
						)
						((Said '/otto')
							(HighPrint 332 52) ; "Otto is the Sheriff's goon. He shouldn't give you any trouble unless you happen to stand in his way."
						)
						((Said '/meisterson')
							(HighPrint 332 53) ; "The Sheriff provides a useful service in this town. He arrests anyone too stupid or unlucky to be a good thief."
						)
						((Said '/name,boss,master')
							(HighPrint 332 54) ; "I am known as 'The Chief'. But you can call me 'Chief'."
						)
						((Said '/bandit')
							(HighPrint 332 55) ; "These non-union cretins are giving thieves a bad name. I'm sure they have a spy planted in our organization, but I don't know who it is."
						)
						((Said '/spy')
							(HighPrint 332 56) ; "There is certainly a traitor in our midst."
						)
						((Said '/hamlet,hamlet')
							(HighPrint 332 57) ; "There are a few places around town where a clever and skilled thief can make some silver. Perhaps even you could steal something."
						)
						((Said '/stealing,stealing,labor')
							(HighPrint 332 58) ; "I have had beginners before, but this Guild reached a new low when you joined. Child, you are a thief. Stealing is how you make a living. So go out there and steal something and hopefully you'll get, umm, that is, you *won't* get caught."
						)
						((Said '/hasp,lockpick,implement,kit')
							(HighPrint 332 59) ; "We will gladly sell you a lock pick for a modest fee. However, for the true professional, nothing will do but the Guild-Approved Acme Thief Tool Kit. This kit will allow you to pick anything with a little practice, and is a real steal at only one hundred silvers. Just talk to Boris."
						)
						(else
							(event claimed: 1)
							(HighPrint 332 60) ; "Now that has to be one of the stupidest things anyone has ever asked me."
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance rm332EntranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc997_1 0)
				(EgoGait 0 0) ; walking
				(gEgo
					illegalBits: 0
					view: 509
					setLoop: 3
					cel: 0
					posn: 77 143
					init:
				)
				(if (not (IsFlag 99))
					(localproc_0)
				)
				(gEgo cycleSpeed: 2 setCycle: End self)
			)
			(1
				(localproc_2)
				(gEgo
					view: 0
					loop: 0
					cel: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 150 145 self
				)
			)
			(2
				(if (IsFlag 99)
					(self changeState: 40)
				)
				(gEgo setMotion: MoveTo 220 130 self)
			)
			(3
				(throwingArm hide:)
				(knife hide:)
				(chiefThief setLoop: 2 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(gEgo view: 509 setLoop: 0 cel: 0)
				(head posn: 220 97 setPri: 11 setCel: 2 ignoreActors: init:)
				(chair show:)
				(chiefThief
					setLoop: 1
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion: MoveTo 220 164 self
				)
			)
			(5
				(head setCel: 1)
				(TimePrint 5 332 61) ; "Beginners! Why do they keep giving me beginners?"
				(chiefThief setMotion: MoveTo 180 164 self)
			)
			(6
				(head setCel: 0)
				(chiefThief setMotion: MoveTo 150 164 self)
			)
			(7
				(chiefThief setLoop: 0 setMotion: MoveTo 190 164 self)
			)
			(8
				(TimePrint 10 332 62) ; "I tell you, Crusher, that a thief of my stature and abilities should be stuck in a podunk town besieged by brigands who aren't even Union Members is the height of injustice!"
				(chiefThief setLoop: 1 setMotion: MoveTo 120 164 self)
			)
			(9
				(chiefThief setLoop: 0 setMotion: MoveTo 190 164 self)
			)
			(10
				(chiefThief setMotion: MoveTo 233 164 self)
			)
			(11
				(head setCel: 1)
				(chair hide:)
				(chiefThief setLoop: 2 cycleSpeed: 1 cel: -1 setCycle: Beg self)
			)
			(12
				(throwingArm show:)
				(chiefThief cycleSpeed: 0 moveSpeed: 0)
				(localproc_2)
				(head dispose:)
				(gEgo loop: 2 cel: 0)
				(HandsOn)
				(NormalEgo)
				(= seconds 3)
			)
			(13
				(HighPrint 332 63) ; "It will cost you 25 silvers to work in town. Just pay Boris at the door. If you don't have the cash, go steal something."
				(self changeState: 40)
			)
			(40
				(NormalEgo)
				(HandsOn)
				(chiefThief setScript: chiefBored)
				(client setScript: 0)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 80 146 self)
			)
			(1
				(gEgo
					view: 509
					setLoop: 3
					cel: -1
					cycleSpeed: 2
					posn: 77 143
					setCycle: Beg self
				)
			)
			(2
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 15)
				(gCurRoom newRoom: 331)
			)
		)
	)
)

(instance throwEgoOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(foot hide: stopUpd:)
				(crusher view: 338 setLoop: 1 cycleSpeed: 1 setCycle: End self)
			)
			(1
				(crusher cel: 2)
				(= cycles 3)
			)
			(2
				(crusher setCycle: End self)
			)
			(3
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(4
				(SetFlag 117)
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance chiefBored of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 8))
			)
			(1
				(localproc_2)
				(self changeState: 0)
			)
		)
	)
)

(instance footScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (Random 3 6))
				(foot cycleSpeed: local1 setCycle: Fwd)
				(= seconds (Random 2 5))
			)
			(1
				(foot setCycle: 0 cel: 0)
				(= seconds (Random 5 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance knifeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(throwingArm cel: 5)
				(knife cel: 0 posn: 223 133)
				(chiefThief setLoop: 2 cel: 0)
			)
			(1
				(chiefThief setLoop: 5 cel: 0)
				(= cycles 1)
			)
			(2
				(throwingArm cel: 0 cycleSpeed: 2 setCycle: CT 3 1 self)
			)
			(3
				(knife show:)
				(throwingArm cel: 4)
				(= cycles 1)
			)
			(4
				(= local2 1)
				(throwingArm cel: 5)
				(dagMusic number: (SoundFX 31) play:)
				(if local7
					(knife setMotion: MoveTo (gEgo x:) (- (gEgo y:) 30))
				else
					(knife
						setMotion: MoveTo (Random 130 146) (Random 78 92) self
					)
				)
			)
			(5
				(dagMusic stop:)
				(dagMusic
					number:
						(if (Random 0 1)
							(SoundFX 30)
						else
							(SoundFX 29)
						)
					play:
				)
				(= local2 0)
				(if (< local8 12)
					((View new:)
						view: 332
						loop: 3
						cel: 4
						setPri: 8
						posn: (knife x:) (knife y:)
						init:
						stopUpd:
						addToPic:
					)
					(++ local8)
				)
				(knife hide:)
				(= cycles 2)
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance deathScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(knife setMotion: 0 hide:)
				(gEgo
					view: 503
					posn: (+ (gEgo x:) 5) (gEgo y:)
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: CT 5 1
				)
				(= cycles 15)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(EgoDead [local9 local7] 80 [local11 local7] 82 800 0 0)
			)
		)
	)
)

(instance throwingArm of Prop
	(properties
		y 137
		x 234
		view 332
		loop 6
		cel 5
		priority 12
	)
)

(instance board of PV
	(properties
		y 85
		x 138
		view 332
		loop 3
		cel 3
		priority 6
	)
)

(instance crusher of Prop
	(properties
		y 122
		x 111
		view 332
		loop 3
		cel 1
	)
)

(instance Boris of PV
	(properties
		y 89
		x 176
		view 332
		loop 3
		cel 2
	)
)

(instance foot of Prop
	(properties
		y 120
		x 118
		view 332
		loop 4
	)
)

(instance knife of Act
	(properties
		y 120
		x 118
		yStep 7
		view 332
		loop 7
		cycleSpeed 1
		illegalBits 0
		xStep 6
	)
)

(instance chair of View
	(properties
		y 164
		x 233
		view 332
		loop 3
	)
)

(instance head of View
	(properties
		view 509
		loop 1
		cel 1
	)
)

(instance onBoard of RFeature
	(properties
		nsTop 77
		nsLeft 126
		nsBottom 93
		nsRight 147
	)
)

(instance onGrate of RFeature
	(properties
		nsTop 69
		nsLeft 163
		nsBottom 89
		nsRight 189
	)
)

(instance onLadder of RFeature
	(properties
		nsTop 33
		nsLeft 56
		nsBottom 146
		nsRight 75
	)
)

(instance onMug of RFeature
	(properties
		nsTop 139
		nsLeft 214
		nsBottom 146
		nsRight 222
	)
)

(instance dagMusic of Sound
	(properties
		number 31
	)
)

